import com.carminiproject.dao.CarHelper;
import com.carminiproject.entity.Cars;

public class carsTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Cars newCar = new Cars(2011, "Toyota", "Camery");
		CarHelper crh = new CarHelper();
		crh.insertCar(newCar);
		System.out.println("success");

	}

}
