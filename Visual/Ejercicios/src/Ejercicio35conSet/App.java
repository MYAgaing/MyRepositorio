package Ejercicio35conSet;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class App {

	public static void main(String[] args) {
		Set<String> cadenas = new HashSet<>();
		Set<String> cadenas2 = new HashSet<>();
		Scanner sc = new Scanner(System.in);
		Boolean es_true = true;
		String cadena;
		do {
			for (int i = 0; i < 5; i++) {
				if (i == 0) {
					System.out.println("Indique una cadena sin repeidos");	
					cadena = sc.nextLine();
					cadenas.add(cadena);
					
				} else {
					System.out.println("Indique otra cadena sin repetidos");
					cadena = sc.nextLine();
					cadenas.add(cadena);
				}
				es_true = false;
			}
		} while (es_true);
		 System.out.println(cadenas.toString());
		for (String string : cadenas) {
			String cadenaaux = string.toUpperCase();
			cadenas2.add(cadenaaux);
		}
		cadenas = cadenas2;
		System.out.println(cadenas);
		Boolean cadenaVacia = false;
		for (String string : cadenas2) {
			cadenaVacia = false;
			if (string.contains("")) {
				cadenaVacia = true;
			}
		}
		if (cadenaVacia) {
		System.out.println("No hay una cadena vacia");	
		} else {
			System.out.println("Hay ninguna cadena vacia");
		}
		for (String string : cadenas2) {
			if (string.length() < 6) {
				cadenas.add(string);
			}
			cadenas2 = cadenas;
		}
		System.out.println(cadenas);
	}

}
