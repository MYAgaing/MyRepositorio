package EclipseGit;
import java.util.Random;
import java.util.Scanner;

public class Ejercicio15 {

	public static void main(String[] args) {
		int constante = 0;
		int aleatorio;
		int adivina;
		int puntuacion = 10;
		do {
		Random Rm = new Random();
		Scanner sc = new Scanner(System.in);
		 aleatorio = Rm.nextInt(0 , 9);
		System.out.println("Adivina un numero de 0 al 9");
		adivina = sc.nextInt();
		constante++;
		if (aleatorio == adivina) {
			System.out.println("Acertaste , tu puntuacion es " + (constante - puntuacion));
		} else {
			System.out.println("Casi");
		}
		} while (aleatorio != adivina);
	}
}