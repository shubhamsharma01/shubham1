package com.nucleus.DAO;

import java.util.ArrayList;

import com.nucleus.model.Customer;



public interface CustomerDaoI {
	
	public ArrayList<Customer> fetchAll();
	public int updateCustomer(Customer customer);
	public int deleteCustomer(String id);
	public int addCustomer(Customer customer);
	public Customer viewupdate(String id);
	
}
