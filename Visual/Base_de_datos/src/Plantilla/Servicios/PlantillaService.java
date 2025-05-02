package Plantilla.Servicios;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Plantilla.Modelo.Plantilla;

public class PlantillaService extends OpenConnection {
	Scanner sc = new Scanner(System.in);
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
				Plantilla p1 = new Plantilla();
				p1.setNombre(rs.getString("NOMBRE"));
				p1.setDni(rs.getString("DNI"));
				p1.setApellidos(rs.getString("APELLIDOS"));
				p1.setFecha_nacimiento(rs.getDate("FECHA_NACIMIENTO").toLocalDate());
				return p1;
			} else {
				return null;
			}
		}

	}

	public List<Plantilla> buscarPersonas(String nombre) throws SQLException {
		List<Plantilla> lista1 = new ArrayList<>();
		try (Connection conn = openConn.getNewConnection(); Statement stmt = conn.createStatement()) {
			String sql = "Select * from PERSONAS WHERE DNI like '%" + nombre + "%' or APELLIDOS like'%" + nombre + "%'";
			ResultSet rs = null;
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				Plantilla p = new Plantilla();
				p.setNombre(rs.getString("NOMBRE"));
				p.setDni(rs.getString("DNI"));
				p.setApellidos(rs.getString("APELLIDOS"));
				p.setFecha_nacimiento(rs.getDate("FECHA_NACIMIENTO").toLocalDate());
				lista1.add(p);
			}
		}
		return lista1;
	}

	public void insertarPersona(Plantilla p) throws SQLException {
		try (Connection conn = openConn.getNewConnection(); Statement stmt = conn.createStatement()) {
			String sql = "Insert into personas values ('" + p.getDni() + "','" + p.getNombre() + "','"
					+ p.getApellidos() + "','" + Date.valueOf(p.getFecha_nacimiento()) + "'";
			System.out.println(sql);
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			System.out.println("Error " + e);
		}
	}

	public void actualizarPersonas() throws SQLException {
		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String sql = "Update personas set nombre = (?), apellidos = (?), dni = (?), fecha_nacimiento = (?) where dni = (?)";
		String sql2 = "Select * from personas where dni = (?)";
		try (Connection conn = getNewConnection();
				PreparedStatement stmt = conn.prepareStatement(sql);
				PreparedStatement stmt2 = conn.prepareStatement(sql2)) {
			System.out.println("¿De quien deseas cambiarlos?");
			String dni = sc.nextLine();
			stmt2.setString(1, dni);
			stmt2.executeUpdate(sql2);
			Integer num = stmt2.executeUpdate();
			if (num == 0) {
				throw new SQLException();
			} else {
				stmt.setString(5, sc.nextLine());
				System.out.println("Digame los datos nombre/apellidos/dni/fecha_nacimiento");
				stmt.setString(1, sc.nextLine());
				stmt.setString(2, sc.nextLine());
				stmt.setString(3, sc.nextLine());
				stmt.setDate(4, Date.valueOf(LocalDate.parse(sc.nextLine(), format)));
				System.out.println(sql);
				stmt.executeUpdate();
			}
		}
	}

	public void borrarPersona() throws SQLException {
		String sql = "Delete from personas where dni = (?)";
		String sql2 = "Select * from personas where dni = (?)";
		try (Connection conn = getNewConnection();
				PreparedStatement stmt = conn.prepareStatement(sql);
				PreparedStatement stmt2 = conn.prepareStatement(sql2)) {
			System.out.println("¿Que persona desea borrar?");
			String dni = sc.nextLine();
			stmt2.setString(1, dni);
			stmt2.executeUpdate(sql2);
			Integer num = stmt2.executeUpdate();
			if (num == 0) {
				throw new SQLException();
			} else {
				stmt.setString(1, dni);
				stmt.execute();
			}
		}
	}

	public void insertarListaPersonas(List<Plantilla> lista) throws SQLException {

		String sql = "Insert into personas values ((?),(?),(?),(?))";
		try (Connection conn = getNewConnection(); PreparedStatement stmt = conn.prepareStatement(sql);) {
			conn.setAutoCommit(false);
			try {
				for (Plantilla plantilla : lista) {
					stmt.setString(1, plantilla.getDni());
					stmt.setString(2, plantilla.getNombre());
					stmt.setString(3, plantilla.getApellidos());
					stmt.setDate(4, Date.valueOf(plantilla.getFecha_nacimiento()));
					stmt.executeUpdate();
				}
			} catch (SQLException e) {
				System.out.println("Error al introducir la lista de usuarios");
				conn.rollback();
				throw new SQLException();
			}
			conn.commit();
			System.out.println("Esta bien");
		}
	}

}
