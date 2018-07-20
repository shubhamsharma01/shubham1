package com.nucleus.DAO;

import java.sql.SQLException;

public interface LoginDaoI {

	
	public boolean fetchUser(String u,String p) throws SQLException;
}
