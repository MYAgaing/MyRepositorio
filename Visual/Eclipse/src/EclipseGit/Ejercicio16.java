package EclipseGit;

import java.util.Scanner;

public class Ejercicio16 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		/*
		 * String palabra = sc.nextLine(); int contador; for (contador = 0 ; contador <
		 * palabra.length() ; contador++) {
		 * System.out.println(palabra.charAt(contador)); }
		 */
		// Ejercicio 17
		/*
		 * int numero = sc.nextInt(); int num1 = 0; int num2 = 1; int nuevoValor; do {
		 * System.out.println("Dame un numero mayor a 2"); } while (numero >= 2);
		 * for(int serie = 2 ; serie < num1 ; serie ++) {
		 * 
		 * 
		 * 
		 * }
		 */
		//Ejercicio 18
		System.out.println("Dime una palabra");
		String palabra = sc.nextLine();
		String palabra1 = "";
		for (int i = palabra.length() -1 ; i >= 0 ; i--) {
			palabra1 += palabra.charAt(i);
		}
		System.out.println(palabra1);
		sc.close();
	}

}
