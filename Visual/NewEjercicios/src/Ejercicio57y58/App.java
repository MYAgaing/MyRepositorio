package Ejercicio57y58;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class App {

	public static void main(String[] args) {
		Map<String,List<String>> mapa = new HashMap<>();
		Diccionario diccionario1 = new Diccionario();
		List<String> lista = new ArrayList<>();
		lista.add("Hola");
		lista.add("Adios");
		lista.add("Hacer");
		lista.add("Ayer");
		diccionario1.cargarDiccionario(lista);
	}

}
