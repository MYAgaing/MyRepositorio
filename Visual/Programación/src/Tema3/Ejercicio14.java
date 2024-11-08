package Tema3;

import java.util.Scanner;

public class Ejercicio14 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Digame una frase y se pasara a CamelCase");
		String frase = sc.nextLine();
		String[] palabras = frase.split(" ");
		String primera = palabras[0].toLowerCase();
		for (int i = 1 ; i < palabras.length ; i++) {
			palabras[1].charAt(1);
			System.out.print(primera + palabras[i]);
		}
		
		sc.close();
	}

}
