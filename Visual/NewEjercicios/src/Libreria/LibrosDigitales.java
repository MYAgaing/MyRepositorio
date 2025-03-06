package Libreria;

import java.math.BigDecimal;

public class LibrosDigitales extends Libros{

	
	public LibrosDigitales() {
		this.isFisico = false;
		
	}
	public Boolean getFisico() {
		return this.isFisico;
	}
	public BigDecimal setPeso() {
		return new BigDecimal(0);
	}
}
