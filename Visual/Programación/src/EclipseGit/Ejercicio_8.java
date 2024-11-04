package EclipseGit;
import java.util.Scanner;

public class Ejercicio_8 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		/*
		 * while (true) { System.out.print("Escribe tu mensaje: "); String texto =
		 * sc.nextLine().trim(); if (texto.startsWith("hola") &&
		 * texto.endsWith("hasta luego")) { String mensaje = texto.substring(4,
		 * texto.length() - 11).trim(); System.out.println("Lo he entendido. Mensaje: "
		 * + mensaje); break; } else {
		 * System.out.println("No lo he entendido. Por favor, repítelo."); }
		 */

		/*
		 * Boolean Si = true; while (Si) { System.out.print("Escribe tu mensaje: ");
		 * String texto = sc.nextLine().trim(); if (texto.startsWith("hola") &&
		 * texto.endsWith("hasta luego")) { String mensaje = texto.substring(4,
		 * texto.length() - 11).trim(); System.out.println("Lo he entendido. Mensaje: "
		 * + mensaje); Si = true; } else if (texto.endsWith("adiós") &&
		 * texto.endsWith("adios")) { System.out.println("goodbye"); break; } else if
		 * (!texto.endsWith("adiós") && texto.startsWith("hola") &&
		 * texto.endsWith("hasta luego")) {
		 * System.out.println("No lo he entendido. Por favor, repítelo."); Si = true; }
		 * 
		 * }
		 */

		/*
		 * System.out.println("Escriba un url"); String url = sc.nextLine(); String
		 * protocolo = url.trim().substring(0, url.indexOf("://"));
		 * System.out.println(protocolo + "://"); String parte1 =
		 * url.trim().substring(url.indexOf("://") + 3, url.indexOf("."));
		 * System.out.println(parte1); String parte2 =
		 * url.trim().substring(url.indexOf(".") + 1, url.lastIndexOf("."));
		 * System.out.println(parte2); String parte3 =
		 * url.trim().substring(url.lastIndexOf(".") + 1, url.length() - 1);
		 * System.out.println(parte3);
		 */

		Integer i;
		Integer j;
		Integer k;
		while (true) {
			System.out.println("digame un numero");
			i = sc.nextInt();
			System.out.println("ahora otro");
			j = sc.nextInt();
			System.out.println("Elija el numero de lo que quiere hacer");
			System.out.println("1. Sumar");
			System.out.println("2. Restar");
			System.out.println("3. Multiplicar");
			System.out.println("4. Dividir");
			System.out.println("0. Salir");
			k = sc.nextInt();
			if (k == 1) {
				System.out.println(i + j);
			} else if (k == 2) {
				System.out.println(i - j);
			} else if (k == 3) {
				System.out.println(i * j);
			} else if (k == 4) {
				System.out.println(i / j);
			} else if (k == 0) {
				break;
			}

		}
		sc.close();
	}
}
