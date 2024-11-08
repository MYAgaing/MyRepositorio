package Tema3;

import java.util.Scanner;

public class Ejercicio12 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//Le pedimos al usuario
		System.out.println("Digame una pagina web y se dividire");
		String pagina = sc.nextLine();
		
		//Hacemos split
		String[] cadena = pagina.split("://");
		
		System.out.println(cadena[0] + "://");
		
		//Volvemos ha hacer split separado 
		String[] puntos = cadena[1].split("\\.");
		
		for(int i = 0 ; i < puntos.length ; i++) {
			
		System.out.println(puntos[i]);
		
		}
		
		sc.close();
	}

}
