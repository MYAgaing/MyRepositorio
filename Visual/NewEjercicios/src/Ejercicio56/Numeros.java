package Ejercicio56;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Numeros {
	
	
	
	public static void main(String[] args) {
		Map<Integer,Integer> mapa = new HashMap<>();
		Scanner sc = new Scanner(System.in);
		Integer numero;
		Integer contadorTotal = 0;
		
		do {
			System.out.println("Diga un numero menos el 0");
			numero = sc.nextInt();
			if(!numero.equals(0)) {
				if(mapa.containsKey(numero)) {
					Integer cantidadActual = mapa.get(numero);
					mapa.put(numero, cantidadActual + 1);
				} else {
					mapa.put(numero, 1);
				}
				contadorTotal++;
			}
		} while (!numero.equals(0));
		System.out.println("En total son " + contadorTotal );
		sc.close();
	}

}
