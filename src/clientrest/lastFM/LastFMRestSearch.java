package clientrest.lastFM;

import generated.LastFM.artistInfo.Similar;
import generated.LastFM.images.Image;
import generated.LastFM.track.Artist;
import generated.LastFM.track.Lfm;
import generated.LastFM.track.Toptracks;
import generated.LastFM.track.Track;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.concurrent.ConcurrentSkipListSet;

import javax.ejb.Stateless;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import modele.Artiste;
import modele.Piste;
import modele.Similaire;

import org.apache.log4j.Logger;

@Stateless
public class LastFMRestSearch implements LastFMRestService {

	public static int MAX_NB_IMAGE = 10;
	public static int MAX_NB_PISTE = 20;

	Logger log = Logger.getLogger(LastFMRestSearch.class);
	
	public LastFMRestSearch() {
	}

	@Deprecated
	// Abanddon de cette methode d'api depuis le : 21/08/2013
	public Set<modele.Image> getImagesArtistes(String nom) {

		generated.LastFM.images.Lfm lfm = null;
		int i = 0;
		URL urlScrobbler;
		Set<modele.Image> maListeImage = new HashSet<modele.Image>();

		try {
			urlScrobbler = new URL(
					"http://ws.audioscrobbler.com/2.0/?method=artist.getimages&artist="
							+ nom + "&api_key=71024afc70fde5c60b699995bb95ff82");
			JAXBContext jctx = JAXBContext.newInstance(generated.LastFM.images.Lfm.class,
					generated.LastFM.images.Owner.class, generated.LastFM.images.Image.class);
			Unmarshaller unmarcha = jctx.createUnmarshaller();
			lfm = (generated.LastFM.images.Lfm) unmarcha.unmarshal(urlScrobbler);

			if (lfm.getImages().getTotal().intValue() != 0) {
				itrationImages: for (Image mesImages : lfm.getImages()
						.getImage()) {
					if (i < MAX_NB_PISTE) {
						modele.Image monImage = new modele.Image();
						monImage.setUrl(mesImages.getSizes().getSize().get(0)
								.getValue());
						monImage.setDateAjoute(mesImages.getDateadded());
						maListeImage.add(monImage);
						i++;
					} else {
						break itrationImages;
					}
				}
			}

		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return maListeImage;
	}

	public SortedSet<Piste> getPistesArtistes(String nom) {
		{

			Lfm lfm = null;
			URL urlScrobbler;
			SortedSet<Piste> maListePiste = new ConcurrentSkipListSet<Piste>();
			int i = 0;

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
					itrationPistes: for (Track unePiste : lfm.getToptracks()
							.getTrack()) {
						if (i < MAX_NB_PISTE) {
							Piste maPiste = new Piste();
							maPiste.setNom(unePiste.getName());
							maPiste.setClassement(unePiste.getRank().intValue());
							maPiste.setNbListeners(unePiste.getListeners());
							maListePiste.add(maPiste);
							i++;
						} else {
							break itrationPistes;
						}
					}
				}
			} catch (JAXBException e) {
				e.printStackTrace();
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}

			return maListePiste;
		}

	}

	@SuppressWarnings("rawtypes")
	public modele.Artiste getDetailArtistInfo(String nom) {

		generated.LastFM.artistInfo.Lfm lfm = null;
		URL urlScrobbler;
		Artiste artiste = new Artiste();
		Set<modele.Image> mesImages = new HashSet<modele.Image>();
		
		try {
			urlScrobbler = new URL(
					"http://ws.audioscrobbler.com/2.0/?method=artist.getInfo&artist="
							+ nom + "&api_key=71024afc70fde5c60b699995bb95ff82");
			JAXBContext jctx = JAXBContext.newInstance(
					generated.LastFM.artistInfo.Lfm.class,
					generated.LastFM.artistInfo.Artist.class,
					generated.LastFM.artistInfo.Bio.class);
			Unmarshaller unmarcha = jctx.createUnmarshaller();
			lfm = (generated.LastFM.artistInfo.Lfm) unmarcha.unmarshal(urlScrobbler);
			artiste.setDescription(lfm.getArtist().getBio().getSummary());
			artiste.setNom(nom);

			if (lfm.getStatus() != "failed") {
				
				generated.LastFM.artistInfo.Artist currentArtist = (generated.LastFM.artistInfo.Artist) lfm.getArtist();
				generated.LastFM.artistInfo.Image img = ((generated.LastFM.artistInfo.Image)currentArtist.getImageOrMbidOrName().get(7));
				
				//log.error("IMG : "+img.getValue());
				mesImages.add( new modele.Image(img.getValue()));
				
				for (Object objet : lfm.getArtist().getImageOrMbidOrName()) {
					if (objet.getClass().equals(Similar.class)) {
						Similar s = (Similar) objet;
						for (generated.LastFM.artistInfo.Artist a : s.getArtist()) {
							Similaire similaire = new Similaire();
							// 7 = grande image de l'artiste dans le XML
							generated.LastFM.artistInfo.Image imageSimilaire = ((generated.LastFM.artistInfo.Image) a.getImageOrMbidOrName().get(6));
							similaire.setUrlImage(imageSimilaire.getValue());
							similaire.setNom(((JAXBElement) a.getImageOrMbidOrName().get(0)).getValue().toString());
							similaire.setArtiste(artiste);
							
							artiste.addSimilaire(similaire);
						}
					}
				}
			}
			SortedSet<Piste> mesPistes = getPistesArtistes(nom);
			//Set<modele.Image> mesImages = getImagesArtistes(nom);

			for (Piste p : mesPistes)
				p.setArtiste(artiste);
			for (modele.Image i : mesImages)
				i.setArtiste(artiste);

			artiste.setListePiste(mesPistes);
			artiste.setListeImage(mesImages);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return artiste;
	}

}