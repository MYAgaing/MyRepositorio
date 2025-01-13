package NoTocar;

import java.util.Scanner;

public class NoTocar {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		while (true) {
			System.out.println(
					"Indica una lista de números (entre 100 y 199) y palabras que empiecen por 'a' minúscula:");
			String input = scanner.nextLine();

			// Separar los elementos ingresados
			String[] elementos = input.split(" ");

			int sumaNumeros = 0;
			String palabrasValidas = "";

			boolean error = false;
			boolean hayNumero = false;
			boolean hayPalabra = false;

			// Validar cada elemento
			for (String elemento : elementos) {
				if (esNumero(elemento)) {
					int numero = Integer.parseInt(elemento);
					if (numero >= 100 && numero <= 199) {
						sumaNumeros += numero;
						hayNumero = true;
					} else {
						System.out.println("El ítem de la lista '" + elemento + "' no es correcto.");
						error = true;
					}
				} else if (elemento.matches("a[a-z]*")) {
					if (!palabrasValidas.isEmpty()) {
						palabrasValidas += " ";
					}
					palabrasValidas += elemento;
					hayPalabra = true;
				} else {
					System.out.println("El ítem de la lista '" + elemento + "' no es correcto.");
					error = true;
				}
			}

			// Comprobar si hay al menos un número y una palabra válida
			if (!hayNumero) {
				System.out.println("No se ha indicado ningún número");
				error = true;
			}
			if (!hayPalabra) {
				System.out.println("No se ha indicado ninguna palabra");
				error = true;
			}

			// Si hay error, volver a pedir la lista
			if (error) {
				continue;
			}

			// Mostrar los resultados
			System.out.println("Suma de números: " + sumaNumeros);
			System.out.println("Suma de palabras: " + palabrasValidas);
			break;
		}

		scanner.close();
	}

	// Método para comprobar si un string es un número
	private static boolean esNumero(String str) {
		// Verificar si el string contiene solo dígitos
		return str.matches("\\d+");
	}
}