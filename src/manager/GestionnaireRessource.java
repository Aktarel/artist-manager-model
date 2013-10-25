package manager;

import javax.ejb.Local;

@Local
public interface GestionnaireRessource {

	public Object get(Ressources r, String param);
	
}
