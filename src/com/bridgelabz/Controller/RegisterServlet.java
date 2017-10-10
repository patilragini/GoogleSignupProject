package com.bridgelabz.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bridgelabz.Component.Registration;
import com.bridgelabz.DAO.RegisterDao;

/**
 * Servlet implementation class RegisterServlet
 */
// @WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@SuppressWarnings("static-access")
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Boolean status = false;
		Registration registration = new Registration();

		registration.setName(request.getParameter("name"));
		registration.setPassword(request.getParameter("password"));

		System.out.println(request.getParameter("phoneNumber"));		
		registration.setphoneNumber( Long.parseLong((request.getParameter("phoneNumber"))));
		registration.setEmail(request.getParameter("email"));

		System.out.println("in register servlet!!!" + registration.getEmail() + "  " + registration.getName() + " "
				+ registration.getphoneNumber() + "  " + registration.getPassword());

		try {
			status = RegisterDao.register(registration);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		if (status == true) {
			System.out.println("registration successful!!!");
			RequestDispatcher requestDipatcher = request.getRequestDispatcher("index.jsp");
			requestDipatcher.forward(request, response);
		} else {
			response.setContentType("text/html");
			System.out.println("existing emailid");
			PrintWriter out = response.getWriter();
			out.print("<p style=\"color:red\">Account exists enter different EmailId</p>");
			RequestDispatcher requestDipatcher = request.getRequestDispatcher("RegistrationPage.jsp");
			requestDipatcher.forward(request, response);
		}
	}

}
