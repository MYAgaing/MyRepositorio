package Tema3;

public class Ejercicio1 {
	
	public static void main(String[] args) {
		int[] numerosPares = new int[15];
		int contador = 2;
		for (int i = 0 ; i < numerosPares.length ; i++) {
			numerosPares[i] = contador;
			contador = contador + 2;
		}
		
	}
}
