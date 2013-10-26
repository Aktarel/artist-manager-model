package dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import modele.Utilisateur;

@Stateless
public class DAOUserImpl implements DAOUserService {

	@PersistenceContext
	private EntityManager em;

	@SuppressWarnings("finally")
	public Utilisateur  get(String ipAdresse) {
		Utilisateur user = null;
		CriteriaBuilder cb = em.getCriteriaBuilder();

		CriteriaQuery<Utilisateur> q = cb.createQuery(Utilisateur.class);
		Root<Utilisateur> c = q.from(Utilisateur.class);
		q.select(c).where(cb.equal(c.get("ipAdresse"), ipAdresse));
		TypedQuery<Utilisateur> tq = em.createQuery(q);
		try {
			user = tq.getSingleResult();
		} catch (javax.persistence.NoResultException e) {
			user = null;
		} finally {
			return user;
		}
	}
	
	public void add(Utilisateur user){
		em.persist(user);
	}
	
	public void update(Utilisateur user){
		em.merge(user);
	}
		

}
