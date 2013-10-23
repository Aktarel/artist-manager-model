package clientrest.deezer;

import javax.ejb.Local;

import modele.Artiste;



@Local
public interface DeezerRestService {

	public Artiste getTrackStream(Artiste artiste) ;
	
}
