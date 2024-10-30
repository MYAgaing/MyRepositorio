package Tema3;

import java.util.Scanner;

public class Ejercicio4 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("¿Cuantos numeros me va ha decir?");
		int veces = sc.nextInt();
		int[] repetir = new int[veces];
		int i;
		int numeros;
		int contador = -1;
		System.out.println("Ahora digamelos");
		for(i = 0 ; i < repetir.length ; i++) {
			numeros = sc.nextInt();
			repetir[i] = numeros;
		}
		
		
		for(int j = veces ; j >=0 ; j--) {
			System.out.print(repetir[j] + " ");
		}
	}

}
