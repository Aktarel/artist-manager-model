package clientrest.deezer;


import generated.deezer.artist.Album;
import generated.deezer.artist.Artist;
import generated.deezer.artist.Data;
import generated.deezer.artist.ObjectFactory;
import generated.deezer.artist.Root;
import generated.deezer.artist.Track;

import java.net.MalformedURLException;
import java.net.URL;

import javax.ejb.Stateless;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import modele.Artiste;
import modele.Piste;

@Stateless
public class DeezerRestSearchImpl implements DeezerRestService {

	public Artiste getTrackStream(Artiste artiste) {
		
		try {
			URL url = new URL("http://api.deezer.com/search?q=" + artiste.getNom()
					+ "&output=xml");
			JAXBContext jctx;
			jctx = JAXBContext.newInstance(Album.class,Artist.class,ObjectFactory.class,Root.class,Data.class);
			Unmarshaller unmarcha = jctx.createUnmarshaller();
			Root base = (Root) unmarcha.unmarshal(url);
			

			for(Track t : base.getData().getTrack()){
				pistesModele : for(Piste piste : artiste.getListePiste()){
					if(piste.getNom().equals(t.getTitle())){
						piste.setUrlPreview(t.getPreview());
						piste.setIdDeezer(t.getId());
						break pistesModele;
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
		
		return artiste;
	}

}
