package Tema3;

import java.util.Scanner;

public class Ejercicio17 {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		Integer numeroSerie = 0;
		Integer anterior = 0;
		Integer ultimo = 1;
		Integer nuevoValor;

		// Solicitar un n�mero mayor que 2
		do {
			System.out.println("Dame un n�mero mayor a 2");
			numeroSerie = scanner.nextInt();
		} while (numeroSerie <= 2);

		System.out.print("La serie de fibonacci del n�mero " + numeroSerie + " es: ");

		// Los dos primeros n�meros
		System.out.print(anterior + ", " + ultimo);

		for (int serie = 2; serie < numeroSerie; serie++) {
			nuevoValor = anterior + ultimo;
			anterior = ultimo;
			ultimo = nuevoValor;
			System.out.print(", " + nuevoValor);

		}

		scanner.close();
	}

}
