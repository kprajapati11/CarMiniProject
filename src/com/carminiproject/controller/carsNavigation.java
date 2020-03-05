package com.carminiproject.controller;

import java.io.IOException;
import java.time.LocalDate;
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
		if (act.equals("delete car")) 
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
		else if (act.equals("edit car")) {
			try {
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				Cars carToEdit =crh.searchForCarById(tempId);
				request.setAttribute("carToEdit", carToEdit);
				path = "/editCar.jsp";
				} catch (Exception e) {
				System.out.println("Forgot to select an item");
				}
		} 
		else if (act.equals("add car")) 
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
		
		else if (act.equals("view servicing"))
		{
			try {
				Integer carId = Integer.parseInt(request.getParameter("id"));
				
<<<<<<< HEAD:src/controller/carsNavigation.java
				List<Servicing> carListById = svh.searchByCarId(carId);
				request.setAttribute("carId", carId);			
				request.setAttribute("listToDisplay", carListById);
=======
				//find car for this carId
				Cars selectedCar = crh.searchForCarById(carId);
				
				//we need all servicing info for this car
				List<Servicing> servicingList = svh.showAllServicingForCar(selectedCar);
				//request.setAttribute("carId", carId);			
				request.setAttribute("listServicing", servicingList);
				request.setAttribute("selectedCar", selectedCar);
				//listServicing.jsp still needs to be created
>>>>>>> upstream/master:src/com/carminiproject/controller/carsNavigation.java
				path = "/listServicing.jsp";

				} catch (Exception e) {
				System.out.println("Forgot to select an item");
				}
			
		//Elizabeth, can you check why after successful edit servicing info is not displayed?	
		}else if(act.equals("edit servicing")) {
			System.out.println("edit servicing selected");
			Integer servicingId = Integer.parseInt(request.getParameter("servicingId"));
			Servicing editServicing = svh.getEntityManager().find(Servicing.class, servicingId);
			
			request.setAttribute("editServicing", editServicing);
			path="/editServicing.jsp";
			
			
			//delete is working
		}else if(act.equals("delete servicing")) {
			System.out.println("delete servicing selected");
			try {
				Integer servicingId = Integer.parseInt(request.getParameter("servicingId"));
				Servicing entityToDelete = svh.getEntityManager().find(Servicing.class, servicingId);
				svh.deleteServicing(entityToDelete);
				path = "/listServicing.jsp";
			}catch(Exception e) {
				
			}
			
			
		// Elizabeth, can you check if this is working and try to fix this?	
		}else if(act.equals("add servicing")) {
			System.out.println("add servicing selected");
			
			
			try {

				Servicing servicing = new Servicing();
				Integer carId = Integer.parseInt(request.getParameter("selectedCarId"));
				Cars car = svh.getEntityManager().find(Cars.class, carId);

				// request.setAttribute("carToEdit", carToEdit);
				// editCar.jsp still needs to be created
				path = "/editServicing.jsp";
			} catch (Exception e) {

			}
			
		}
		
		getServletContext().getRequestDispatcher(path).forward(request,response);
}
}
