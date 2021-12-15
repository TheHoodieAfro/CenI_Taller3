package com.taller.dao.implementations;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.taller.dao.interfaces.TransactionhistoryDao;
import com.taller.model.Product;
import com.taller.model.Transactionhistory;

@Repository
@Transactional
public class TransactionhistoryDaoImp implements TransactionhistoryDao {
	
	@PersistenceUnit
	private EntityManagerFactory emf;

	@Override
	@Transactional
	public void save(Transactionhistory transactionhistory) {
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		em.persist(transactionhistory);
		em.getTransaction().commit();
		
		em.close();
	}

	@Override
	@Transactional
	public void update(Transactionhistory transactionhistory) {
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		em.merge(transactionhistory);
		em.getTransaction().commit();
		
		em.close();
	}

	@Override
	@Transactional
	public void delete(Transactionhistory transactionhistory) {
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		em.remove(transactionhistory);
		em.getTransaction().commit();
	    
		em.close();
	}
	
	@Transactional
	public void delete(Integer id) {
		EntityManager em = emf.createEntityManager();
		
		Transactionhistory transactionhistory = em.find(Transactionhistory.class, id);
		
		em.getTransaction().begin();
		
		em.remove(transactionhistory);
		em.getTransaction().commit();
	    
		em.close();
	}

	@Override
	@Transactional
	@SuppressWarnings("unchecked")
	public List<Transactionhistory> findAll() {
		EntityManager em = emf.createEntityManager();
		Query q = em.createQuery("SELECT th FROM Transactionhistory th");
        return q.getResultList();
	}

	@Override
	@Transactional
	public Transactionhistory findById(Integer id) {
		EntityManager em = emf.createEntityManager();
		return em.find(Transactionhistory.class, id);
	}

	//TODO
	@Override
	@Transactional
	@SuppressWarnings("unchecked")
	public List<Transactionhistory> findAllByProduct(Product product) {
		EntityManager em = emf.createEntityManager();
		Query q = em.createQuery("SELECT th FROM Transactionhistory th WHERE th.product.productid = "+ product.getProductid());
        return q.getResultList();
	}

}
