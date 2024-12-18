package Tema4;

public class Ejercicio3 {

	public static void main(String[] args) {
		Integer num1 = 1;
		String palabra = " Hola ";
		String palabra2 = getMayMin(num1,palabra);
		System.out.println(palabra2);
	}

	public static String getMayMin(Integer num1, String palabra) {
		if (num1 == 1) {
			return palabra.trim().toUpperCase();
		} else {
			return palabra.trim().toLowerCase();
		}
	}

}
