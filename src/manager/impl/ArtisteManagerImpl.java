package manager.impl;

import java.util.SortedSet;
import java.util.concurrent.ConcurrentSkipListSet;

import javax.ejb.EJB;
import javax.ejb.Stateful;

import manager.GestionnaireRessource;
import manager.Ressources;
import modele.Artiste;
import modele.Evenement;
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
				SortedSet<Evenement> events = api.getArtistEvent(param);
				
				for(Evenement event : events)
					a.addEvenement(event);
				
				if(unDaoArtiste.ajouterArtiste(a)==true){
					return a;
				}
				else{
					return new Artiste();
				}
			
			}
		}
		else if(r.equals(Ressources.evenement)){
			SortedSet<Evenement> evenements = api.getArtistEvent(param);
			if(evenements!=null){
				return evenements;
			}
			else{
				return new ConcurrentSkipListSet<Evenement>();
			}
			
		}
		else{
			return "Erreur : je n'ai pas compris ce que vous recherchiez";
		}
		
	}
}
