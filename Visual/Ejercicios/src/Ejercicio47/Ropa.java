package Ejercicio47;

import java.math.BigDecimal;

public class Ropa extends Articulos{

	private String talla;
	private String color;
	
	public Ropa(BigDecimal precio,String nombre,String talla,String color) {
		
	}

	public String getTalla() {
		return talla;
	}

	public void setTalla(String talla) {
		this.talla = talla;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	
}
