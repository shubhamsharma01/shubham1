package com.nucleus.DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

import com.nucleus.connection.ConnectionI;
import com.nucleus.connection.OracleConnection;
import com.nucleus.model.Customer;


public class CustomerDao implements CustomerDaoI
{
	Connection conn=null;
	ConnectionI c=null;
	PreparedStatement ps=null;
	
	public ArrayList<Customer> fetchAll()
	{
		c=new OracleConnection();
		conn=c.myConnection();
		Statement stmt=null;
		ResultSet rs=null;
		
		ArrayList<Customer> customer=new ArrayList<Customer>();
			try 
			{
				stmt=conn.createStatement();
				rs=stmt.executeQuery("select * from customer_entry");
				while(rs.next())
				{
					Customer c=new Customer();
					c.setCustomer_id(rs.getInt(1));
					c.setCustomer_code(rs.getString(2));
					c.setCustomer_name(rs.getString(3));
					c.setCustomer_address1(rs.getString(4));
					c.setCustomer_address2(rs.getString(5));
					c.setCustomer_pinCode(rs.getInt(6));
					c.setEmail_address(rs.getString(7));
					c.setContact_number(rs.getString(8));
					c.setPrimaryConatctPerson(rs.getString(9));
					c.setRecord_status(rs.getString(10));
					c.setActive_inactiveFlag(rs.getString(11));
					c.setCreate_date(rs.getString(12));
					c.setCreated_by(rs.getString(13));
					c.setModified_date(rs.getString(14));
					c.setModified_by(rs.getString(15));
					c.setAuthorized_date(rs.getString(16));
					c.setAuthorized_by(rs.getString(17));
					customer.add(c);	
				}
			}
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
				return customer;		
	}	
	@Override
	public int updateCustomer(Customer customer) 
	{
		int count=0;
		try
		{
		c=new OracleConnection();
		conn=c.myConnection();
	//	conn.setAutoCommit(false);
		ps=conn.prepareStatement("update customer_entry set customer_name=?, customer_address1=?, customer_address2=?,"
				+ "customer_pincode=?, email_address=?,contact_number=?, primary_contact_person=?,"
				+ "record_status=?, active_inactive_flag=?,"
				+ "modified_date=?, modifies_by=?" + "where customer_code=?");
						
			ps.setString(1, customer.getCustomer_name());
			ps.setString(2, customer.getCustomer_address1());
			ps.setString(3, customer.getCustomer_address2());
			ps.setInt(4, customer.getCustomer_pinCode());
			ps.setString(5, customer.getEmail_address());
			ps.setString(6, customer.getContact_number());
			ps.setString(7, customer.getPrimaryConatctPerson());
			ps.setString(8, customer.getRecord_status());
			ps.setString(9, customer.getActive_inactiveFlag());
			ps.setString(10, customer.getModified_date());
			ps.setString(11, customer.getModified_by());
			ps.setString(12, customer.getCustomer_code());
			count=ps.executeUpdate();	
		}
		catch (Exception e)
		{
			System.out.println(e);
		}
		finally
		{
			try {
				conn.commit();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}		
		}		
		return count;		
	}	
	@Override
	public int deleteCustomer(String id) {
		int count=0;
		try
		{
		c=new OracleConnection();
		conn=c.myConnection();
		ps=conn.prepareStatement("delete from customer_entry where customer_code = ?");
		ps.setString(1, id);
		count=ps.executeUpdate();
		}
		catch (Exception e) {
			System.out.println(e);
		}
		return count;		
	}	
	@Override
	public int addCustomer(Customer customer)
	{	int rowsAffected=0;
		try{
		c=new OracleConnection();
		conn=c.myConnection();
		PreparedStatement ps=null;
		ps = conn.prepareStatement("insert into customer_entry values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");

		ps.setInt(1, customer.getCustomer_id());
		ps.setString(2, customer.getCustomer_code());
		ps.setString(3, customer.getCustomer_name());
		ps.setString(4, customer.getCustomer_address1());
		ps.setString(5, customer.getCustomer_address2());
		ps.setInt(6, customer.getCustomer_pinCode());
		ps.setString(7, customer.getEmail_address());
		ps.setString(8, customer.getContact_number());
		ps.setString(9, customer.getPrimaryConatctPerson());
		ps.setString(10, customer.getRecord_status());
		ps.setString(11, customer.getActive_inactiveFlag());
		ps.setString(12, customer.getCreate_date());
		ps.setString(13, customer.getCreated_by());
		ps.setString(14, customer.getModified_date());
		ps.setString(15, customer.getModified_by());
		ps.setString(16, customer.getAuthorized_date());
		ps.setString(17, customer.getAuthorized_by());

		rowsAffected = ps.executeUpdate();
	} catch (SQLException e) {
	//	System.err.println("ERROR OCCURED");
		e.printStackTrace();
	}

	return rowsAffected;	
	}
	@Override
	public Customer viewupdate(String id) {
		c=new OracleConnection();
		conn=c.myConnection();
		Statement stmt=null;
		ResultSet rs=null;		
		Customer c=new Customer();
			try 
			{
				stmt=conn.createStatement();
				rs=stmt.executeQuery("select * from customer_entry where customer_code= '"+id+"'");				
				while(rs.next())
				{
					c.setCustomer_id(rs.getInt(1));
					c.setCustomer_code(rs.getString(2));
					c.setCustomer_name(rs.getString(3));
					c.setCustomer_address1(rs.getString(4));
					c.setCustomer_address2(rs.getString(5));
					c.setCustomer_pinCode(rs.getInt(6));
					c.setEmail_address(rs.getString(7));
					c.setContact_number(rs.getString(8));
					c.setPrimaryConatctPerson(rs.getString(9));
					c.setRecord_status(rs.getString(10));
					c.setActive_inactiveFlag(rs.getString(11));
					c.setCreate_date(rs.getString(12));
					c.setCreated_by(rs.getString(13));
					c.setModified_date(rs.getString(14));
					c.setModified_by(rs.getString(15));
					c.setAuthorized_date(rs.getString(16));
					c.setAuthorized_by(rs.getString(17));						
				}
			}
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
				return c;		
	}	
	public Set<String> fetch_customer_code()	
	{
		Set<String> ts=new TreeSet<String>();
		try 
		{
			c=new OracleConnection();
			conn=c.myConnection();
			Statement stmt=null;
			ResultSet rs=null;
			stmt=conn.createStatement();
			rs=stmt.executeQuery("select customer_code from customer_entry");
			while(rs.next())
			{
				String code=rs.getString(1);
				ts.add(code);
			}		
	}
		catch(Exception e)
		{}
		return ts;
	}
}