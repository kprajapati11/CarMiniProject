import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.carminiproject.dao.CarHelper;
import com.carminiproject.entity.Cars;



public class Demo {

	public static void main(String[] args) {
		EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("CarMiniProject");
		CarHelper carHelper = new CarHelper();

		/*	Cars cars1 = new Cars(2020, "Toyota", "Camry");

		carHelper.insertCar(cars1);

		List<Cars> allCars = carHelper.showAllCars();
		for (Cars c : allCars) {
			System.out.println(c.toString());
		}

		Cars cars = emFactory.createEntityManager().find(Cars.class, 4);
		carHelper.deleteCar(cars);*/

		Cars cars = emFactory.createEntityManager().find(Cars.class, 2);
		cars.setYear(2021);
		cars.setModel("Cortana");
		carHelper.updateCars(cars);

	}

}
