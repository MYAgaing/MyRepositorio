package NoTocar;

import java.util.Scanner;

public class NoTocar2 {

	public static void main(String[] args) {
		 Scanner sc = new Scanner(System.in);
		 System.out.println("Digame un numero en tre 10.000 y 20.000");
		 Boolean si = true;
		 Integer numero = 0;
		while(si) {
			numero = sc.nextInt();
			if (numero < 10000) {
				System.out.println("Fallo el numero es menor que 10000, repita");
			} else if (numero > 20000) {
				System.out.println("Fallo el numero es mayor 20000, repita");
			} else {
				si = false;
			}
		}
		Integer[] numeros = numero
		 sc.close();
	}

}
