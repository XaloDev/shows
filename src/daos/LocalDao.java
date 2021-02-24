package daos;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import java.util.List;

import classes.Local;
import servlets.ConnectionFactory;

public class LocalDao {
	
	private Connection connection;

	public LocalDao() throws ClassNotFoundException {
		this.connection = new ConnectionFactory().getConnection();
	}
	
	public void adcionar(Local local) {
		String sql = "insert into locais" +
				 "(nome, capacidade ,endereco)"+
				 "value (?,?,?)";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			stmt.setString(1, local.getNome());
			stmt.setInt(2, local.getCapacidade());
			stmt.setString(3, local.getEndereco());
			
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public Local pesquisar(String id) {
		String sql ="select * from locais where id = ?";
		
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, id);
			ResultSet rs = stmt.executeQuery();
			
			Local local = new Local();
			
			while(rs.next()) {
			
			local.setId(rs.getLong("id"));
			local.setNome(rs.getString("nome"));
			local.setCapacidade(rs.getInt("capacidade"));
			local.setEndereco(rs.getString("endereco"));
			
			}
			
			rs.close();
			stmt.close();
			return local;
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}
	
	public List<Local> getLista() {
		try {
			List<Local> locais = new ArrayList<Local>();
			PreparedStatement stmt = this.connection.prepareStatement("select * from locais");
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				Local local = new Local();
				local.setId(rs.getLong("id"));
				local.setNome(rs.getString("nome"));
				local.setCapacidade(rs.getInt("capacidade"));
				local.setEndereco(rs.getString("endereco"));
				
				locais.add(local);
			}
			rs.close();
			stmt.close();
			return locais;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void alterar(Local local) {
		String sql = "update locais set nome=?, capacidade=?, endereco=?" +
						" where id=?";
		
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, local.getNome());
			stmt.setLong(2, local.getCapacidade());
			stmt.setString(3, local.getEndereco());
			stmt.setLong(4, local.getId());
			
			stmt.execute();	
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void deletar(Local local) {
		String sql = "delete from locais where id=?";
		
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setLong(1, local.getId());
			stmt.execute();	
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	
	
	

}
