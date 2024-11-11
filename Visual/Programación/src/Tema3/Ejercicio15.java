package Tema3;

import java.util.Scanner;

public class Ejercicio15 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("digame un numero de al menos dos cifras");
		String cifra = sc.nextLine();

		// Esto es una mera comprobación
		while (cifra.length() < 2) {
			System.out.println("Por favor indique un numerlo de al menos dos cifras");
			cifra = sc.nextLine();
		}

		// Para saber si es capicuo
		Boolean m = true;

		// Lo convertimos a caracteres
		String[] numeros = cifra.split("");
		for (int i = 0, j = numeros.length -1 ; i < j; i++, j--) {

			// Si no son iguales no es capicuo
			if (!numeros[i].equalsIgnoreCase(numeros[j])) {
				m = false;
				break;
			} else {
				m = true;
			}
		}
		if (m == true) {
			System.out.println("es capicuo");
		} else if (m == false) {
			System.out.println("No es capicuo");
		}
		sc.close();
	}

}
