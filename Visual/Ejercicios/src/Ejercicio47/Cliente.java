package Ejercicio47;

import java.time.LocalDate;

public class Cliente extends Carrito{

	private String dni;
	private String nombre;
	
	public Cliente(String dni,String nombre) {
		fecha_creacion = LocalDate.now();
		fecha_ultima = LocalDate.now();
		
	}

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
	
}
