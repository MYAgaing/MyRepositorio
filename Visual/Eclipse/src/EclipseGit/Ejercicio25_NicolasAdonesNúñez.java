package EclipseGit;

import java.util.Random;
import java.util.Scanner;

public class Ejercicio25_NicolasAdonesNúñez {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Random Rm = new Random();
		System.out.println("Piedra, papel, tijera… un, dos, tres… ya!!");
		String elige = sc.nextLine().toLowerCase();
		String[] opciones = {"piedra" ,"papel" , "tijera"};
		String eleccionPrograma = opciones[new Random().nextInt(opciones.length)];
		System.out.println("El programa elige" + eleccionPrograma);
		if (elige.equals(eleccionPrograma)) {
			System.out.println("Empate");
		} else if (elige.equals("piedra") && eleccionPrograma.equals("tijera") ||
				elige.equals("papel") && eleccionPrograma.equals("piedra")||
				elige.equals("tijera") && eleccionPrograma.equals("papel")) {
			System.out.println("Has ganado");
		} else {
			System.out.println("Has perdido");
		}
		
	}

}
