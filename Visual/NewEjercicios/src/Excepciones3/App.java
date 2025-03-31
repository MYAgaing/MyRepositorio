package Excepciones3;

import java.util.InputMismatchException;
import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		SacoNumeros saco1 = new SacoNumeros();
		try {

			Integer num = 0;
			do {
				try {
					System.out.println("dame un numero");
					num = sc.nextInt();
					if (!num.equals(-1)) {
						saco1.addNumero(num);
					}
				} catch (InputMismatchException ext1) {
					System.out.println("solo se admiten numeros");
					sc.nextLine();
				}
			} while (!num.equals(-1));
			System.out.println(saco1);
			do {
				try {
					System.out.println("Que numero quiere ver?");
					num = sc.nextInt();
					if (!num.equals(-1)) {
						System.out.println(saco1.getNumero(num));
					}
				} catch (InputMismatchException exc2) {
					System.out.println("solo se admiten numeros");
					sc.nextLine();
				}
			} while (!num.equals(-1));
			saco1.getNumero(sc.nextInt());
			sc.close();
		} finally {
			sc.close();
			System.out.println("Escaner cerrado correctamente");
		}
	}
}
