
package clientrest.lastFM;

import java.util.Set;
import java.util.SortedSet;

import javax.ejb.Local;

import modele.Artiste;
import modele.Evenement;
import modele.Image;
import modele.Piste;

/**
 * Interface pour interroger les services lastfm
 * @author nicolas
 *
 */
@Local
public interface LastFMRestService{



	public Set<Image> getImagesArtistes(String nom);

	public SortedSet<Piste> getPistesArtistes(String nom);
	
	public Artiste getDetailArtistInfo(String nom);
	
	public SortedSet<Evenement> getArtistEvent(String artistName);
	
}
