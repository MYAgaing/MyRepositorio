package Tema3;

import java.util.Scanner;

public class Ejercicio8 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("¿Cuantos numeros me va ha decir?");
		int veces = sc.nextInt();
		int[] repetir = new int[veces];
		int i;
		int j;
		int numeros;
		System.out.println("Ahora digamelos");
		for (i = 0; i < repetir.length; i++) {
			numeros = sc.nextInt();
			repetir[i] = numeros;
		}

		for ( j = 0; j < repetir.length; j++) {
			if ( j == repetir.length - 1) {
			System.out.println(repetir[j]);
			} else {
				System.out.print(repetir[j] + " ");
			}
		}
		for ( i = 0 , j=repetir.length-1 ; i < j ; i++ , j--) {
			int num = repetir[i];
			repetir[i] = repetir[j];
			repetir[j] = num;
		}
		for (i = 0; i < repetir.length; i++) {
			System.out.print(repetir[i] + " ");
		}
	}

}
