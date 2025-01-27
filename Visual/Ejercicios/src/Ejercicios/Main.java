package Ejercicios;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<String> lista = new ArrayList<>();
		for (int i = 0; i < 5; i++) {

			System.out.println("Diga una palabra");
			String palabra = sc.nextLine();
			lista.add(palabra);
		}
		Iterator<String> iterator = lista.iterator();
		while (iterator.hasNext()) {
			String cadena = iterator.next();
			System.out.println(cadena);
		}
		for (int i = 0; i < lista.size(); i++) {
			lista.set(i, lista.get(i)).toUpperCase();
		}
		System.out.println(lista);
		if (lista.contains("")) {
			System.out.println("Hay una cadena vacia");
		}
		Iterator<String> iterator2 = lista.iterator();
		while (iterator2.hasNext()) {
			if (iterator2.next().length() < 6) {
				iterator2.remove();
			}
		}
		System.out.println(lista);
		sc.close();

	}
	
}