package Tema3;

public class Ejercicio17 {

	public static void main(String[] args) {
		Double[] array = new Double[] {5.4,3.1,9.0,4.7};
		int i = 0;
		double suma = 0.0;
		for ( double datos:array) {
			System.out.print(datos + " ");
			suma += datos;
		}
		
		System.out.println(suma);
		suma = 0;
		for(i = 0 ; i < array.length; i++) {
			suma += array[i];
		}
		System.out.println(suma);
	}

}
