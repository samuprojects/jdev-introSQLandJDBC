package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conexaojdbc.SingleConnection;
import model.BeanUserFone;
import model.Telefone;
import model.Userposjava;

public class UserPosDAO {
	
	private Connection connection;
	
	public UserPosDAO() {
		
		connection = SingleConnection.getConnection();
	}
	
	public void salvar (Userposjava userposjava) {
		try {
			String sql = "insert into userposjava (nome, email) values (?,?)"; // String do SQL
			//Retorna o objeto da instrução
			PreparedStatement insert = connection.prepareStatement(sql);
			insert.setString(1, userposjava.getNome()); // Parâmetro sendo adicionado
			insert.setString(2, userposjava.getEmail());
			insert.execute(); // SQL sendo executado no banco de dados
			connection.commit(); // salva no banco
			
		} catch (Exception e) {
			try {
				connection.rollback(); // reverte a operação caso tenha erros
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}		
	}
	
	public void salvarTelefone(Telefone telefone) {
		try {
			
			String sql = "INSERT INTO telefoneuser(numero, tipo, usuariopessoa) VALUES (?, ?, ?);";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, telefone.getNumero());
			statement.setString(2, telefone.getTipo());
			statement.setLong(3, telefone.getUsuario());
			statement.execute();
			connection.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}		
	}
	
	public List<Userposjava> listar() throws Exception {
		List<Userposjava> list = new ArrayList<Userposjava>(); // Lista de retorno do método
		
		String sql = "select * from userposjava"; // Instrução SQL
		
		PreparedStatement statement = connection.prepareStatement(sql);
		ResultSet resultado = statement.executeQuery();
		
		while (resultado.next()) {
			Userposjava userposjava = new Userposjava();
			userposjava.setId(resultado.getLong("id"));
			userposjava.setNome(resultado.getString("nome"));
			userposjava.setEmail(resultado.getString("email"));
			
			list.add(userposjava);
		}
		
		return list;
	}
	
	public Userposjava buscar(Long id) throws Exception {
		Userposjava retorno = new Userposjava();
		
		String sql = "select * from userposjava where id = " + id;
		
		PreparedStatement statement = connection.prepareStatement(sql);
		ResultSet resultado = statement.executeQuery();
		
		while (resultado.next()) { // retorna apenas um ou nenhum
			
			retorno.setId(resultado.getLong("id"));
			retorno.setNome(resultado.getString("nome"));
			retorno.setEmail(resultado.getString("email"));
			
		}
		
		return retorno;
	}
	
	public List<BeanUserFone> listaUserFone (Long idUser){
		
		List<BeanUserFone> beanUserFones = new ArrayList<BeanUserFone>();
		
		String sql = " select nome, numero, email from telefoneuser as fone ";
		sql += " inner join userposjava as userp ";
		sql += " on fone.usuariopessoa = userp.id ";
		sql += " where userp.id = " + idUser;
		
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();
			
			while (resultSet.next()) {
				BeanUserFone userFone = new BeanUserFone();
				
				userFone.setEmail(resultSet.getString("email"));
				userFone.setNome(resultSet.getString("nome"));
				userFone.setNumero(resultSet.getString("numero"));
				
				beanUserFones.add(userFone);
			}

			
		} catch (Exception e) {
			e.printStackTrace();
		}
			
		return beanUserFones;
	}
	
	public void atualizar (Userposjava userposjava) {
		
		try {
			
			String sql = "update userposjava set nome = ? where id = " + userposjava.getId();
			
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, userposjava.getNome());
			
			statement.execute();
			connection.commit();
			
		} catch (Exception e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
			}			
		}
	
		public void deletar(Long id) {
			try {
				
				String sql = "delete from userposjava where id = " + id; // SQL para delete
				PreparedStatement preparedStatement = connection.prepareStatement(sql); // Compilando
				preparedStatement.execute(); // Executando no banco
				connection.commit(); // Efetuando o commit/gravando no banco de dados
				
			} catch (Exception e) {
				try {
					connection.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				e.printStackTrace();
			}
		}
		
		public void deleteFonesPorUser(Long idUser) {
			
			try {
				
				String sqlFone = "delete from telefoneuser where usuariopessoa =" + idUser;
				String sqlUser = "delete from userposjava where id =" + idUser;
				
				PreparedStatement preparedStatement = connection.prepareStatement(sqlFone);
				preparedStatement.executeUpdate();
				connection.commit();
				
				preparedStatement = connection.prepareStatement(sqlUser);
				preparedStatement.executeUpdate();
				connection.commit();
				
			} catch (Exception e) {
				e.printStackTrace();
				try {
					connection.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}			
		}
}
