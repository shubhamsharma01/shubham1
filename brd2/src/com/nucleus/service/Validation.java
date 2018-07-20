package com.nucleus.service;

import java.text.SimpleDateFormat;
import java.util.Set;

import com.nucleus.model.Customer;



public class Validation 
{
	public String changeDateForamt(String date)
	{
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		String strDate= formatter.format(date);
		return strDate;
	}
	
	public boolean validCustomerCode(Customer customer, Set<String> set) {
		if (customer.getCustomer_code().length() > 10 && set.contains(customer.getCustomer_code()))
		{
			return false;
		} 

		return true;

	}
}
