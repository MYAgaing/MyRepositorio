package EclipseGit;

import java.util.Scanner;

public class Ejercicios_respaso_avanzado {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		/*
		 * System.out.println("Ingresa un texto:"); String texto = scanner.nextLine();
		 * 
		 * String camelCaseTexto = convertirACamelCase(texto);
		 * System.out.println("Texto en camelCase: " + camelCaseTexto);
		 * 
		 * scanner.close(); }
		 * 
		 * public static String convertirACamelCase(String texto) { String[] palabras =
		 * texto.toLowerCase().split(" "); StringBuilder camelCase = new
		 * StringBuilder(palabras[0]);
		 * 
		 * for (int i = 1; i < palabras.length; i++) { String palabra = palabras[i];
		 * camelCase.append(palabra.substring(0, 1).toUpperCase())
		 * .append(palabra.substring(1)); }
		 * 
		 * return camelCase.toString();
		 */

		/*
		 * System.out.println("Como de grande lo quiere?"); int n = sc.nextInt(); for
		 * (int i = 0 ; i < n ; i++) { for (int j = 0 ; j < n ; j++) { if (i == j || i +
		 * j == n - 1) { System.out.print("* "); } else { System.out.print("- "); } }
		 * System.out.println(); }
		 */
		for(int i = 0 ; i < 5 ; i++) {
			if (i == 0) {
				for (int j = 1 ; j < 10 ; j++) {
					if (j == 9 ) {
						System.out.println(j + " ");
					} else {
						System.out.print(j);
					}
				}
			} else if (i == 1) {
				for (int j = 2 ; j < 10 ; j+= 2) {
					if (j == 10 ) {
						System.out.println(j + " ");
					} else {
						System.out.print(j);
					}
				
				}
			}
		}
	}
}
