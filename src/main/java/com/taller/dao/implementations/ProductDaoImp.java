package com.taller.dao.implementations;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.taller.dao.interfaces.ProductDao;
import com.taller.model.Product;

@Repository
@Transactional
public class ProductDaoImp implements ProductDao {
	
	@PersistenceUnit
	private EntityManagerFactory emf;

	@Override
	@Transactional
	public void save(Product product) {
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		em.persist(product);
		em.getTransaction().commit();
		
		em.close();
	}

	@Override
	@Transactional
	public void update(Product product) {	
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		em.merge(product);
		em.getTransaction().commit();
		
		em.close();
	}

	@Override
	@Transactional
	public void delete(Product product) {
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		em.remove(product);
		em.getTransaction().commit();
	    
		em.close();
	}
	
	@Transactional
	public void delete(Integer id) {
		EntityManager em = emf.createEntityManager();
		
		Product product = em.find(Product.class, id);
		
		em.getTransaction().begin();
		
		em.remove(product);
		em.getTransaction().commit();
	    
		em.close();
	}

	@Override
	@Transactional
	@SuppressWarnings("unchecked")
	public List<Product> findAll() {
		EntityManager em = emf.createEntityManager();
		Query q = em.createQuery("SELECT p FROM Product p");
        return q.getResultList();
	}

	@Override
	@Transactional
	public Product findById(Integer id) {
		EntityManager em = emf.createEntityManager();
		return em.find(Product.class, id);
	}

	@Override
	@Transactional
	@SuppressWarnings("unchecked")
	public List<Product> findAllByStartDate(LocalDate date) {
		EntityManager em = emf.createEntityManager();
		//Query q = em.createQuery("SELECT p FROM Product p WHERE sellstartdate = \'"+ date +"\'");
		Query q = em.createQuery("SELECT p FROM Product p WHERE sellstartdate = :date");
		q.setParameter("date", date);
        return q.getResultList();
	}

	@Override
	@Transactional
	@SuppressWarnings("unchecked")
	public List<Product> findAllByEndDate(LocalDate date) {
		EntityManager em = emf.createEntityManager();
		//Query q = em.createQuery("SELECT p FROM Product p WHERE sellenddate = \'"+ date +"\'");
		Query q = em.createQuery("SELECT p FROM Product p WHERE sellenddate = :date");
		q.setParameter("date", date);
        return q.getResultList();
	}

	@Override
	@Transactional
	@SuppressWarnings("unchecked")
	public List<Product> findAllByTransactionhistoryBetweenDatesOrderedByProductName(LocalDate date1, LocalDate date2) {
		EntityManager em = emf.createEntityManager();
		Query q = em.createQuery("SELECT p FROM Product p JOIN p.transactionhistories ths ON ths.transactiondate BETWEEN :date1 AND :date2 WHERE p.transactionhistories IS NOT EMPTY ORDER BY p.name ASC");
        return q.getResultList();
	}

	@Override
	@Transactional
	@SuppressWarnings("unchecked")
	public List<Product> findAllByAtLeastTwoDocuments() {
		EntityManager em = emf.createEntityManager();
		Query q = em.createQuery("SELECT p FROM Product p WHERE SIZE(p.productdocuments) > 1");
        return q.getResultList();
	}

}
