package clientrest.deezer;

import javax.ejb.Local;

import modele.Artiste;


/**
 * Interface du service rest de deezer
 * @author nicolas
 *
 */
@Local
public interface DeezerRestService {

	public Artiste getTrackStream(Artiste artiste) ;
	
}
