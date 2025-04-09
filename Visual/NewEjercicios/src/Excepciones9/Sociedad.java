package Excepciones9;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import Excepciones6.ParametroIncorrectoException;
import Excepciones6.Persona;

public class Sociedad {

	private Set<Persona> personas;

	public Sociedad() {
		this.personas = new HashSet<>();
	}

	public void addPersona(String genero, BigDecimal altura) throws ParametroIncorrectoException {
		Persona p1 = new Persona(genero, altura);
		try {
			p1.setAltura(altura);
			p1.setGenero(genero);
		} catch (ParametroIncorrectoException e) {
			System.out.println(e.getMessage());
			throw new ParametroIncorrectoException("Parametros Incorrectos");
		}
	}

	public BigDecimal calcularAlturaMediaHombreMujer(String genero) throws ListaVaciaException {
		BigDecimal total = new BigDecimal(0);
		BigDecimal contador = new BigDecimal(0);
		for (Persona persona : personas) {
			if (persona.getGenero().equals(genero)) {
				total = total.add(persona.getAltura());
				contador = contador.add(new BigDecimal(1));
			}
		}
		if(contador.equals(BigDecimal.ZERO)) {
			throw new ListaVaciaException("La lista esta vacia");
		}
		return total.divide(contador);
	}

	public BigDecimal calcularAlturaMedia() throws ListaVaciaException {
		BigDecimal total = new BigDecimal(0);
		BigDecimal contador = new BigDecimal(0);
		for (Persona persona : personas) {
			total = total.add(persona.getAltura());
			contador = contador.add(new BigDecimal(1));
		}
		if(contador.equals(BigDecimal.ZERO)) {
			throw new ListaVaciaException("La lista esta vacia");
		}
		return total.divide(contador);
	}
	public void borrarGenero(String genero) throws ParametroIncorrectoException {
		if(!genero.equalsIgnoreCase("H") && !genero.equalsIgnoreCase("M")) {
			throw new ParametroIncorrectoException("Genero incorrecto");
		}
		Iterator<Persona> iterador = personas.iterator();
		while (iterador.hasNext()) {
			for (Persona persona : personas) {
				if(persona.getGenero().equalsIgnoreCase(genero)) {
					iterador.remove();
				}
			}
			
		}
	}

}
