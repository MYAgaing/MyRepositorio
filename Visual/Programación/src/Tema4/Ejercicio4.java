package Tema4;

public class Ejercicio4 {

	public static void main(String[] args) {
		System.out.println(getMayMin(1, "Hola1"));
		System.out.println(getMayMin(2, "Hola2"));
	}

	public static String getMayMin(Integer num, String cadena) {
		if (num == 1) {
			cadena = Ejercicio1.getMayusculas(cadena);
		} else if (num == 2) {
			cadena = Ejercicio2.getMinusculas(cadena);
		}
		return cadena;
	}
}