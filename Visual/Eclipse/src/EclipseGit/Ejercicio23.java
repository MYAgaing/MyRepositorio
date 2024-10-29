package EclipseGit;
import java.util.Random;
import java.util.Scanner;

public class Ejercicio23 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Random rm = new Random();
		System.out.println("Cuantas veces tiras el dado?");
		int tiradas = sc.nextInt();
		for (int i = 0 ; i < tiradas ; i++) {
			Integer aleatorio = rm.nextInt(6, 10);
			System.out.println( aleatorio);
		}
	}

}
