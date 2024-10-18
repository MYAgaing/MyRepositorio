package EclipseGit;
import java.util.Scanner;

public class osaprespococreje {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// EJERCICIO 1
		/*
		 * System.out.println("Digame su nombre y año de nacimiento"); String nombre =
		 * sc.nextLine(); Integer año = sc.nextInt(); System.out.println("Hola " +
		 * nombre + ", en el año 2030 tendras " + (2030 - año) + " años");
		 */

		// EJERCICIO 2
		/*
		 * System.out.println("Diagame tres ciudades distintas"); String ciudad1 =
		 * sc.nextLine().trim(); String ciudad2 = sc.nextLine().trim(); String ciudad3 =
		 * sc.nextLine().trim(); if (ciudad1.length() <= ciudad2.length() &&
		 * ciudad2.length() <= ciudad3.length()) { System.out.println(ciudad1 + ciudad2
		 * + ciudad3); }
		 */
		// EJERCICIO 3

		/*
		 * do { System.out.println("*** Menú ***"); System.out.println("1. Abrir");
		 * System.out.println("2. Guardar"); System.out.println("3. Modificar");
		 * System.out.println("4. Salir"); String elige = sc.nextLine(); if
		 * (elige.contains("1")) { System.out.println("Elegiste 1");
		 * System.out.println("1. Abrir"); System.out.println("2. Guardar");
		 * System.out.println("3. Modificar"); System.out.println("4. Salir"); elige =
		 * sc.nextLine(); } if (elige.contains("2")) { System.out.println("Elegiste 2");
		 * System.out.println("1. Abrir"); System.out.println("2. Guardar");
		 * System.out.println("3. Modificar"); System.out.println("4. Salir"); elige =
		 * sc.nextLine(); } if (elige.contains("3")) { System.out.println("Elegiste 3");
		 * System.out.println("1. Abrir"); System.out.println("2. Guardar");
		 * System.out.println("3. Modificar"); System.out.println("4. Salir"); elige =
		 * sc.nextLine();
		 * 
		 * if (elige.contains("4")) { System.out.println("Bye Bye"); break; } } if
		 * (!elige.contains("1") && !elige.contains("2") && !elige.contains("3")) {
		 * System.out.println("incorrecto elija de nuevo");
		 * System.out.println("1. Abrir"); System.out.println("2. Guardar");
		 * System.out.println("3. Modificar"); System.out.println("4. Salir"); elige =
		 * sc.nextLine(); }
		 * 
		 * } while (true);
		 */
		/*
		 * do { System.out.println("*** Menú ***"); System.out.println("1. Abrir");
		 * System.out.println("2. Guardar"); System.out.println("3. Modificar");
		 * System.out.println("4. Salir"); int elige = sc.nextInt(); if (elige == 1) {
		 * System.out.println("Has elegido 1"); } else if (elige == 2) {
		 * System.out.println("has elegido 2"); } else if (elige == 3) {
		 * System.out.println("has elegido 3"); } else {
		 * System.out.println("Esa opcion de menu no es correcta"); } } while ( elige !=
		 * 4 );
		 */
		// EJERCICIO 4

		/*
		 * System.out.println("Cuantos mangos quiere?"); int mangos = sc.nextInt();
		 * System.out.println("que precio tienen?"); Double precio = sc.nextDouble(); if
		 * (mangos > 100) { Double totalSinIva = mangos * precio; Double totalConIva =
		 * totalSinIva * 0.40; Double total = totalSinIva - totalConIva;
		 * System.out.println(total); } else if (mangos >= 25 && mangos <= 100) { Double
		 * totalSinIva = mangos * precio; Double totalConIva = totalSinIva * 0.20;
		 * Double total = totalSinIva - totalConIva; System.out.println(total); } else
		 * if (mangos >= 10 && mangos >= 24) { Double totalSinIva = mangos * precio;
		 * Double totalConIva = totalSinIva * 0.10; Double total = totalSinIva -
		 * totalConIva; System.out.println(total); } else { Double totalSinIva = mangos
		 * * precio; System.out.println(totalSinIva); }
		 */
		// EJERCICIO 5
		/*
		 * for (int i = 0 ; i < 21; i++) { if (i == 20) { System.out.println(i); }else {
		 * System.out.print(i + "_"); }
		 */
		// EJERCICIO 6
		/*
		 * int suma = 0;
		 * 
		 * for (int i = 3; i <= 30; i += 3) { System.out.print(i); if (i < 30) {
		 * System.out.print(" + "); } suma += i; } System.out.println(" = " + suma);
		 */
		// EJERCICIO 7
		int suma;
		int numero;
		do {
			System.out.println("Digame un numero");
			numero = sc.nextInt();
			suma = numero;
			if (numero == 0) {
				System.out.println("NOPE");
				break;
			}
			for (int i = numero; i <= 30; i += numero) {
				System.out.print(i);
				if (i < 30) {
					System.out.print(" + ");
				}
				suma += i;
			}
			System.out.println(" = " + suma);
		} while (numero >= 1 && numero <= 10);
	}
}
