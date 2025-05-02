package Plantilla.Modelo;

import java.time.LocalDate;

import Plantilla.Servicios.DatosIncompletosException;

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
	
	public Boolean validar(Plantilla p) throws DatosIncompletosException{
		try {
			if(p.getNombre().isEmpty() || p.getNombre().isBlank()) {
				throw new DatosIncompletosException();
			} else if (p.getApellidos().isEmpty() || p.getApellidos().isBlank()) {
				throw new DatosIncompletosException();
			} else if (p.getDni().isEmpty() || p.getDni().isBlank()) {
				throw new DatosIncompletosException();
			}
		} catch (DatosIncompletosException e) {
			return false;
		}
		return true;
	}
	
	@Override
	public String toString() {
		return "Plantilla [dni=" + dni + ", nombre=" + nombre + ", apellidos=" + apellidos + ", fecha_nacimiento="
				+ fecha_nacimiento + "]";
	}
	
	
}
