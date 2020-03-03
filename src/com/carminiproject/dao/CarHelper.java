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
		@SuppressWarnings("unchecked")
		List<Cars> allCars = em.createQuery("SELECT i FROM Cars i").getResultList();
		return allCars;
	}

	//For update/edit ==> get the carId
	public Cars searchForCarById(int idToEdit) {
		EntityManager em = emFactory.createEntityManager();
		TypedQuery<Cars> typedQuery = em.createQuery("SELECT c FROM CARS where c.getCardId=:selectedId", Cars.class);
		typedQuery.setParameter("selectedId", idToEdit);
		typedQuery.setMaxResults(1);

		Cars result = typedQuery.getSingleResult();
		em.close();

		return result;
	}

	//For update/edit ==> to update
	public void updateCars(Cars editCar) {
		EntityManager em = emFactory.createEntityManager();
		em.getTransaction().begin();

		TypedQuery<Cars> typedQuery = em.createQuery("UPDATE Cars c SET c.year=:year , c.make=:make , c.model=:model where c.carId=:carId",Cars.class);
		typedQuery.setParameter("carId", editCar.getCarId());
		typedQuery.setParameter("year", editCar.getYear());
		typedQuery.setParameter("make", editCar.getMake());
		typedQuery.setParameter("model", editCar.getModel());
		
		
		int rowUpdate = typedQuery.executeUpdate();
		em.getTransaction().commit();
		em.close();
	}

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
