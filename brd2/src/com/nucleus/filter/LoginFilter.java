package com.nucleus.filter;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import com.nucleus.DAO.LoginDao;

/**
 * Servlet Filter implementation class LoginFilter
 */
@WebFilter(filterName="LoginFilter", urlPatterns = {"/LoginServlet"})

public class LoginFilter implements Filter {
	LoginDao dao=new LoginDao();
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {	
		String name=request.getParameter("user").trim();
		String pass=request.getParameter("pass").trim();
		PrintWriter pw=response.getWriter();
		boolean check = false;		
		try 
		{
			check=dao.fetchUser(name, pass);
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		if(check==true)
		{
			request.setAttribute("fname", name);		
			chain.doFilter(request, response);
		}
		else
		{
			pw.print("Wrong username or password");
			RequestDispatcher rd=request.getRequestDispatcher("login.jsp");
			rd.include(request, response);		
		}
	}
	public void destroy() {
		// TODO Auto-generated method stub
	}

}
