package EclipseGit;
import java.util.Scanner;

public class samet2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		/*
		 * System.out.println("¿En que año naciste?"); Integer numero = sc.nextInt(); ;
		 * String mensaje ; if (numero >= 1883 && numero <= 1900) {
		 * System.out.println("Generacion perdida"); } else if(numero >= 1901 && numero
		 * <= 1927) { System.out.println("Generacion grandiosa"); } else if(numero >=
		 * 1928 && numero <= 1945) { System.out.println("Generacion silenciosa"); } else
		 * if(numero >= 1946 && numero <= 1964) { System.out.println("Baby Boomers"); }
		 * else if(numero >= 1965 && numero <= 1980) {
		 * System.out.println("Generacion X"); } else if(numero >= 1981 && numero <=
		 * 1996) { System.out.println("Milenials"); } else if(numero >= 1997 && numero
		 * <= 2012) { System.out.println("Generacion Z"); } else if(numero >= 2013) {
		 * System.out.println("Generacion Alfa"); }
		 */
		// ------------------------------------------------------
		/*
		 * System.out.println("Altura"); Double altura = sc.nextDouble();
		 * System.out.println("peso"); Double peso = sc.nextDouble(); Double imc = (peso
		 * / (altura * altura)); System.out.println(imc); if (imc < 18.5) {
		 * System.out.println("Inferior normal"); } else if (imc >= 18.5 && imc <= 24.9
		 * ) { System.out.println("Normnal"); } else if (imc >= 25 && imc <= 29.9 ) {
		 * System.out.println("Gordo"); } else if (imc > 30 ) {
		 * System.out.println("Obeso"); }
		 */
		// --------------------------------------------------------------

		System.out.println("Digame el precio sin IVA");
		Double precio = sc.nextDouble();
		sc.nextLine();
		System.out.println("Tipo de IVA");
		String iva = sc.nextLine();
		if (iva.equals("normal")) {
			System.out.println(precio * 1.21);
		} else if (iva.equals("reducido")) {
			System.out.println(precio * 1.1);
		} else if (iva.equals("superreducido")) {
			System.out.println(precio * 1.04);
		} else if (iva.equals("exento")) {
			System.out.println(precio * 1);
		}

		sc.close();
	}

}
