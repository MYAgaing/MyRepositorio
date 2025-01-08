package Tema4;

import java.util.Scanner;

public class Ejercicio2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String parametro = sc.nextLine() ;
		String parametroMayus = getMinusculas(parametro);
		System.out.println(parametroMayus);
		sc.close();
	}

	public static String getMinusculas(String parametro) {
		return parametro = parametro.trim().toLowerCase();
	}

}
