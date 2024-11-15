package Tema3;

import java.util.Random;
import java.util.Scanner;

public class Ejercicio19 {

	public static void main(String[] args) {

		// Aqui ponemos las librerias
		Random rm = new Random();
		Scanner sc = new Scanner(System.in);

		// Aqui hacemos el string con array de las palabras
		String[] palabras = new String[] { "azulejo", "tenedor", "saltamontes", "carretilla", "molinero", "sofisticado",
				"terremoto", "culinario", "teclado", "primavera" };

		// Sacamos el numero aleatorio
		int aleatorio = rm.nextInt(0, 9);

		// Sacamos el numero aleatorio
		String[] palabra = palabras[aleatorio].split("");

		// Pedimos una letra
		System.out.println("La palabra tiene tantas letras");

		String letraElegida = "";

		String[] array = new String[palabra.length];

		for (int i = 0; i < palabra.length; i++) {
			array[i] = "_";
		}
		// Numero de intentos que tendra
		for (int i = 0; i <= 9; i++) {

			for (int j = 0; j < palabra.length; j++) {
				System.out.print(array[j] + " ");
			}

			do {
				System.out.println("Ahora digame 1 letra");
				letraElegida = sc.nextLine().trim().toLowerCase();
			} while (letraElegida.length() != 1);

			for (int p = 0; p < palabra.length; p++) {
				for (int t = 0; t < palabra.length; t++) {
					if (palabra[p].toLowerCase().contains(letraElegida)) {
						array[p] = palabra[p];
					}
				}
				if (!palabra[p].toLowerCase().contains(letraElegida)) {
					System.out.println("No contiene esa letra");
				}
			}
		}
		sc.close();
	}

}