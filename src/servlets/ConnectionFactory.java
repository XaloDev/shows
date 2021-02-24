package servlets;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	public Connection getConnection() throws ClassNotFoundException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			return	DriverManager.getConnection("jdbc:mysql://localhost/shows","root","12345678");
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
