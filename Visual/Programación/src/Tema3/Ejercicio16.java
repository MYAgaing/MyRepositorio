package Tema3;

import java.util.Scanner;

public class Ejercicio16 {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("Digame una frase y veremos cuantas palabras y a tienen");
			String frase = sc.nextLine();
			String[] a = frase.split("");
			String[] palabras = frase.split(" ");
			int contador = 0;
			int contado = 0;
			int i = 0;
			for (int j = 0 ; j < a.length ; j++) {
				if (a[j].equalsIgnoreCase("a")) {
					contador++;
				}
			}
			System.out.println(contador);
			for (i = 0 ; i < palabras.length ; i++) {
				contado++;
			}
			System.out.println(contado);
			sc.close();
		}
	}

}
