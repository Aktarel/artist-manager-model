package clientrest.deezer;

import javax.ejb.Local;

import modele.Artiste;


//http://api.deezer.com/track/3135556?output=xml

@Local
public interface DeezerRestService {

	public Artiste getTrackStream(Artiste artiste) ;
	
}
