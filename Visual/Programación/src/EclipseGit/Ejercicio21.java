package EclipseGit;
import java.util.Scanner;

public class Ejercicio21 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("como de grande lo quiere:");
		int veces = sc.nextInt();
		
		for (int fila = 0; fila < veces ; fila++) {
			for (int columna = 0 ; columna < veces ; columna++) {
				if (fila == columna) {
					System.out.print("* ");
				} else {
					System.out.print("- ");
				}
			}
			System.out.println();
		}
	}

}
