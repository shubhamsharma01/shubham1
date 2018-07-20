package com.nucleus.dao;

import com.nucleus.model.User;

public class UserDAODBImpl implements UserDAO 
{

	@Override
	public void save(User user) {
		System.out.println("user saved");
		
	}

}
