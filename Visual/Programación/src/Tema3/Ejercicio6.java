package Tema3;

import java.util.Scanner;

public class Ejercicio6 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("digame tres palabras");
		String[] palabras = new String[3];
		for(int i = 0 ; i < palabras.length; i++) {
			String palabra = sc.nextLine().trim();
			palabras[i] = palabra;
		}
		String frase = "";
		for (int i = 0 ; i < palabras.length ; i++) {
			frase = frase + palabras[i];
		}
		System.out.println(frase);
	}

}
