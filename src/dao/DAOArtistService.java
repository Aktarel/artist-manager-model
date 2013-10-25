package dao;

import java.util.List;

import javax.ejb.Local;

import modele.Artiste;

@Local
public interface DAOArtistService{

	public Artiste getUnArtiste(String nom);
	public void ajouterArtiste(Artiste unArtiste);
	public List<String> list();
	public void update(Artiste a);
    public List<Artiste> topArtistes(int limit);
}
