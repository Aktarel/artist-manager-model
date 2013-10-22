package manager.impl;

import javax.ejb.EJB;
import javax.ejb.Stateful;

import manager.GestionnaireRessource;
import manager.Ressources;
import modele.Artiste;
import clientrest.deezer.DeezerRestService;
import clientrest.lastFM.LastFMRestService;
import dao.DAOArtistService;

@Stateful
public class ArtisteManagerImpl implements GestionnaireRessource {

	@EJB
	private DAOArtistService unDaoArtiste;
	
	@EJB
	private LastFMRestService api;
	
	@EJB
	private DeezerRestService apiDeezer;

	public Object get(Ressources r,String param) {
		if(r.equals(Ressources.artiste)){
			Artiste a = unDaoArtiste.getUnArtiste(param);
			if(a !=null ){
				return a;
			}
			else{
				a = api.getDetailArtistInfo(param);
				a = apiDeezer.getTrackStream(a);
				if(a != null){
					unDaoArtiste.ajouterArtiste(a);
					return a;
				}
				else{
					return null;
				}
			}
		}
		else{
			return "Erreur : je n'ai pas compris ce que vous recherchiez";
		}
		
	}
}
