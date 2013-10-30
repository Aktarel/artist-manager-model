package manager;

import javax.ejb.Local;

/**
 * Interface recuperee par l'application web.
 * Dispatch les besoins du modele et permet de faire des controles avant 
 * d'aller chercher dans la couche de persistence
 * @author nicolas
 *
 */
@Local
public interface GestionnaireRessource {

	public Object get(Ressources r, String... params);
	public Object update(Ressources r,Object o);
	public void add(Ressources r,Object a);	
}
