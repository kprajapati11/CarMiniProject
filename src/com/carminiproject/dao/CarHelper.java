package com.carminiproject.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.carminiproject.entity.Cars;



public class CarHelper {
	static EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("CarMiniProject");

	//insert
	public void insertCar(Cars c) {
		EntityManager em = emFactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(c);
		em.getTransaction().commit();
		em.close();

	}

	public List<Cars> showAllCars(){
		EntityManager em = emFactory.createEntityManager();
		List<Cars> allCars = em.createQuery("SELECT c FROM Cars c").getResultList();
		return allCars;
	}

	//update /edit

	//delete

	public void deleteCar(Cars toDelete) { 
		EntityManager em = emFactory.createEntityManager(); 
		em.getTransaction().begin();

		/*
		 * TypedQuery<Cars> typedQuery =
		 * em.createQuery("SELECT c from Cars where c.getCarId=:selectedId",
		 * Cars.class); typedQuery.setParameter("selectedId", toDelete.getCarId());
		 * 
		 * typedQuery.setMaxResults(1);
		 * 
		 * Cars result = typedQuery.getSingleResult();
		 */
		Cars deleteCar =em.merge(toDelete);
		em.remove(deleteCar);
		em.getTransaction().commit();
		em.close();
	}


}
