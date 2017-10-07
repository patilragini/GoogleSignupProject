package com.bridgelabz.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bridgelabz.DAO.LoginDao;

/**
 * Servlet implementation class LoginServlet
 */
// @WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("in post");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		System.out.println(request.getParameter("action"));

		if (request.getParameter("action") != null) {
			System.out.println("in login");
			String name = request.getParameter("username");
			String password = request.getParameter("userpass");
			/*
			 * getSession(false) will check existence of session. If session
			 * exists, then it returns the reference of that session object, if
			 * not, this methods will return null.
			 */
			HttpSession session = request.getSession();
			System.out.println("session  " + session);
			// set new session by name oblect
			if (session != null) {
				session.setAttribute("name", name);
				// System.out.println("in if ");
				System.out.println("session  " + session);
			}

			if (LoginDao.validate(name, password)) {
				System.out.println("session  " + session);
				RequestDispatcher requestDipatcher = request.getRequestDispatcher("welcome.jsp");
				requestDipatcher.forward(request, response);
				System.out.println("session  " + session);
			} else {
				System.out.println("else login dao false session  " + session);
				out.print("<p style=\"color:red\">Sorry username and password error!!!</p>");
				RequestDispatcher requestDipatcher = request.getRequestDispatcher("index.jsp");
				requestDipatcher.include(request, response);
			}
		}
		out.close();
	}
}
