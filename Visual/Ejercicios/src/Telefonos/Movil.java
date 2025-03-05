package Telefonos;

import java.math.BigDecimal;

public class Movil extends Telefonos {

	private BigDecimal altitud;
	private BigDecimal latitud;
	
	public Movil(Integer numero,BigDecimal altitud,BigDecimal latitud) {
		this.numero = numero;
		this.altitud = altitud;
		this.latitud = latitud;
		this.enLlamada = false;
	}
	
	
}
