package Juego;

public class Jugador {

	private String nombre;
	private EquipoCombate equipo_de_combate;
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public EquipoCombate getEquipo_de_combate() {
		return equipo_de_combate;
	}
	public void setEquipo_de_combate(EquipoCombate equipo_de_combate) {
		this.equipo_de_combate = equipo_de_combate;
	}
	@Override
	public String toString() {
		return "Jugador [nombre=" + nombre + ", equipo_de_combate=" + equipo_de_combate + "]";
	}
	
	
	
}
