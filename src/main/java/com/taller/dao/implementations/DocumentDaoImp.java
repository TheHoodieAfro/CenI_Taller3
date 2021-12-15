package com.taller.dao.implementations;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.taller.dao.interfaces.DocumentDao;
import com.taller.model.Document;

@Repository
@Transactional
public class DocumentDaoImp implements DocumentDao {
	
	@PersistenceUnit
	private EntityManagerFactory emf;

	@Override
	@Transactional
	public void save(Document document) {
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		em.persist(document);
		em.getTransaction().commit();
		
		em.close();
	}

	@Override
	@Transactional
	public void update(Document document) {
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		em.merge(document);
		em.getTransaction().commit();
		
		em.close();
	}

	@Override
	@Transactional
	public void delete(Document document) {
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		em.remove(document);
		em.getTransaction().commit();
	    
		em.close();
	}
	
	@Transactional
	public void delete(Integer id) {
		EntityManager em = emf.createEntityManager();
		
		Document document = em.find(Document.class, id);
		
		em.getTransaction().begin();
		
		em.remove(document);
		em.getTransaction().commit();
	    
		em.close();
	}

	@Override
	@Transactional
	@SuppressWarnings("unchecked")
	public List<Document> findAll() {
		EntityManager em = emf.createEntityManager();
		Query q = em.createQuery("SELECT d FROM Document d");
        return q.getResultList();
	}

	@Override
	@Transactional
	public Document findById(Integer id) {
		EntityManager em = emf.createEntityManager();
		return em.find(Document.class, id);
	}

}
