package dao;

import javax.ejb.Local;

import modele.Artiste;

@Local
public interface DAOArtistService{

	public Artiste getUnArtiste(String nom);
	public boolean ajouterArtiste(Artiste unArtiste);
	
}
