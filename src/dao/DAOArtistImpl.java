package dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import modele.Artiste;

@Stateless
public class DAOArtistImpl implements DAOArtistService {

	@PersistenceContext
	private EntityManager em;

	@SuppressWarnings("finally")
	public Artiste getUnArtiste(String nom) {
		Artiste artiste = null;
		CriteriaBuilder cb = em.getCriteriaBuilder();

		CriteriaQuery<Artiste> q = cb.createQuery(Artiste.class);
		Root<Artiste> c = q.from(Artiste.class);
		q.select(c).where(cb.equal(c.get("nom"), nom));
		TypedQuery<Artiste> tq = em.createQuery(q);
		try {
			artiste = tq.getSingleResult();
		} catch (javax.persistence.NoResultException e) {
			artiste = null;
		}
		finally{
			return artiste;
		}
		

		

	}

	public boolean ajouterArtiste(Artiste unArtiste) {

		try {
			em.persist(unArtiste);
			return true;

		} catch (Exception e) {

			return false;
		}

	}

}
