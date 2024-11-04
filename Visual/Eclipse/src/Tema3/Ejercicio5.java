package Tema3;

import java.util.Scanner;

public class Ejercicio5 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("¿Cuantos numeros me va ha decir?");
		int veces = sc.nextInt();
		int[] repetir = new int[veces];
		int i;
		int numeros;
		System.out.println("Ahora digamelos");
		for (i = 0; i < repetir.length; i++) {
			numeros = sc.nextInt();
			repetir[i] = numeros;
		}

		for (int j = 0; j < veces; j++) {
			System.out.print(repetir[j] + " ");
		}
		int suma = 0;
		int maximo = repetir[0];
		int minimo = repetir[0];
		for (int p = 0; p < veces; p++) {

			if (repetir[i] > maximo) {
				maximo = repetir[i];
			}
			if (repetir[i] < minimo) {
				minimo = repetir[i];
			}
			suma += repetir[i];
		}
		double media = suma / veces;
		System.out.println("La suma es : " + suma);
		System.out.println("El mayor es : " + maximo);
		System.out.println("La media es : " + media);
	}

}
