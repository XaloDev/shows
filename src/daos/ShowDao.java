package daos;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import classes.Show;
import servlets.ConnectionFactory;

public class ShowDao {
	
	private Connection connection;

	public ShowDao() throws ClassNotFoundException {
		this.connection = new ConnectionFactory().getConnection();
	}
	
	public void adcionar(Show show) {
		String sql = "insert into shows" +
				 "(nome, dataShow, localShow, bandas )"+
				 "value (?,?,?,?)";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			stmt.setString(1, show.getNome());
			stmt.setDate(2, new java.sql.Date(show.getDataShow().getTimeInMillis()));
			stmt.setString(3, show.getLocal());
			stmt.setString(4, show.getBandas());
			
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public Show pesquisar(String id) {
		String sql ="select * from shows where id = ?";
		
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, id);
			ResultSet rs = stmt.executeQuery();
			
			Show show = new Show();
			
			while(rs.next()) {
			
			show.setId(rs.getLong("id"));
			show.setNome(rs.getString("nome"));
			show.setLocal(rs.getString("localShow"));
			show.setBandas(rs.getString("bandas"));
			
			
			Calendar data = Calendar.getInstance();
			data.setTime(rs.getDate("dataShow"));
			show.setDataShow(data);
			
			}
			
			rs.close();
			stmt.close();
			return show;
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}
	
	public List<Show> getLista() {
		try {
			List<Show> shows = new ArrayList<Show>();
			PreparedStatement stmt = this.connection.prepareStatement("select * from shows");
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				Show show = new Show();
				show.setId(rs.getLong("id"));
				show.setNome(rs.getString("nome"));
				show.setBandas(rs.getString("bandas"));
				show.setLocal(rs.getString("localShow"));
				
				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("dataShow"));
				show.setDataShow(data);
				
				shows.add(show);
			}
			rs.close();
			stmt.close();
			return shows;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void alterar(Show show) {
		String sql = "update shows set nome=?, dataShow=?, localShow=?, bandas=?" +
						" where id=?";
		
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, show.getNome());
			stmt.setDate(2, new Date(show.getDataShow().getTimeInMillis()));
			stmt.setString(3, show.getLocal());
			stmt.setString(4, show.getBandas());
			stmt.setLong(5, show.getId());
			
			stmt.execute();	
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void deletar(Show show) {
		String sql = "delete from shows where id=?";
		
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setLong(1, show.getId());
			stmt.execute();	
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	
	
	

}
