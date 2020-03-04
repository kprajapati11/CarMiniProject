package com.carminiproject.controller;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.carminiproject.dao.ServicingHelper;
import com.carminiproject.entity.Cars;
import com.carminiproject.entity.Servicing;

/**
 * Servlet implementation class editCarSrvlt
 */
@WebServlet("/editServicingServlet")
public class editServicingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public editServicingServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		ServicingHelper servicingHelper = new ServicingHelper();
		String month = request.getParameter("month");
		String day = request.getParameter("day");
		String year = request.getParameter("year");
		String description = request.getParameter("description");
		Integer mileage = Integer.parseInt(request.getParameter("mileage"));
		Integer servicingId = Integer.parseInt(request.getParameter("servicingId"));

		LocalDate servicingDate;
		try {
			servicingDate = LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
		} catch (NumberFormatException ex) {
			servicingDate = LocalDate.now();
		}

		Servicing servicingToUpdate = servicingHelper.getEntityManager().find(Servicing.class, servicingId);
		servicingToUpdate.setServicingDesc(description);
		servicingToUpdate.setMileage(mileage);
		servicingToUpdate.setServicingDate(servicingDate);
		servicingHelper.updateServicing(servicingToUpdate);

		getServletContext().getRequestDispatcher("/listServicing.jsp").forward(request, response);

	}

}
