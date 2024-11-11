package Tema3;

import java.util.Scanner;

public class Ejercicio14 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Digame una frase y se pasara a CamelCase");
		String frase = sc.nextLine();
		String[] palabras = frase.toLowerCase().split(" ");
		String primera = palabras[0].toLowerCase();
		String resultado = "";
		for (int i = 1 ; i < palabras.length ; i++) {
			 resultado += palabras[i].substring(0, 1).toUpperCase() + palabras[i].substring(1);
		}	
		System.out.print(primera + resultado);
		sc.close();
	}

}
