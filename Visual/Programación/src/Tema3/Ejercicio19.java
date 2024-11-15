package Tema3;

import java.util.Random;
import java.util.Scanner;

public class Ejercicio19 {

	public static void main(String[] args) {
		Random rm = new Random();
		Scanner sc = new Scanner(System.in);

		String[] palabras = new String[] { "azulejo", "tenedor", "saltamontes", "carretilla", "molinero", "sofisticado",
				"terremoto", "culinario", "teclado", "primavera" };

		Integer aleatorio = rm.nextInt(0, 9);

		String[] palabra = palabras[aleatorio].split("");

		String[] array = new String[palabra.length];
		System.out.println("Su palabra se compone de tantos huecos");
		for (int i = 0; i < palabra.length; i++) {
			array[i] = "_ ";
		}
		String letra = "a";
		int contador = 0;
		int i = 0;
		for (i = 0; i < 10; i++) {

			for (i = 0; i < palabra.length; i++) {
				System.out.print(array[i] + " ");
			}

			System.out.println("Digame 1 letra");
			letra = sc.nextLine().trim();

			for (i = 0; i < palabra.length; i++) {

				if (palabra[i].equalsIgnoreCase(letra)) {

					array[i] = letra;
				}
				if (i == palabra.length) {
					System.out.println("No contiene esa letra");
				}
			}
			
			contador++;
			if(contador == 9) {
				System.out.println("Game over");
				break;
			}

		}
		sc.close();
	}

}
