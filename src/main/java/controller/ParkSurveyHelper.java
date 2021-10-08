/**
 * @author alexanderpontier - ampontier1
 * CIS175 - Spring 2021
 * Oct 7, 2021
 */
package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.ParkSurvey;

public class ParkSurveyHelper {
	
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("JurassicWorld");
	
	public void insertNewParkSurvey(ParkSurvey s) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(s);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<ParkSurvey> getSurvey() {
		EntityManager em = emfactory.createEntityManager();
		List<ParkSurvey> allSurveys = em.createQuery("SELECT s FROM ParkSurvey s").getResultList();
		return allSurveys;
	}

	public void deleteList(ParkSurvey toDelete) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<ParkSurvey> typedQuery = em.createQuery("select survey from ParkSurvey survey where survey.id = :selectedId", ParkSurvey.class);
		
	//Substitute parameter with actual data from the toDelete item
		typedQuery.setParameter("selectedId", toDelete.getId());
		
	//we only want one result
		typedQuery.setMaxResults(1);
		
	//get the result and save it into a new list item
		ParkSurvey result = typedQuery.getSingleResult();
		
	//remove it
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}

	public ParkSurvey searchForParkSurveyById(Integer tempId) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		ParkSurvey found = em.find(ParkSurvey.class, tempId);
		em.close();
		return found;
	}

	public void updateList(ParkSurvey toEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}

}
