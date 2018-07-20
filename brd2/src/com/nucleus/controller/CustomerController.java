package com.nucleus.controller;


import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nucleus.model.Customer;
import com.nucleus.service.CustomerService;

@WebServlet("/CustomerController")
public class CustomerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Customer customer1;
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		CustomerService service=new CustomerService();
		String action=request.getParameter("action");
		HttpSession session=request.getSession(false);
		System.out.println((String)session.getAttribute("fname"));
		
		if(((String)session.getAttribute("fname"))!=null)
		{
		if(action.equalsIgnoreCase("singleview"))
		{
			RequestDispatcher rd=request.getRequestDispatcher("enterViewId.jsp");
			rd.forward(request, response);
		
		}
		else if(action.equalsIgnoreCase("allview"))
		{
			ArrayList<Customer> customer=service.viewCustomer();
				request.setAttribute("customers", customer);
			    RequestDispatcher rd=request.getRequestDispatcher("ViewCustomer.jsp");
				rd.forward(request, response);
		}
		else if(action.equalsIgnoreCase("home"))
		{
			    RequestDispatcher rd=request.getRequestDispatcher("home.jsp");
				rd.forward(request, response);
		}
		else if(action.equalsIgnoreCase("add"))
		{
			RequestDispatcher rd=request.getRequestDispatcher("addCustomer.jsp");
			rd.forward(request, response);
		}
		else if(action.equalsIgnoreCase("update"))
		{
			RequestDispatcher rd=request.getRequestDispatcher("updateCustomer.jsp");
			rd.forward(request, response);
		}		
		else if(action.equalsIgnoreCase("delete"))
		{
			RequestDispatcher rd=request.getRequestDispatcher("deleteCustomer.jsp");
			rd.forward(request, response);
		}
		else
		{
			session.invalidate();
			RequestDispatcher rd=request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
		}
		}
		else
		{
			RequestDispatcher rd=request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
		}
	}
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
   	{
    	int count1=0;
   		CustomerService service=new CustomerService();
   		Customer customer=new Customer();
   		HttpSession session=request.getSession(false);
		if((String)session.getAttribute("fname")!=null)
		{
   		if((request.getParameter("UpdateCustomer"))!=null)
   		{
   			 customer1 =service.updateCustomer(request.getParameter("Update"));
   			 boolean checkCode=service.checkCode(request.getParameter("Update"));
   			 if(checkCode==true)
   			 {
   			request.setAttribute("customer",customer1);
   			RequestDispatcher rd=request.getRequestDispatcher("update.jsp");
   			rd.forward(request, response);
   			 }
   			 else
   			 {
   				 RequestDispatcher rd=request.getRequestDispatcher("errorCode.jsp");
   				 rd.forward(request, response);
   			 }
   		}
   		if((request.getParameter("add"))!=null)
   		{
   			customer.setCustomer_code(request.getParameter("code"));
   			customer.setCustomer_name(request.getParameter("name"));
   			customer.setCustomer_address1(request.getParameter("add1"));
   			customer.setCustomer_address2(request.getParameter("add2"));
   			customer.setCustomer_pinCode(Integer.parseInt(request.getParameter("pincode")));
   			customer.setEmail_address(request.getParameter("email"));
   			customer.setContact_number(request.getParameter("contact"));
   			customer.setPrimaryConatctPerson(request.getParameter("primary"));
   			customer.setRecord_status(request.getParameter("record"));
   			customer.setActive_inactiveFlag(request.getParameter("flag"));
   			SimpleDateFormat formatter = new SimpleDateFormat("dd/MMM/yyyy");
   			Date date = new Date();
   			customer.setCreate_date(formatter.format(date));
   			customer.setCreated_by((String)session.getAttribute("fname"));
   			customer.setCustomer_id(count1);
   			count1+=1;
   			int count=service.add(customer);
   			if(count==0)
   			{
   				RequestDispatcher rd=request.getRequestDispatcher("alert.jsp");
   	   			rd.forward(request, response);
   			}
   			else
   			{
   			request.setAttribute("count", count);
   			RequestDispatcher rd=request.getRequestDispatcher("updateRows.jsp");
   			rd.forward(request, response);
   			}   			
   		}
   		if((request.getParameter("delete"))!=null)
   		{
   			boolean checkCode=service.checkCode(request.getParameter("delete"));
			 if(checkCode==true)
			 {
				 	int count=service.delete(request.getParameter("delete"));
		   			request.setAttribute("count", count);
		   			RequestDispatcher rd=request.getRequestDispatcher("updateRows.jsp");
		   			rd.forward(request, response);
			 }
			 else
			 {
				 RequestDispatcher rd=request.getRequestDispatcher("errorCode.jsp");
				 rd.forward(request, response);
			 }	
   		}  
   		if((request.getParameter("submitview"))!=null)
   		{
   			boolean checkCode=service.checkCode(request.getParameter("view"));
			 if(checkCode==true)
			 {
				 	String customerid=request.getParameter("view");
		   			customer=service.updateCustomer(customerid);
		   			ArrayList<Customer> cust=new ArrayList<Customer>();
		   			cust.add(customer);
		   			request.setAttribute("customers", cust);
		   			RequestDispatcher rd=request.getRequestDispatcher("ViewCustomer.jsp");
		   			rd.forward(request, response);
			 }
			 else
			 {
				 RequestDispatcher rd=request.getRequestDispatcher("errorCode.jsp");
				 rd.forward(request, response);
			 }   			
   		}
   		if((request.getParameter("Customerupdate"))!=null)
   		{
   			Customer customer2=new Customer();
   			customer2.setCustomer_code(request.getParameter("code"));
   			customer2.setCustomer_name(request.getParameter("name"));
   			customer2.setCustomer_address1(request.getParameter("add1"));
   			customer2.setCustomer_address2(request.getParameter("add2"));
   			customer2.setCustomer_pinCode(Integer.parseInt(request.getParameter("pincode")));
   			customer2.setEmail_address(request.getParameter("email"));
   			customer2.setContact_number(request.getParameter("contact"));
   			customer2.setPrimaryConatctPerson(request.getParameter("primary"));
   			customer2.setRecord_status(request.getParameter("record"));
   			customer2.setActive_inactiveFlag(request.getParameter("flag"));
   			customer2.setCreate_date(request.getParameter("cdate"));
   			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
   			Date date = new Date();
   			customer.setModified_date(formatter.format(date));
   			customer.setModified_by((String)session.getAttribute("fname"));
   			
   			int count=service.update(customer2);
   			request.setAttribute("count", count);
   			RequestDispatcher rd=request.getRequestDispatcher("updateRows.jsp");
   			rd.forward(request, response);
   		}		
   	}    
  }	
}	