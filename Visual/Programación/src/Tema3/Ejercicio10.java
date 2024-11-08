package Tema3;

import java.util.Scanner;

public class Ejercicio10 {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		Integer numeroSerie = 0;
		Integer anterior = 0;
		Integer ultimo = 1;
		Integer nuevoValor;

		do {
			System.out.println("Dame un numero mayor a 2");
			numeroSerie = scanner.nextInt();
		} while (numeroSerie <= 2);

		System.out.print("La serie de fibonacci del numero " + numeroSerie + " es: ");
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
