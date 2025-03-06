package Libreria;

import java.math.BigDecimal;

public class LibrosFisicos extends Libros{

	private BigDecimal ancho;
	private BigDecimal alto;
	
	public LibrosFisicos() {
		isFisico = true;
	}
	public Boolean getFisico() {
		return this.isFisico;
	}
	
	public BigDecimal getAncho() {
		return ancho;
	}
	public void setAncho(BigDecimal ancho) {
		this.ancho = ancho;
	}
	public BigDecimal getAlto() {
		return alto;
	}
	public void setAlto(BigDecimal alto) {
		this.alto = alto;
	}
	public BigDecimal setPeso() {
		return peso;
	}
	
}
