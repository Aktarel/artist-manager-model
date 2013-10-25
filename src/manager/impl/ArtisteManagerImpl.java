package manager.impl;

import java.util.List;
import java.util.SortedSet;
import java.util.concurrent.ConcurrentSkipListSet;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import manager.GestionnaireRessource;
import manager.Ressources;
import modele.Artiste;
import modele.Evenement;

import org.apache.log4j.Logger;

import clientrest.deezer.DeezerRestService;
import clientrest.lastFM.LastFMRestService;
import dao.DAOArtistService;

@Stateless
public class ArtisteManagerImpl implements GestionnaireRessource {

	private final Logger log = Logger.getLogger(ArtisteManagerImpl.class);
	
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
				a.incrementPopularity();
				unDaoArtiste.update(a);
				return a;
			}
			else{
				a = api.getDetailArtistInfo(param);
				a = apiDeezer.getTrackStream(a);
				SortedSet<Evenement> events = api.getArtistEvent(param);
				
				for(Evenement event : events)
					a.addEvenement(event);
				
				unDaoArtiste.ajouterArtiste(a);
				return a;
			
			}
		}
		else if(r.equals(Ressources.topArtistes)){
			return unDaoArtiste.topArtistes(Integer.parseInt(param));
		}
		else if(r.equals(Ressources.artistesToString)){
			
			List<String> artistesToString = unDaoArtiste.list();
			return artistesToString;
			
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
