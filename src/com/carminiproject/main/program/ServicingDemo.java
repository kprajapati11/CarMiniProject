package com.carminiproject.main.program;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.carminiproject.dao.ServicingHelper;
import com.carminiproject.entity.Cars;
import com.carminiproject.entity.Servicing;



public class ServicingDemo {

	public static void main(String[] args) {
		EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("CarMiniProject");

		ServicingHelper servicingHelper = new ServicingHelper();

		Cars car = emFactory.createEntityManager().find(Cars.class, 1);

		
		  Servicing servicing = new Servicing(car, LocalDate.now(), "Tyre changed", 3000); 
		  servicingHelper.insertServicing(servicing);
		  
		/*
		 * List<Servicing> allServicing = servicingHelper.showAllServicing();
		 * for(Servicing serve: allServicing) { System.out.println(serve.toString());
		 * 
		 * }
		 */
		
		 // Servicing serve = emFactory.createEntityManager().find(Servicing.class, 3);
		  //servicingHelper.deleteServicing(serve);
		 

		/*
		 * Servicing servicing = emFactory.createEntityManager().find(Servicing.class,
		 * 4); servicing.setMileage(3000);
		 * servicing.setServicingDesc("This is a test in changing the description");
		 * servicingHelper.updateServicing(servicing);
		 */
		
		List<Servicing> resultSet = servicingHelper.showAllServicingForCar(car);
		for(Servicing s : resultSet) {
			System.out.println(s.toString());
		}


	}

}
