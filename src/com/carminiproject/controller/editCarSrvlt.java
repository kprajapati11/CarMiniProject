package com.carminiproject.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.carminiproject.dao.CarHelper;
import com.carminiproject.entity.Cars;

/**
 * Servlet implementation class editCarSrvlt
 */
@WebServlet("/editCarSrvlt")
public class editCarSrvlt extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public editCarSrvlt() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		CarHelper crh = new CarHelper();
		Integer year = Integer.parseInt(request.getParameter("year"));
		String make = request.getParameter("make");
		String model = request.getParameter("model");
		Integer tempId = Integer.parseInt(request.getParameter("id"));
		Cars carToUpdate = crh.searchForCarById(tempId);
		carToUpdate.setYear(year);
		carToUpdate.setMake(make);
		carToUpdate.setModel(model);
		crh.updateCars(carToUpdate);
		getServletContext().getRequestDispatcher("/viewAllCarsSrvlt").forward(request, response);
		
		
		
	}

}
