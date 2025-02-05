package Abstracto;

import java.util.ArrayList;
import java.util.List;

public class Peliculas {
	 

	private Integer año;
	private String titulo;
	private List<Actor> actores;
	private String guionista;
	private String director;
	
	public Peliculas() {
		actores = new ArrayList<>();
	}
	
	public Integer getAño() {
		return año;
	}
	public void setAño(Integer año) {
		this.año = año;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getGuionista() {
		return guionista;
	}
	public void setGuionista(String guionista) {
		this.guionista = guionista;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public List<Peliculas> getTrabajadores() {
		return trabajadores;
	}
	public void setTrabajadores(List<Peliculas> trabajadores) {
		this.trabajadores = trabajadores;
	}
	
}
