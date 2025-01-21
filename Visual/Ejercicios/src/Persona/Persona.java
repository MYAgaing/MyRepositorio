package Persona;

import java.util.Objects;

public class Persona {

	private String nombre;
	private Integer edad;
	
	public Persona() {
		
	}
	
	
	
	@Override
	public int hashCode() {
		return Objects.hash(edad, nombre);
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Persona other = (Persona) obj;
		return Objects.equals(edad, other.edad) && Objects.equals(nombre, other.nombre);
	}



	public Persona(String nombre, Integer edad, Integer nota) {
		
		
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Integer getEdad() {
		return edad;
	}
	public void setEdad(Integer edad) {
		this.edad = edad;
	}
	
	
}
