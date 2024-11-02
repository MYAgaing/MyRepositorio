package EclipseGit;

import java.util.Scanner;

public class Spucnik {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int dimension = sc.nextInt();
		for (int x = 0; x < dimension; x++) {
			if (x == 0) {
				System.out.print(" __");
			} else {
				System.out.print("___");
			}
		}
		System.out.println();
		for (int fila = 0; fila < dimension; fila++) {
			for (int columna = 0; columna < dimension; columna++) {
				System.out.print("|__");
			}
			System.out.println("|");
		}

		sc.close();
	}

}
