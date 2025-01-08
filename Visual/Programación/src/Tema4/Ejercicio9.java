package Tema4;

public class Ejercicio9 {

	public static void main(String[] args) {
		String[] hola = new String[] {"hola", "adios"};
		imprimirArray(hola);
	}
	public static void imprimirArray(String[] hola) {
		for (int i = 0; i < hola.length; i++) {
			System.out.println(hola[i]);
		}
	}

}
