package Ejercicio47;

import java.math.BigDecimal;

public class Articulos {

	private String descripcion;
	private BigDecimal precio;
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public BigDecimal getPrecio() {
		return precio;
	}
	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}
	@Override
	public String toString() {
		return "Articulos [descripcion=" + descripcion + ", precio=" + precio + "]";
	}
	
	
}
