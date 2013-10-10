
package clientrest;

import java.util.Set;
import java.util.SortedSet;

import javax.ejb.Local;

import modele.Artiste;
import modele.Image;
import modele.Piste;


@Local
public interface LastFMRestService{



	public Set<Image> getImagesArtistes(String nom);

	public SortedSet<Piste> getPistesArtistes(String nom);
	
	public Artiste getDetailArtistInfo(String nom);
	
}
