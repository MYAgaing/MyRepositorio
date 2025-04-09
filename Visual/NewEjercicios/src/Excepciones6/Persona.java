package Excepciones6;

import java.math.BigDecimal;

public class Persona {

	private String genero;
	private BigDecimal altura;

	public Persona(String genero2, BigDecimal altura2) {

	}

	public Persona() {

	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) throws ParametroIncorrectoException {
		if (genero.equalsIgnoreCase("H") || genero.equalsIgnoreCase("M")) {
			this.genero = genero.toUpperCase();
		} else {
			throw new ParametroIncorrectoException("H/M");
		}
	}

	public BigDecimal getAltura() {
		return altura;
	}

	public void setAltura(BigDecimal altura) throws ParametroIncorrectoException {
		if (altura.compareTo(BigDecimal.ZERO) <= 0 || altura.compareTo(new BigDecimal(3)) >= 0) {
			throw new ParametroIncorrectoException("Entre 0 y 3");
		}
		this.altura = altura;

	}

	@Override
	public String toString() {
		return "Persona: " + genero + " " + altura;
	}

}
