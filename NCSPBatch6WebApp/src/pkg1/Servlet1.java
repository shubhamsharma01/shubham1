package pkg1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Servlet1
 */
//@WebServlet("/S1")
public class Servlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String email;
	String contactp;
public void init()
{
	ServletConfig servletConfig=getServletConfig();
	email=servletConfig.getInitParameter("email");
	ServletContext servletContext=getServletContext();
	contactp=servletContext.getInitParameter("contactperson");
}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
	
		/*ServletConfig servletConfig=getServletConfig();
		email=servletConfig.getInitParameter("email");*/
		out.println("Email: "+email);
		out.println("Contact Person: "+contactp);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*String str=request.getParameter("t1");		
		String str1=str+"bye";
		System.out.println("Servlet..1  "+str);
		PrintWriter out=response.getWriter();
		out.println(str+"<br>");
		Student std1=new Student();
		out.println("<font color=blue>Hello</font><br>");
		out.println(std1.display(str));
		request.setAttribute("a", str1);
		RequestDispatcher dispatcher=request.getRequestDispatcher("S2");
		//dispatcher.forward(request, response);
		dispatcher.include(request, response);*/
	}

}











