package Sevicios;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Modelo.Plantilla;

public class PlantillaService {

	private OpenConnection openConn;

	public PlantillaService() throws SQLException {
		openConn = new OpenConnection();
	}

	public Plantilla consultarPersona(String plantilla1) throws SQLException {
		ResultSet rs = null;
		try (Connection conn = openConn.getNewConnection(); Statement stmt = conn.createStatement()) {
			String sql = "Select * from PERSONAS WHERE DNI = '" + plantilla1 + "'";
			rs = stmt.executeQuery(sql);

			if (rs.next()) {
				Plantilla p = new Plantilla();
				p.setNombre(rs.getString("NOMBRE"));
				p.setDni(rs.getString("DNI"));
				p.setApellidos(rs.getString("APELLIDOS"));
				p.setFecha_nacimiento(rs.getDate("FECHA_NACIMIENTO").toLocalDate());
				return p;
			} else {
				return null;
			}
		}

	}

	public List<Plantilla> buscarPersonas(String nombre) throws SQLException {
		List<Plantilla> lista1 = new ArrayList<>();
		try (Connection conn = openConn.getNewConnection(); Statement stmt = conn.createStatement()) {
			String sql = "Select * from PERSONAS WHERE DNI = '" + nombre + "' and APELLIDOS = '" + nombre + "'";
			ResultSet rs = null;
			rs = stmt.executeQuery(sql);

			if (rs.next()) {
				Plantilla p = new Plantilla();
				p.setNombre(rs.getString("NOMBRE"));
				p.setDni(rs.getString("DNI"));
				p.setApellidos(rs.getString("APELLIDOS"));
				p.setFecha_nacimiento(rs.getDate("FECHA_NACIMIENTO").toLocalDate());
				lista1.add(p);
			} else {
				return null;
			}
		}
		return lista1;
	}

	public void isertarPersona(Plantilla p, String s) throws SQLException {
		try (Connection conn = openConn.getNewConnection(); Statement stmt = conn.createStatement()) {
			String sql = "Insert into personas values ('" + p.getDni() + "','" + p.getNombre() + "','" + p.getApellidos() + "',to_date('" + s +"','dd/MM/yyyy'))";
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			System.out.println("Error " + e);
		}
	}

}
