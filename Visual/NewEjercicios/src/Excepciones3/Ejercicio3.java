package Excepciones3;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Ejercicio3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try {
			List<Integer> lista = new ArrayList<>();
			Integer num = 0;
			do {
				try {
					System.out.println("dame un numero");
					num = sc.nextInt();
					if (!num.equals(-1)) {
						lista.add(num);
					}
				} catch (InputMismatchException ext1) {
					System.out.println("Solo numeros boludo");
					sc.nextLine();
				}

			} while (!num.equals(-1));
			System.out.println("Lista " + lista);
		} finally {
			sc.close();
			System.out.println("Scanner cerrado correctamente");
		}
		sc.close();
	}
	
}
