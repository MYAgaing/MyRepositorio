package Modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

import Sevicios.OpenConnection;

public class Plantilla {

	private String dni;
	private String nombre;
	private String apellidos;
	private LocalDate fecha_nacimiento;
	
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public LocalDate getFecha_nacimiento() {
		return fecha_nacimiento;
	}
	public void setFecha_nacimiento(LocalDate fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}
	
	String sql = "Select * from PERSONAS";
	
	try (Connection conn = getNewConnection();
			Statement stmt = conn.createStatement()){
		ResultSet rs = stmt.executeQuery(sql);
		
		while (rs.next()){
			String nombre = rs.getString("Nombre");
			String dni = rs.getString("dni");
			String apellido = rs.getString("apellido");
		}
	} catch (SQLException e) {
		System.err.println("Error accdediendo a BBDD");
	}
}
