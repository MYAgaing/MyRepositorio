package Tema4;

import java.util.Scanner;

public class Ejercicio1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String parametro = sc.nextLine() ;
		String parametroMayus = getMayusculas(parametro);
		System.out.println(parametroMayus);
		sc.close();
	}

	public static String getMayusculas(String parametro) {
		return parametro = parametro.trim().toUpperCase();
	}

}
