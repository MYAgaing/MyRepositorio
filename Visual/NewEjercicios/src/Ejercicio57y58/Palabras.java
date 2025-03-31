package Ejercicio57y58;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Palabras {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Map<String,List<String>> mapa = new HashMap<>();
		String palabra = "";
		String letra = "";
		do {
			System.out.println("Digame alguna palabra excepto \"FIN\"");
			palabra = sc.nextLine().toLowerCase();
			if(mapa.containsKey(palabra.substring(0,1))) {
					mapa.get(palabra.substring(0,1)).add(palabra);
				} else {
					List<String> lista = new ArrayList<>();
					lista.add(palabra);
					mapa.put(palabra.substring(0, 1), lista);
				}
			
		} while (!palabra.equalsIgnoreCase("FIN"));
		
		do {
			System.out.println("Digame alguna letra");
			letra = sc.nextLine().toLowerCase();
			if(letra.equalsIgnoreCase("FIN")){
				break;
			}
			List<String> lista = mapa.get(letra.toUpperCase());
			if (lista == null) {
				System.out.println("No hay palabras que empiezan por " + letra);
			} else {
				System.out.println("Hay " + lista.size() + "palabras que empiezan por " + letra + ":");
				for (String string : lista) {
					System.out.println("\t> " + string);
				}
			}
			
		} while (true);
		System.out.println("Gracias por jugar");
		
		
		sc.close();
	}

}
