package fr.percall.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.percall.collab.Collaborators;
@Repository
@Transactional

public class CollabDAO implements EntityRepository<Collaborators>{
	
	@PersistenceContext
	public EntityManager em;
	@Override
	public Collaborators save(Collaborators c) {
		em.persist(c);
		return c;
	}

	@Override
	public List<Collaborators> findAll() {
		Query query = em.createNativeQuery("select * from Collaborators");
		return query.getResultList();
	}

	@Override
	public Collaborators findOne(Integer id) {
		Collaborators c = em.find(Collaborators.class, id);
		return c;
	}

	@Override
	public Collaborators update(Collaborators c) {
		em.merge(c);
		return c;
	}

	@Override
	public void delete(Integer id) {
		Collaborators c = em.find(Collaborators.class, id);
		em.remove(c);
		
	}

	@Override
	public Collaborators findByName(String mc) {
		Query query = em.createQuery("select c from Collaborators c where c.name like :x");
		em.setProperty("x", mc);
		return null;
	}
	public void deleteByName(Integer id) {
		Collaborators c = em.find(Collaborators.class, id );
		String mc = null;
		Query query = em.createNativeQuery("delete c from Collaborators c where c.name like :x");
		em.setProperty("x", mc);
		em.remove(mc);
	}

}
