package EclipseGit;
import java.util.Scanner;

public class Bucleameesta {

	public static void main(String[] args) {
		// EJERCICIO 0
		/*
		 * Integer a = 1;
		 * 
		 * while (a != 7) { System.out.println("no"); a++; } if (a == 7) {
		 * System.out.println("Si"); }
		 */
		// EJERCICIO 1
		/*
		 * for (int a1 = 0; a1 <= 11; a1++) { System.out.println(a1); }
		 */
		Scanner sc = new Scanner(System.in);
		// EJERCICIO 2
		/*
		 * for (int num = sc.nextInt(); num != 0 ;) {
		 * 
		 * }
		 */
		// EJERCICIO 3
		/*
		 * int total = 0; int num;
		 * 
		 * do { System.out.println("Digame un numero:"); num = sc.nextInt(); total = num
		 * + total; } while (num != 0);
		 */
		// EJERCICIO 4

		/*int contador = 0;
		int suma = 0;
		while (contador <= 30) {
			suma = suma + contador;
			contador = contador + 3;
		}

		System.out.println(suma);*/
//		 
		// EJERCICIO 5
		/*
		 * for (int a1 = 1; a1 <= 5; a1++) {
		 * System.out.println("Mi nombre es nicolas. Linea " + a1 ); }
		 */
		// EJERCICIO 6
		/*
		 * int num1; int num2; do { System.out.println("dime un numero"); num1 =
		 * sc.nextInt(); System.out.println("dime otro numero "); num2 = sc.nextInt(); }
		 * while (num1 != num2); System.out.println("Gracias un saludo");
		 */
		// EJERCICIO 7
		/*
		 * Integer num1; Integer num2; Boolean iguales; do {
		 * System.out.println("dime un numero"); num1 = sc.nextInt();
		 * System.out.println("dime otro numero "); num2 = sc.nextInt(); } while(
		 * iguales = !num1.equals(num2)); System.out.println("Gracias un saludo");
		 */
		// EJERCICIO 8
		/*
		 * System.out.println("Digame su nombre completo:"); String nombreCompleto =
		 * sc.nextLine(); String primeraPalabra = nombreCompleto.split(" ")[0]; String
		 * segundaPalabra = nombreCompleto.split(" ")[1]; String terceraPalabra =
		 * nombreCompleto.split(" ")[2];
		 * 
		 * System.out.println(primeraPalabra); System.out.println(segundaPalabra);
		 * System.out.println(terceraPalabra);
		 */
		// EJERCICIO 9
		/*
		 * String num1; String num2; do { System.out.println("diga una palabra"); num1 =
		 * sc.nextLine(); System.out.println("diga otra palabra"); num2 = sc.nextLine();
		 * } while (num1.isBlank() || num2.isBlank());
		 * 
		 * if (num1.compareToIgnoreCase(num2) < 0) {
		 * System.out.println("Orden Alfabetico"); System.out.println(num1);
		 * System.out.println(num2); } else { System.out.println("orden Alfabetico");
		 * System.out.println(num2); System.out.println(num1); }
		 */
		// EJERCICIO 10
		/*
		 * Boolean error = false; do { System.out.println("dame un correo"); String
		 * email = sc.nextLine();
		 * 
		 * if (!email.contains("@")) { error = true; } if (email.contains("@.")) { error
		 * = true; } if (email.endsWith(".")) { error = true; } } while(error == true);
		 * 
		 * System.out.println("Perfecto gracias");
		 */
		// EJERCICIO 11
		/*
		 * String userName; String user; while (true) {
		 * System.out.println("Escriba su nombre para registrarse"); userName =
		 * sc.nextLine(); user = userName.trim(); if (user.length() < 10) {
		 * System.out.println("Al menos 10 caracteres");
		 * 
		 * } if (user.contains(" ")) { System.out.println("No debe tener espacios");
		 * 
		 * } System.out.println("Su usuario es " + user);
		 * 
		 * }
		 */
		// EJERCICIO 12

		/*
		 * System.out.println("Dime un texto"); String texto = sc.nextLine(); for (int i
		 * = 0; i < texto.length(); i += 5) if (i + 5 <= texto.length()) {
		 * System.out.println(texto.substring(i, i + 5)); } else {
		 * System.out.println(texto.substring(i)); }
		 */

		// EJERCICIO 13
		/*
		 * System.out.println("Indique que numero quiere multiplicar: "); int numero =
		 * sc.nextInt(); int numero0 = numero * 0; int numero1 = numero * 1; int numero2
		 * = numero * 2; int numero3 = numero * 3; int numero4 = numero * 4; int numero5
		 * = numero * 5; int numero6 = numero * 6; int numero7 = numero * 7; int numero8
		 * = numero * 8; int numero9 = numero * 9; int numero10 = numero * 10;
		 * System.out.println(numero + " x 0 = " + numero0); System.out.println(numero +
		 * " x 1 = " + numero1); System.out.println(numero + " x 2 = " + numero2);
		 * System.out.println(numero + " x 3 = " + numero3); System.out.println(numero +
		 * " x 4 = " + numero4); System.out.println(numero + " x 5 = " + numero5);
		 * System.out.println(numero + " x 6 = " + numero6); System.out.println(numero +
		 * " x 7 = " + numero7); System.out.println(numero + " x 8 = " + numero8);
		 * System.out.println(numero + " x 9 = " + numero9); System.out.println(numero +
		 * " x 10 = " + numero10);
		 */
		// EJERCICIO 14

		/*
		 * System.out.println("Indique que numero quiere multiplicar: "); int numero =
		 * sc.nextInt(); for (int i = 0; i < 11; i++) { System.out.println(numero +
		 * " x " + i + " = " + (numero * i)); }
		 */

		// EJERCICO 16

		/*
		 * int contador = 1; int suma = 0; while (contador != 10001) { suma = suma +
		 * contador; contador = contador + 1; }
		 * 
		 * System.out.println(suma);
		 */
		// EJERCICIO 17
		/*
		 * for (int a1 = 1; a1 <= 5; a1++) {
		 * System.out.println("Mi nombre es nicolas. Linea " + a1 ); }
		 */
		// EJERCICIO 18

		/*
		 * for (int i = 1 ; i < 6; i++) { for (int j = 1; j < 6 ; j++) {
		 * System.out.print(j); } System.out.println(); }
		 */
		// EJERCICIO 19

		/*
		 * for (int i = 2; i < 11; i++) { for (int j = 1; j < i; j++) {
		 * System.out.print(j + " "); } System.out.println(); }
		 */

		sc.close();

	}

}
