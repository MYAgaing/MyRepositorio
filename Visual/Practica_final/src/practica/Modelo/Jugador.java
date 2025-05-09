package practica.Modelo;

import java.time.LocalDate;

/**
 * La clase representa un Jugador
 * 
 * @author NICOLAS
 * @version 1.0
 */

public class Jugador {
	/*
	 *Atributo que guarda el numero del Jugador
	 */
	private Integer numero;
	/*
	 * Atributo que guarda el codigo del equipo que pertenece
	 */
	private String codigo_equipo;
	/*
	 * Atributo que guarda el nombre del jugador
	 */
	private String nombre;
	/*
	 * Atributo que guarda la fecha de nacimiento del jugador
	 */
	private LocalDate fecha_nacimiento;
	
	public Jugador() {
		
	}
	
	/*
	 * @param Los getters and setters de los atributos de Jugador
	 */
	public Integer getNumero() {
		return numero;
	}
	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	public String getCodigo_equipo() {
		return codigo_equipo;
	}
	public void setCodigo_equipo(String codigo_equipo) {
		this.codigo_equipo = codigo_equipo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public LocalDate getFecha_nacimiento() {
		return fecha_nacimiento;
	}
	public void setFecha_nacimiento(LocalDate fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}

	@Override
	public String toString() {
		return "Jugador [numero=" + numero + ", codigo_equipo=" + codigo_equipo + ", nombre=" + nombre
				+ ", fecha_nacimiento=" + fecha_nacimiento + "]";
	}
	
	
	
}
