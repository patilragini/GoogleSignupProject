/********************************************************************************** 
 *  @author  Ragini Patil
 *  @version 1.0
 *  @since   5-10-2017
 *	@purpose LoginServlet extends http servlet.
 *			 Has goPost overridden method which accepts email and password given
 *			 by user in login page & it is resonsible to check if found valid 
 *			 dispatch welcome page else if invalid user redirect to login page with error.
 *			 Also check existence of session. If session exists, then it returns 
 *			 the reference of that session object.
 ***********************************************************************************/
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

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 *      <p> this   
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// System.out.println("in post");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		// System.out.println(request.getParameter("action"));
		if (request.getParameter("action") != null) {
			// System.out.println("in login");

			String email = request.getParameter("email");
			String password = request.getParameter("userpass");
			
			/*
			 * getSession(false) will check existence of session. If session
			 * exists, then it returns the reference of that session object, if
			 * not, this methods will return null.
			 */
			HttpSession session = request.getSession();
			//System.out.println("session  " + session);
			// set new session by name object
			if (session != null) {
				session.setAttribute("email", email);
				
			}
			String nameResult=LoginDao.validate(email, password);
			
			session.setAttribute("name",nameResult);
			if (nameResult!=null) {	
				session.removeAttribute("errorLogin");	
				RequestDispatcher requestDipatcher = request.getRequestDispatcher("welcome.jsp");
				requestDipatcher.forward(request, response);
				
			} else {
				String errorMsg="Invalid username or password !!!";
				session.setAttribute("errorLogin",errorMsg);
				//out.print("<p style=\"color:red\">Enter proper username and password !!!</p>");
				RequestDispatcher requestDipatcher = request.getRequestDispatcher("index.jsp");
				requestDipatcher.forward(request, response);
			}
		}
		out.close();
	}
}
