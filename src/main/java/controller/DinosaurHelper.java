/**
 * @author alexanderpontier - ampontier1
 * CIS175 - Spring 2021
 * Sep 16, 2021
 */
package controller;

import java.util.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Dinosaur;

public class DinosaurHelper {
	
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("JurassicWorld");
	
	public void insertDino(Dinosaur d) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(d);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<Dinosaur> showAllDinos() {
		EntityManager em = emfactory.createEntityManager();
		List<Dinosaur> allDinos = em.createQuery("SELECT i FROM Dinosaur i").getResultList();
		return allDinos;
	}
	
	public void deleteDino(Dinosaur toDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Dinosaur> typedQuery = em.createQuery("select d from Dinosaur d where d.species = :selectedSpecies and d.color = :selectedColor", Dinosaur.class);
		
		//Substitute parameter with actual data from the toDelete item
		typedQuery.setParameter("selectedSpecies", toDelete.getSpecies());
		typedQuery.setParameter("selectedColor",
		toDelete.getColor());
		
		//we only want one result
		typedQuery.setMaxResults(1);
		
		//get the result and save it into a new list item
		Dinosaur result = typedQuery.getSingleResult();
		
		//remove it
		em.remove(result);
		em.getTransaction().commit();
		em.close();
		
	}

	public Dinosaur searchForDinoById(int idToEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		Dinosaur found = em.find(Dinosaur.class, idToEdit);
		em.close();
		
		return found;
	}

	public void updateDino(Dinosaur toEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
		
	}

	public List<Dinosaur> searchForDinoBySpecies(String speciesName) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Dinosaur> typedQuery = em.createQuery("select d from Dinosaur d where d.species = :selectedSpecies", Dinosaur.class);
		typedQuery.setParameter("selectedSpecies", speciesName);
		
		List<Dinosaur> foundDinos = typedQuery.getResultList();
		em.close();
		
		return foundDinos;
	}

	public List<Dinosaur> searchForDinoByColor(String colorName) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Dinosaur> typedQuery = em.createQuery("select d from Dinosaur d where d.color = :selectedColor", Dinosaur.class);
		typedQuery.setParameter("selectedSpecies", colorName);
		
		List<Dinosaur> foundDinos = typedQuery.getResultList();
		em.close();
		
		return foundDinos;
	}
	
	public void cleanUp() {
		emfactory.close();
	}

	

}
