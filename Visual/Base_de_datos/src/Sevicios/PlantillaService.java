package Sevicios;

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

import Modelo.Plantilla;

public class PlantillaService extends OpenConnection{
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
			String sql = "Insert into personas values ('" + p.getDni() + "','" + p.getNombre() + "','" + p.getApellidos() + "','" + Date.valueOf(p.getFecha_nacimiento()) + "'";
			System.out.println(sql);
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			System.out.println("Error " + e);
		}
	}
	public void actualizarPersonas() throws SQLException {
		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String sql = "Update personas set nombre = ?, apellidos = ?, dni = ?, fecha_nacimiento = ? where dni = ?";
		try (Connection conn = getNewConnection(); PreparedStatement stmt = conn.prepareStatement(sql)){
			System.out.println("¿De quien deseas cambiarlos?");
			stmt.setString(5, sc.nextLine());
			System.out.println("Digame los datos nombre/apellidos/dni/fecha_nacimiento");
			stmt.setString(1, sc.nextLine());
			stmt.setString(2, sc.nextLine());
			stmt.setString(3, sc.nextLine());
			stmt.setDate(4, Date.valueOf(LocalDate.parse(sc.nextLine(),format)));
			System.out.println(sql);
			stmt.executeUpdate();
		}
	}
	public void borrarPersona() throws SQLException {
		String sql ="Delete from personas where dni = ?";
		try(Connection conn = getNewConnection(); PreparedStatement stmt = conn.prepareStatement(sql)){
			System.out.println("¿Que persona desea borrar?");
			stmt.setString(1, sc.nextLine());
			stmt.execute();
		}
	}

}
