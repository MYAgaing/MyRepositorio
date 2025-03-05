package Telefonos;

public class Fijo extends Telefonos {
	
	private String direccion;

	
	public Fijo(Integer numero,String direccion) {
		this.numero = numero;
		this.direccion = direccion;
		this.enLlamada = false;
	}
}
