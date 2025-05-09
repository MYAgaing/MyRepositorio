package practica.Modelo;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;

/**
 * La clase representa un Equipo
 * 
 * @author NICOLAS
 * @version 1.0
 */

public class Equipo {
	/*
	 * Codigo del equipo
	 */
	private String codigo;
	
	/*
	 * Nombre del equipo
	 */
	private String nombre;
	/*
	 * Lista que guarda los jugadores
	 */
	private List<Jugador> jugadores;

	public Equipo() {

	}
	
	/*
	 * @param Los getters y setters de los atributos de la clase Equipo
	 */

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Jugador> getJugadores() {
		return jugadores;
	}

	public void setJugadores(List<Jugador> jugadores) {
		this.jugadores = jugadores;
	}

	@Override
	public String toString() {
		return "Equipo [codigo=" + codigo + ", nombre=" + nombre + ", jugadores=" + jugadores + "]";
	}
	/*
	 * @return El siguiente metodo devuelve la edad media de la lista de jugadores
	 */

	public BigDecimal getEdadMedia() {
		BigDecimal media = new BigDecimal(0);
		for (Jugador jugador : jugadores) {
			Period periodo = jugador.getFecha_nacimiento().until(LocalDate.now());
			media = media.add(new BigDecimal(periodo.getYears()));
		}
		return media.divide(new BigDecimal(jugadores.size())).setScale(2);
	}

}
