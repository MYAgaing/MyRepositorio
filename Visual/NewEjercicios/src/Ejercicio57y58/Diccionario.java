package Ejercicio57y58;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Diccionario {

	private Map<String,List<String>> mapa;
	
	public Diccionario() {
		mapa = new HashMap<>();
	}
	
	public void cargarDiccionario(List<String> list) {
		String palabra = "";
		if(mapa.containsKey(palabra.substring(0,1))) {
			mapa.get(palabra.substring(0,1)).add(palabra);
		} else {
			List<String> lista2 = new ArrayList<>();
			lista2.add(palabra);
			mapa.put(palabra.substring(0, 1), lista2);
		}
	}
	public void borrarDiccionario() {
		mapa.clear();
	}
	
	public void imprimirPalabras(String letra) {
		if (letra != null) {
			List<String> lista = mapa.get(letra.toUpperCase());
			if (lista == null) {
				System.out.println("No hay palabras que empiezan por " + letra);
			} else {
				System.out.println("Hay " + lista.size() + "palabras que empiezan por " + letra + ":");
				for (String string : lista) {
					System.out.println("\t> " + string);
				}
			}
		}
		
	}
	
}
