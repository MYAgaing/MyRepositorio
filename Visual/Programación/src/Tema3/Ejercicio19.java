package Tema3;

import java.util.Random;

public class Ejercicio19 {

	public static void main(String[] args) {
		Random rm = new Random();
		String[] palabras = new String[]{"azulejo", "tenedor", "saltamontes", "carretilla", "molinero","sofisticado","terremoto","culinario","teclado","primavera"};
		int aleatorio = rm.nextInt(0,9);
		String[] palabra = palabras[aleatorio].split("");
		
	}
}