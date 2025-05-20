package model.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class OpenConnection {

	public Connection getNewConnection() throws SQLException {
		String usuario = "NICOLAS";
		String password = "1234";

		String driverClass = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost";
		try {
			Class.forName(driverClass);
		} catch (ClassNotFoundException e) {
			System.err.println("No se encuentra el driver JDBC.Revisa tu configuracion");
			throw new RuntimeException(e);
		}
		Connection conn = DriverManager.getConnection(url, usuario, password);
		conn.setAutoCommit(false);
		return conn;
		
	}

}
