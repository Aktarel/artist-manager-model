package manager;

import javax.ejb.Remote;

@Remote
public interface GestionnaireRessource {

	public Object get(Ressources r, String param);
	
}
