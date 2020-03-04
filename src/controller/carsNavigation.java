package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.carminiproject.dao.CarHelper;
import com.carminiproject.dao.ServicingHelper;
import com.carminiproject.entity.Cars;
import com.carminiproject.entity.Servicing;

/**
 * Servlet implementation class carsNavigation
 */
@WebServlet("/carsNavigation")
public class carsNavigation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public carsNavigation() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String act = request.getParameter("doThisToItem");
		CarHelper crh = new CarHelper();
		//create servicing helper object
		ServicingHelper svh = new ServicingHelper();
		// after all changes, we should redirect to the viewAllItems servlet
		// The only time we don't is if they select to add a new item or edit
		String path = "/viewAllCarsSrvlt";
		if (act.equals("delete")) 
		{
			try
			{
			Integer tempId = Integer.parseInt(request.getParameter("id"));
			Cars carToDelete = crh.searchForCarById(tempId);
			crh.deleteCar(carToDelete);
			}
			catch(Exception e)
			{
				System.out.println("Forgot to select a car");	
			}
		} 
		else if (act.equals("edit")) {
			try {
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				Cars carToEdit =crh.searchForCarById(tempId);
				request.setAttribute("carToEdit", carToEdit);
				path = "/editCar.jsp";
				} catch (Exception e) {
				System.out.println("Forgot to select an item");
				}
		} 
		else if (act.equals("add")) 
		{
			
			try
			{
			Cars newCar = new Cars( "", "");
			crh.insertCar(newCar);
			Cars carToEdit = crh.searchForCarById(newCar.getCarId());
			request.setAttribute("carToEdit", carToEdit);
			//editCar.jsp still needs to be created
			path = "/editCar.jsp";
			}
			catch (Exception e)
			{
				
			}
			
		}
		
		//Kalpana can you please do this so that it searches for all servicing
		//and passes to listServicingSrvlt.java?
		else if (act.equals("view servicing"))
		{
			try {
				Integer carId = Integer.parseInt(request.getParameter("id"));
				
				List<Servicing> carListById = svh.searchByCarId(carId);
				request.setAttribute("carId", carId);			
				request.setAttribute("listToDisplay", carListById);
				path = "/listServicing.jsp";

				} catch (Exception e) {
				System.out.println("Forgot to select an item");
				}
			
		} 
		
		getServletContext().getRequestDispatcher(path).forward(request,response);
}
}
