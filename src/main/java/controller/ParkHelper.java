/**
 * @author alexanderpontier - ampontier1
 * CIS175 - Spring 2021
 * Oct 7, 2021
 */
package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Park;

public class ParkHelper {
	
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("JurassicWorld");
	
	public void insertPark(Park p) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(p);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<Park> showAllParks() {
		EntityManager em = emfactory.createEntityManager();
		List<Park> allParks = em.createQuery("SELECT p FROM Park p").getResultList();
		return allParks;
	}

	public Park findPark(String nameToLookUp) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Park> typedQuery = em.createQuery("select ph from Park ph where ph.ParkName = :selectedName", Park.class);
		typedQuery.setParameter("selectedName", nameToLookUp);
		typedQuery.setMaxResults(1);
		
		Park foundPark;
		try {
			foundPark = typedQuery.getSingleResult();
		} catch (NoResultException ex) {
			foundPark = new Park(nameToLookUp);
		}
		em.close();
			
		return foundPark;
	}

}
