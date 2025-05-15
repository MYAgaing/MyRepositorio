package Examen.Modulo;

import java.math.BigDecimal;

public class Libro_segunda extends Libro{

	private Integer antiguedad;

	
	
	

	public Libro_segunda(String titulo, String autor, String ISBN, BigDecimal precio, Integer antiguedad) {
		super(titulo, autor, ISBN, precio);
		this.antiguedad = antiguedad;
	}
	@Override
	public BigDecimal getPrecio() {
		return getPrecio().divide(new BigDecimal(2));
	}

	public Integer getAntiguedad() {
		return antiguedad;
	}

	public void setAntiguedad(Integer antiguedad) {
		this.antiguedad = antiguedad;
	}
	
	
	
}
