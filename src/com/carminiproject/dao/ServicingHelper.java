package com.carminiproject.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.carminiproject.entity.Cars;
import com.carminiproject.entity.Servicing;



public class ServicingHelper {
	static EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("CarMiniProject");

	//insert
	public void insertServicing(Servicing servicing) {
		EntityManager em = emFactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(servicing);
		em.getTransaction().commit();
		em.close();

	}
	
	public List<Servicing> showAllServicing(){
		EntityManager em = emFactory.createEntityManager();
		List<Servicing> allServicing = em.createQuery("SELECT s FROM Servicing s").getResultList();
		return allServicing;
	}
	
	
	public Servicing searchForServicingById(int idToEdit) {
		EntityManager em = emFactory.createEntityManager();
		TypedQuery<Servicing> typedQuery = em.createQuery("SELECT s FROM Servicing where s.getServicingId=:selectedId", Servicing.class);
		typedQuery.setParameter("selectedId", idToEdit);
		typedQuery.setMaxResults(1);

		Servicing result = typedQuery.getSingleResult();
		em.close();

		return result;
	}

	//For update/edit ==> to update
	public void updateServicing(Servicing editServicing) {
		EntityManager em = emFactory.createEntityManager();
		em.getTransaction().begin();

		TypedQuery<Servicing> typedQuery = em.createQuery("UPDATE Servicing s SET s.servicingDate=:servicingDate  , s.servicingDesc=:servicingDescription , s.mileage=:vehicalMileage where s.servicingId=:servicingId", Servicing.class);
		typedQuery.setParameter("servicingId", editServicing.getServicingId());
		typedQuery.setParameter("servicingDate", editServicing.getServicingDate());
		typedQuery.setParameter("servicingDescription", editServicing.getServicingDesc());
		typedQuery.setParameter("vehicalMileage", editServicing.getMileage());				
		
		int rowUpdate = typedQuery.executeUpdate();
		em.getTransaction().commit();
		em.close();
	}

	
	public void deleteServicing(Servicing servicing) { 
		EntityManager em = emFactory.createEntityManager(); 
		em.getTransaction().begin();
		Servicing deleteServicing =em.merge(servicing);
		em.remove(deleteServicing);
		em.getTransaction().commit();
		em.close();
	}
	
	
	public List<Servicing> showAllServicingForCar(Cars car){
		List<Servicing> allServingList = showAllServicing();
		List<Servicing> filterListForThisCar = new ArrayList<>();
		for(Servicing s : allServingList) {
			if(s.getCar().getCarId()==car.getCarId()) {
				filterListForThisCar.add(s);
			}
		}
		return filterListForThisCar;
	}
	
	
	public EntityManager getEntityManager() {
		return emFactory.createEntityManager();
	}


}
