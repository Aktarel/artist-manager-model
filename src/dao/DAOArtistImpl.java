package dao;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.SetJoin;

import modele.Artiste;
import modele.Utilisateur;

import org.apache.log4j.Logger;

@Stateless
public class DAOArtistImpl implements DAOArtistService {

	private Logger log = Logger.getLogger(DAOArtistImpl.class);
	
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
		} finally {
			return artiste;
		}

	}

	public void ajouterArtiste(Artiste unArtiste) {

		try {
			if (unArtiste.getNom() != null) {
				em.persist(unArtiste);

			}
		} catch (Exception e) {
			log.error("Erreur dans l'insertion de l'artiste");
		}

	}

	public List<String> list() {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<String> q = cb.createQuery(String.class);
		Root<Artiste> root = q.from(Artiste.class);
		q.multiselect(root.get("nom")).distinct(true);
		List<String> nomArtistes = em.createQuery(q).getResultList();
		if (nomArtistes.size() != 0) {
			return nomArtistes;
		} else {
			return new ArrayList<String>();
		}

	}

	public long count() {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Long> q = cb.createQuery(Long.class);
		Root<Artiste> root = q.from(Artiste.class);
		q.multiselect(cb.count(root));
		long count = em.createQuery(q).getSingleResult();
		return count;

	}

	public void update(Artiste a) {

		try {
			if (a.getNom() != null) {
				em.merge(a);
			}
		} catch (Exception e) {
			em.getTransaction().rollback();
		}

	}

	@Override
	public List<Artiste> topArtistes(int limit) {
		
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Artiste> q = cb.createQuery(Artiste.class);
		Root<Artiste> root = q.from(Artiste.class);
		TypedQuery<Artiste> tq = em.createQuery(q);
		
		List<Artiste> artistes = em.createQuery(q).setMaxResults(limit).getResultList();
		
		if (artistes.size() == 0) {
			return new ArrayList<Artiste>();
		} else {
			return artistes;
		}
	}

}
