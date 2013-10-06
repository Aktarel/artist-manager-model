package manager.impl;

import javax.ejb.EJB;
import javax.ejb.Stateful;

import org.apache.log4j.Logger;

import manager.GestionnaireRessource;
import manager.Ressources;
import modele.Artiste;
import clientrest.LastFMRestService;
import dao.DAOArtistService;

@Stateful
public class ArtisteManagerImpl implements GestionnaireRessource {

	private Logger log = Logger.getLogger(ArtisteManagerImpl.class);

	@EJB
	private DAOArtistService unDaoArtiste;
	
	@EJB
	private LastFMRestService api;

	public Object get(Ressources r,String param) {
		if(r.equals(Ressources.artiste)){
			Artiste a = unDaoArtiste.getUnArtiste(param);
			if(a !=null ){
				log.info("L'artiste est dans la base de donnee : "+param);
				return a;
			}
			else{
				a =api.getDetailArtistInfo(param);
				unDaoArtiste.ajouterArtiste(a);
				return a;
			}
		
		}
		else{
			return "Erreur : je n'ai pas compris ce que vous recherchiez";
		}
	}
}
