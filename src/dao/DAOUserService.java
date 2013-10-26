package dao;

import javax.ejb.Local;

import modele.Utilisateur;

@Local
public interface DAOUserService {

	public Utilisateur get(String ipAdresse);
	public void add(Utilisateur user);
	
	public void update(Utilisateur user);
}
