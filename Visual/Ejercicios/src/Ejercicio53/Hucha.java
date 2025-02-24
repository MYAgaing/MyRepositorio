package Ejercicio53;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class Hucha {

	private BigDecimal ahorrado;
	
	BigDecimal actual = new BigDecimal(0);
	
	public Hucha() {
		this.ahorrado = BigDecimal.ZERO;
		this.ahorrado = ahorrado.setScale(2);
	}

	public BigDecimal getAhorrado() {
		return ahorrado;
	}

	public void setAhorrado(BigDecimal ahorrado) {
		this.ahorrado = ahorrado;
		ahorrado = ahorrado.setScale(2);
	}

	public BigDecimal meterDinero(BigDecimal x) {
		this.ahorrado = this.ahorrado.add(x).setScale(2, RoundingMode.HALF_DOWN);
		return this.ahorrado;
		
	}
	BigDecimal ahorro;
	public BigDecimal sacarDinero(BigDecimal x) {
		BigDecimal cero = BigDecimal.ZERO;
		if(x==null) {
			return cero;
		}
		if (x.compareTo(ahorrado) > 0) {
			ahorro = this.ahorrado;
			return ahorro;
		} 
		this.ahorrado = this.ahorrado.subtract(x).setScale(2, RoundingMode.HALF_DOWN);
		return x;
	}

	public BigDecimal contarDinero() {
		return ahorrado;
	}
	public BigDecimal romperoHucha() {
		return sacarDinero(ahorro);
	}

	@Override
	public String toString() {
		DecimalFormat formato = new DecimalFormat("#,##0.00€");
		return "Hucha [ahorrado=" + formato.format(ahorrado) + "]";
	}
	
}
