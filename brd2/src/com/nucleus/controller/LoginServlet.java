package com.nucleus.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.nucleus.service.LoginService;
/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		String name=(String) request.getAttribute("fname");
		session.setAttribute("fname", name);
		LoginService service=new LoginService();
		String role=service.fetchrole(name);
		if(role.equalsIgnoreCase("maker"))
		{
		RequestDispatcher rd=request.getRequestDispatcher("menuBar.jsp");
		rd.forward(request, response);
		
		}
		else
		{
			RequestDispatcher rd=request.getRequestDispatcher("checker.html");
			rd.forward(request, response);
		}
	}
}