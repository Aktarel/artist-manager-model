package clientrest;

import generated.Image;
import generatedArtistInfo.Similar;
import generatedTrack.Artist;
import generatedTrack.Lfm;
import generatedTrack.Toptracks;
import generatedTrack.Track;

import java.net.URL;
import java.util.HashSet;
import java.util.Set;

import javax.ejb.Stateless;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.Unmarshaller;

import modele.Artiste;
import modele.Piste;

@Stateless
public class LastFMRestSearch implements LastFMRestService {

	

	
	public LastFMRestSearch() {
	}

	public Set<modele.Image> getImagesArtistes(String nom) {

		generated.Lfm lfm = null;
		URL urlScrobbler;
		Set<modele.Image> maListeImage = new HashSet<modele.Image>();

		try {
			urlScrobbler = new URL(
					"http://ws.audioscrobbler.com/2.0/?method=artist.getimages&artist="
							+ nom + "&api_key=71024afc70fde5c60b699995bb95ff82");
			JAXBContext jctx = JAXBContext.newInstance(generated.Lfm.class,
					generated.Owner.class, generated.Image.class);
			Unmarshaller unmarcha = jctx.createUnmarshaller();
			lfm = (generated.Lfm) unmarcha.unmarshal(urlScrobbler);

			if (lfm.getImages().getTotal().intValue() != 0) {
				for (Image mesImages : lfm.getImages().getImage()) {
					modele.Image monImage = new modele.Image();
					monImage.setUrl(mesImages.getSizes().getSize().get(0).getValue());
					monImage.setDateAjoute(mesImages.getDateadded());
					maListeImage.add(monImage);
				}
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return maListeImage;
	}

	public Set<Piste> getPistesArtistes(String nom) {
		{

			Lfm lfm = null;
			URL urlScrobbler;
			Set<Piste> maListePiste = new HashSet<Piste>();

			try {
				urlScrobbler = new URL(
						"http://ws.audioscrobbler.com/2.0/?method=artist.gettoptracks&artist="
								+ nom
								+ "&api_key=71024afc70fde5c60b699995bb95ff82");
				JAXBContext jctx = JAXBContext.newInstance(Lfm.class,
						Artist.class, Track.class, Toptracks.class);
				Unmarshaller unmarcha = jctx.createUnmarshaller();
				lfm = (Lfm) unmarcha.unmarshal(urlScrobbler);

				if (lfm.getToptracks().getTotal().intValue() != 0) {
					for (Track unePiste : lfm.getToptracks().getTrack()) {

						Piste maPiste = new Piste();
						maPiste.setNom(unePiste.getName());
						maPiste.setClassement(unePiste.getRank().intValue());
						maListePiste.add(maPiste);

					}
				}

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			return maListePiste;
		}

	}

	public modele.Artiste getDetailArtistInfo(String nom) {

		generatedArtistInfo.Lfm lfm = null;
		URL urlScrobbler;
		Artiste artiste = new Artiste();

		try {
			urlScrobbler = new URL(
					"http://ws.audioscrobbler.com/2.0/?method=artist.getInfo&artist="
							+ nom + "&api_key=71024afc70fde5c60b699995bb95ff82");
			JAXBContext jctx = JAXBContext.newInstance(
					generatedArtistInfo.Lfm.class,
					generatedArtistInfo.Artist.class,
					generatedArtistInfo.Bio.class);
			Unmarshaller unmarcha = jctx.createUnmarshaller();
			lfm = (generatedArtistInfo.Lfm) unmarcha.unmarshal(urlScrobbler);
			artiste.setDescription(lfm.getArtist().getBio().getContent());
			artiste.setNom(nom);
			
			for (Object objet : lfm.getArtist().getImageOrMbidOrName()) {
				if (objet.getClass().equals(Similar.class)) {
					Similar s = (Similar) objet;
					for(generatedArtistInfo.Artist a : s.getArtist()){
						artiste.appendSimilaire(((JAXBElement)a.getImageOrMbidOrName().get(0)).getValue().toString());
					}
				}
			}
			
			Set<Piste> mesPistes = getPistesArtistes(nom);
			Set<modele.Image> mesImages = getImagesArtistes(nom);
			
			for(Piste p : mesPistes)
				p.setArtiste(artiste);
			for(modele.Image i : mesImages)
				i.setArtiste(artiste);
			
			artiste.setListePiste(mesPistes);
			artiste.setListeImage(mesImages);
		} catch (Exception e) {
			e.printStackTrace();
		}

		
		
		return artiste;
	}

}
