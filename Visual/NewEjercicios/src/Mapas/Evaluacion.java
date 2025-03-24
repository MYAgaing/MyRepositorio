package Mapas;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Evaluacion {

	private Map<String, BigDecimal> notas;

	public Evaluacion() {
		this.notas = new HashMap<>();
	}

	public Boolean addNota(String dni, BigDecimal nota) {
		if (notas.containsKey(dni)) {
			return false;
		} else {
			notas.put(dni, nota);
			return true;
		}

	}

	public Boolean corregirNota(String dni, BigDecimal nota) {
		if (notas.containsKey(dni)) {
			notas.put(dni, nota);
			return true;
		} else {
			return false;
		}
	}

	public BigDecimal NotaAlumno(String dni) {
		return notas.getOrDefault(dni, BigDecimal.ZERO);
	}

	public BigDecimal NotaMedia() {

		BigDecimal total = BigDecimal.ZERO;
		Collection<BigDecimal> listaNotas = notas.values();
		for (BigDecimal bigDecimal : listaNotas) {
			total = total.add(bigDecimal);
		}
		if (notas.isEmpty()) {
			System.out.println("La lista esta vacia");
		} else {
			total = total.divide(new BigDecimal(notas.size())).setScale(2, RoundingMode.HALF_DOWN);
		}
		return total;
	}

	public Integer obtenerCantidadAprobados() {
		Collection<BigDecimal> listaNotas = notas.values();
		List<BigDecimal> notasAprobadas = new ArrayList<>();
		for (BigDecimal bigDecimal : listaNotas) {
			if (bigDecimal.intValue() >= 5) {
				notasAprobadas.add(bigDecimal);
			}
		}
		return notasAprobadas.size();
	}

	public List<String> obtenerSuspensos() {
		Set<Entry<String, BigDecimal>> alumnos = notas.entrySet();
		List<String> dnis = new ArrayList<>();
		for (Entry<String, BigDecimal> alumno : alumnos) {
			if (alumno.getValue().intValue() < 5) {
				dnis.add(alumno.getKey());
			}
		}
		return dnis;
	}

	public void borrarAprobados() {
		Set<Entry<String, BigDecimal>> alumnos = notas.entrySet();
		Iterator<Entry<String,BigDecimal>> iterador = alumnos.iterator();
		while (iterador.hasNext()) {
			
            String dni = (String) iterador.next();
            if(notas.get(dni).compareTo(new BigDecimal) >= 0) {
            alumnos.remove(elemento);	
            }
            
        }
	}

	@Override
	public String toString() {
		DecimalFormat ft = new DecimalFormat("#.0");
		String aprobados = "Aprobados\n";
		String suspensos = "Aprobados\n";
		
	}
}
