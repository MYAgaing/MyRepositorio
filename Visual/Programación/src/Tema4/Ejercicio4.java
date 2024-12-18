package Tema4;

import java.util.Scanner;

public class Ejercicio4 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String parametro = " Hola ";
		int num1 = sc.nextInt();
		if (num1 == 1) {
			String parametro2 = a(parametro);
			System.out.println(parametro2);
		} else {
			String parametro2 = a1(parametro);
			System.out.println(parametro2);
		}
		sc.close();
	}

	public static String a(String parametro) {
		return parametro = parametro.trim().toUpperCase();
	}

	public static String a1(String parametro) {
		return parametro = parametro.trim().toLowerCase();
	}
}
