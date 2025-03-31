package Ejercicio59;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Geografia {

	private Map<String, String> paises;

	public Geografia() {
		this.paises = new HashMap<>();
	}

	public Boolean añadirPais(String pais, String capital) {
		String capitalIni = capital.substring(0, 1).toUpperCase() + capital.substring(1, capital.length());
		for (Map.Entry<String, String> entry : paises.entrySet()) {
			if (entry.getKey().equalsIgnoreCase(pais)) {
				paises.put(pais.toUpperCase(), capitalIni);
				return true;
			} else {
				paises.put(pais.toUpperCase(), capitalIni);
				return false;
			}
		}
		return null;
	}

	public String obtenerCapital(String pais) {
		// return datosPais.getOrDefault(nombrePais.toUpperCase(),"")
		for (Map.Entry<String, String> entry : paises.entrySet()) {
			if (entry.getKey().equalsIgnoreCase(pais)) {
				return entry.getValue();
			} else {
				return "";
			}
		}
		return "";
	}

	public void imprimirPaises() {
		Set<Entry<String,String>> pares = paises.entrySet();
		for (Entry<String, String> entry : pares) {
			System.out.println("PAIS: " + entry.getKey() + " - CAPITAL: " + entry.getValue());
		}
	}

	public void eliminarPais(String pais) {
		paises.remove(pais.toUpperCase());
	}

	public Integer calcularLongitudMediaPaises() {
		Integer total = 0;
		if (!paises.isEmpty()) {
			for (Map.Entry<String, String> entry : paises.entrySet()) {
				total += entry.getKey().length();
			}
			return total / paises.size();
		} else {
			return 0;
		}
	}

	public void eliminarPaisConCapitalLetra(String letra) {
		Collection<String> values = paises.values();
		Iterator<String> iterador = values.iterator();
		while (iterador.hasNext()) {
			for (Map.Entry<String, String> entry : paises.entrySet()) {
				if (entry.getValue().startsWith(letra.toUpperCase())) {
					paises.remove(entry.getKey());
					break;
				}
			}
		}
	}

	public Integer numeroPaisesConCapitalLetra(String letra) {
		Integer contador = 0;
		for (Map.Entry<String, String> entry : paises.entrySet()) {
			if (entry.getValue().substring(0, 1).equalsIgnoreCase(letra)) {
				contador++;
			}
		}
		return contador;
	}

	public void imprimirNumeroPaisesLetra(String letra) {
		Integer contador = 0;
		for (Map.Entry<String, String> entry : paises.entrySet()) {

			if (entry.getValue().substring(0, 1).equalsIgnoreCase(letra)) {
				System.out.println(entry.getKey() + "+" + entry.getValue());
				contador++;
			}
		}
		if (contador == 0) {
			System.out.println("Ninguna capital del mapa empieza por " + letra);
		}
	}

	public void mismaLetra() {
		Integer contador = 0;
		for (Map.Entry<String, String> entry : paises.entrySet()) {
			if (entry.getKey().substring(0, 1).equalsIgnoreCase(entry.getValue().substring(0, 1))) {
				System.out.println(entry.getKey() + " " + entry.getValue());
				contador++;
			}
		}
		if (contador == 0) {
			System.out.println("No hay ningun pais y capital que empiezen por la misma letra");
		}
	}

}
