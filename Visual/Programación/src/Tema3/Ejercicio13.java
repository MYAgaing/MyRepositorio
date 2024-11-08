package Tema3;

import java.util.Scanner;

public class Ejercicio13 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("digame un palindromo");
		String palindromo = sc.nextLine().trim();
		String[] palabra = palindromo.split("");
		for (int i = palabra.length -1; i >= 0 ; i--) {
			
			System.out.print(palabra[i]);
		}
		sc.close();
	}

}
