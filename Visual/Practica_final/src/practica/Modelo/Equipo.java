package practica.Modelo;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;

public class Equipo {

	private String codigo;
	private String nombre;
	private List<Jugador> jugadores;
	
	public Equipo () {
		
	}
	
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

	public BigDecimal getEdadMedia() {
		BigDecimal media = new BigDecimal(0);
		for (Jugador jugador : jugadores) {
			Period periodo = jugador.getFecha_nacimiento().until(LocalDate.now());
			 media = media.add(new BigDecimal(periodo.getYears()));
		}
		return media.divide(new BigDecimal(jugadores.size())).setScale(2);
	}

	
	
}
