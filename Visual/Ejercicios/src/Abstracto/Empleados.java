package Abstracto;

import java.util.ArrayList;
import java.util.List;

public abstract class Empleados extends Peliculas{
	public static final Integer Sueldo_Actor = 100000;
	public static final Integer Sueldo_Guionista = 50000;
	public static final Integer Sueldo_director = 200000;
	private String nombre;
	private Integer año;
	private String nacionalidad;
	private List<Empleados> actor;
	
	public Empleados() {
		this.actor = new ArrayList<>();
	}
	
	public abstract Integer getSueldo();
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Integer getAño() {
		return año;
	}
	public void setAño(Integer año) {
		this.año = año;
	}
	public String getNacionalidad() {
		return nacionalidad;
	}
	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}
	public List<Empleados> getActor() {
		return actor;
	}
	public void setActor(List<Empleados> actor) {
		this.actor = actor;
	}
	
	
}
