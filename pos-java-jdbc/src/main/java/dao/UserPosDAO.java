package dao;

import java.sql.Connection;

import conexaojdbc.SingleConnection;

public class UserPosDAO {
	
	@SuppressWarnings("unused")
	private Connection connection;
	
	public UserPosDAO() {
		
		connection = SingleConnection.getConnection();
		
	}

}
