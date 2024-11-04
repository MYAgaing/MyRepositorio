package Tema3;

import java.util.Scanner;

public class Ejercicio3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("¿Cuantos numeros me va ha decir?");
		int veces = sc.nextInt();
		int[] repetir = new int[veces];
		int i;
		int numeros;
		System.out.println("Ahora digamelos");
		for(i = 0 ; i < repetir.length ; i++) {
			numeros = sc.nextInt();
			repetir[i] = numeros;
		}
		
		
		for(int j = 0 ; j < veces ; j++) {
			System.out.print(repetir[j] + " ");
		}
	}

}
