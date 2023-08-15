package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import conexaojdbc.SingleConnection;
import model.Userposjava;

public class UserPosDAO {
	
	@SuppressWarnings("unused")
	private Connection connection;
	
	public UserPosDAO() {
		
		connection = SingleConnection.getConnection();
	}
	
	public void salvar (Userposjava upserUserposjava) {
		try {
			String sql = "insert into userposjava (id, nome, email) values (?,?,?)";
			PreparedStatement insert = connection.prepareStatement(sql);
			insert.setLong(1, upserUserposjava.getId());
			insert.setString(2, upserUserposjava.getNome());
			insert.setString(3, upserUserposjava.getEmail());
			insert.execute();
			connection.commit(); // salva no banco
			
		} catch (Exception e) {
			try {
				connection.rollback(); // reverte a operação
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		
		
	}

}