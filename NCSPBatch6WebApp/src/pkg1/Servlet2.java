package pkg1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Servlet2
 */
//@WebServlet("/S2")
public class Servlet2 extends HttpServlet {
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
    public Servlet2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		
		/*ServletConfig servletConfig=getServletConfig();
		email=servletConfig.getInitParameter("email");*/
		out.println("Email: "+email);
		out.println("Contact Person Details: "+contactp);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		out.println("<br>Servlet2<br>");
		String str=request.getParameter("t1");
		out.println(str);
		String a=(String)request.getAttribute("a");
		out.println(a);
	}

}
