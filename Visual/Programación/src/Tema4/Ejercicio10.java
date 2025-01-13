package Tema4;

public class Ejercicio10 {

	public static void main(String[] args) {
		
		String[] hola = new String[] {"hola","adios"};
		System.out.println(obtenerPalabra(hola,1));
	}
	public static String obtenerPalabra(String[] hola, Integer num1) {
		if (num1 >=0 && num1 < hola.length) {
			return hola[num1];
		}
		return "";
	}
	
}
