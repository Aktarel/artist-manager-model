
package clientrest;

import java.util.Set;

import javax.ejb.Local;

import modele.Artiste;
import modele.Image;
import modele.Piste;


@Local
public interface LastFMRestService{



	public Set<Image> getImagesArtistes(String nom);

	public Set<Piste> getPistesArtistes(String nom);
	
	public Artiste getDetailArtistInfo(String nom);
	
}
