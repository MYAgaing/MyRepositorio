package Ejercicio59;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Geografia geografia1 = new Geografia();
		for (int i = 0; i < 5; i++) {
			List<String> lista = new ArrayList<>();
				System.out.println("Digame un pais y su capital");
				String pais = sc.nextLine();
				String capital = sc.nextLine();
				if(lista.contains(pais)) {
					System.out.println("Ya contiene ese pais");
				} else {
					lista.add(pais);
					geografia1.añadirPais(pais,capital);	
				}
		}
		geografia1.imprimirPaises();
		/*System.out.println(geografia1.calcularLongitudMediaPaises());
		geografia1.mismaLetra();
		geografia1.eliminarPaisConCapitalLetra("B");
		System.out.println(geografia1.numeroPaisesConCapitalLetra("B"));
		*/
		sc.close();
	}

}
