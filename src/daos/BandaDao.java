package daos;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import java.util.List;

import classes.Banda;

import servlets.ConnectionFactory;

public class BandaDao {
	
	private Connection connection;

	public BandaDao() throws ClassNotFoundException {
		this.connection = new ConnectionFactory().getConnection();
	}
	
	public void adcionar(Banda banda) {
		String sql = "insert into bandas " +
				 "(nome, genero)"+
				 "value (?,?)";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			stmt.setString(1, banda.getNome());
			stmt.setString(2, banda.getGenero());
			
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public Banda pesquisar(String id) {
		String sql ="select * from bandas where id = ?";
		
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, id);
			ResultSet rs = stmt.executeQuery();
			
			Banda banda = new Banda();
			
			while(rs.next()) {
			
			banda.setId(rs.getLong("id"));
			banda.setNome(rs.getString("nome"));
			banda.setGenero(rs.getString("genero"));
			
			}
			
			rs.close();
			stmt.close();
			return banda;
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}
	
	public List<Banda> getLista() {
		try {
			List<Banda> bandas = new ArrayList<Banda>();
			PreparedStatement stmt = this.connection.prepareStatement("select * from bandas");
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				Banda banda = new Banda();
				banda.setId(rs.getLong("id"));
				banda.setNome(rs.getString("nome"));
				banda.setGenero(rs.getString("genero"));
				bandas.add(banda);
			}
			rs.close();
			stmt.close();
			return bandas;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void alterar(Banda banda) {
		String sql = "update bandas set nome=?, genero=?" +
						" where id=?";
		
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, banda.getNome());
			stmt.setString(2, banda.getGenero());
			stmt.setLong(3, banda.getId());
			
			stmt.execute();	
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void deletar(Banda banda) {
		String sql = "delete from bandas where id=?";
		
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setLong(1, banda.getId());
			stmt.execute();	
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	
	
	

}
