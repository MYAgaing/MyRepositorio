package Excepciones7;

import java.math.BigDecimal;
import java.util.Scanner;

public class App {
	static Scanner sc = new Scanner(System.in);
	static Sociedad soci1 = new Sociedad();
	public static void main(String[] args) {
		
		try {
			
			while (true) {
				try {
					System.out.println("Digame el genero");
					String genero = sc.nextLine();
					System.out.println("Digame la altura");
					BigDecimal altura = sc.nextBigDecimal();
					soci1.addPersona(genero, altura);
					System.out.println("Desea crear mas?");
					String crear = sc.nextLine();
					if (crear.equalsIgnoreCase("si")) {
						break;
					}
				} catch (ListaVaciaException e) {
					System.out.println(e.getMessage());
				}
				try {
					System.out.println(soci1.calcularAlturaMedia());
				} catch(ListaVaciaException e) {
					System.out.println(e.getMessage());
				}
				try {
					System.out.println(soci1.calcularAlturaMediaHombreMujer("H"));
				} catch(ListaVaciaException e) {
					System.out.println(e.getMessage());
				}
			}
		} finally {
			sc.close();
		}

	}
	public void obtenerPersona() {
		System.out.println("Digame el genero");
		String genero = sc.nextLine();
		System.out.println("Digame la altura");
		BigDecimal altura = sc.nextBigDecimal();
		soci1.addPersona(genero, altura);
	}

}
