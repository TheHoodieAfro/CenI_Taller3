package com.taller.dao.implementations;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.taller.dao.interfaces.VendorDao;
import com.taller.model.Vendor;

@Repository
@Transactional
public class VendorDaoImp implements VendorDao {
	
	@PersistenceUnit
	private EntityManagerFactory emf;

	@Override
	@Transactional
	public void save(Vendor vendor) {
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		em.persist(vendor);
		em.getTransaction().commit();
		
		em.close();
	}

	@Override
	@Transactional
	public void update(Vendor vendor) {
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		em.merge(vendor);
		em.getTransaction().commit();
		
		em.close();
	}

	@Override
	@Transactional
	public void delete(Vendor vendor) {
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		em.remove(vendor);
		em.getTransaction().commit();
	    
		em.close();
	}
	
	@Transactional
	public void delete(Integer id) {
		EntityManager em = emf.createEntityManager();
		
		Vendor vendor = em.find(Vendor.class, id);
		
		em.getTransaction().begin();
		
		em.remove(vendor);
		em.getTransaction().commit();
	    
		em.close();
	}

	@Override
	@Transactional
	@SuppressWarnings("unchecked")
	public List<Vendor> findAll() {
		EntityManager em = emf.createEntityManager();
		Query q = em.createQuery("SELECT v FROM Vendor v");
        return q.getResultList();
	}

	@Override
	@Transactional
	public Vendor findById(Integer id) {
		EntityManager em = emf.createEntityManager();
		return em.find(Vendor.class, id);
	}

}
