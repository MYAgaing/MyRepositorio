package Tema3;

import java.util.Scanner;

public class Ejercicio2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Digame un numero para saber el cuadrado :");
		int[] cuadrados = new int[6];
		int numero = sc.nextInt();
		int total;
		for (int i = 0 ; i < cuadrados.length ; i++) {
			total = numero * numero;
			numero++;
			System.out.println(total);
		}
	}

}
