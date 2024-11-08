package Tema3;

import java.util.Scanner;

public class Ejercicio11 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Digame su nombre completo por favor : ");
		String nombreCompleto = sc.nextLine();
		String[] nombreSeparado = nombreCompleto.split(" ");
		for (int i = 0 ; i < nombreSeparado.length ; i++) {
			System.out.println(nombreSeparado[i]);
		}
		for(String palabra:nombreSeparado) {
			System.out.println(palabra);
		}
		sc.close();
	}

}
