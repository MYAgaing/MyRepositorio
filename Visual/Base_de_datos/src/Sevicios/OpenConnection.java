package Sevicios;

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
/*
 * 
public class OpenConnection {
    public Connection abrirConexion() {
        String urlConexion = "jdbc:oracle:thin:@//localhost:1521/xe";
        String driver = "oracle.jdbc.driver.OracleDriver";
        String usuario = "SYSTEM";
        String password = "root";
 
        try {
            Class.forName(driver);
            return DriverManager.getConnection(urlConexion, usuario, password);
        } catch (Exception e) {
            System.out.println("No he podido abrir la conexión");
            e.printStackTrace();
        }
        return null;
    }
 
    public void testConexion() {
        Connection conn = abrirConexion();
        System.out.println("Esta es mi conexión " + conn);
        if (conn != null) {
            System.out.println("TODO OK");
        } else {
            System.out.println("Esto no funciona");
        }
    }
}
 * */
}
