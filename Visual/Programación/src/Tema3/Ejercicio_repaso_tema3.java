package Tema3;

import java.util.Scanner;

public class Ejercicio_repaso_tema3 {
	public static final Double PRECIO_FINAL = 0.24;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Integer[] listaNotas = new Integer[] { 7, 9, 8, 4, 0, 6, 3, 4, 1, 7, 3, 1, 9, 10 };

		// Ejercicio1
		/*
		 * int contador = 0; for (Integer integer : listaNotas) { if(integer < 5) {
		 * contador++; } } System.out.println("Han suspendido: " + contador);
		 */

		// Ejercicio 2
		/*
		 * Integer suma = 0; Integer total = 0; for (int i = 0 ; i < listaNotas.length ;
		 * i++) { if(listaNotas[i] >= 5) { suma = suma + listaNotas[i]; total++; } }
		 * 
		 * int resultado = suma / total ;
		 * 
		 * System.out.println("Nota media: " + resultado);
		 */

		// Ejercicio 3
		/*
		 * System.out.println("¿Que nota estas buscando?");
		 * 
		 * Integer nota = sc.nextInt();
		 * 
		 * for (int i = 0 ; i < listaNotas.length ; i++) { if (nota == listaNotas[i]) {
		 * System.out.println("La nota buscada existe y esta en la posición " + (i +
		 * 1)); break; } else if (i == listaNotas.length - 1) {
		 * System.out.println("La nota buscada no existe"); } }
		 */

		// Ejercicio 4
		/*
		 * System.out.println("¿Que nota esta buscando?"); Integer nota = sc.nextInt();
		 * Integer contador = 0; for (int i = 0 ; i < listaNotas.length ; i++) { if
		 * (listaNotas[i] > nota) { contador++; } } System.out.println("Hay " + contador
		 * + " notas mayores a la indicada");
		 */

		// Ejercicio 5
		/*
		 * for (int i = 0 ; i < listaNotas.length ; i++) { if (listaNotas[i] < 5) {
		 * listaNotas[i] = 5; } } for (Integer integer : listaNotas) {
		 * System.out.print(integer + " "); }
		 */

		// Ejecicio 6
		/*
		 * for (int i = 0 ; i < listaNotas.length ; i++) { if (i % 2 == 0) {
		 * listaNotas[i] = listaNotas[i] * 2; } } for (Integer integer : listaNotas) {
		 * System.out.print(integer + " "); }
		 */

		// Ejecicio 7
		// SIN NOVEDADES EN EL FRENTE. VUELVO MAÑANA TARDE NOCHE. TENED PREPARADO EL
		// PUCHERO.
		/*
		 * System.out.println("Escribe tu telegrama y te dire el precio");
		 * 
		 * String telegrama = sc.nextLine();
		 * 
		 * String[] telegramaSplit = telegrama.replaceAll("\\.",
		 * " STOP").trim().split("\\.");
		 * 
		 * String[] precioTelegrama = telegrama.split(" ");
		 * 
		 * for (int i = 0; i < telegramaSplit.length; i++) {
		 * 
		 * if(i == telegramaSplit.length) {
		 * 
		 * System.out.print(telegramaSplit[i] + " ");
		 * 
		 * } else { System.out.println(telegramaSplit[i] + " "); }
		 * 
		 * 
		 * } double precio = PRECIO_FINAL * precioTelegrama.length;
		 * 
		 * System.out.println("El precio seria " + precio);
		 */

		// Ejercicio8
		// <html><head/><body><h1>Mi página web</h1><h2>Ej 8 de
		// Programación</h2><br/><br/><p>Funciona?</p><p>Sí!!</p></body></html>
		/*
		 * System.out.println("Escriba su HTML"); String html = sc.nextLine();
		 * 
		 * String resultado = html.replaceAll("<[^>]+>", "");
		 * System.out.println(resultado);
		 */

		// Ejercicio 9
		// <html><head/><body><h1>Mi página web</h1><h2>Ej 8 de
		// Programación</h2><br/><br/><p>Funciona?</p><p>Sí!!</p></body></html>

		/*
		 * System.out.println("Escribe tu HTML:"); String html = sc.nextLine();
		 * 
		 * String textoExtraido = "";
		 * 
		 * 
		 * boolean dentroDeEtiqueta = false; boolean textoAnterior = false;
		 * 
		 * for (int i = 0; i < html.length(); i++) { char c = html.charAt(i);
		 * 
		 * if (c == '<') {
		 * 
		 * dentroDeEtiqueta = true; } else if (c == '>') {
		 * 
		 * dentroDeEtiqueta = false; if (textoAnterior) {
		 * 
		 * textoExtraido += "\n"; textoAnterior = false; } } else if (!dentroDeEtiqueta)
		 * {
		 * 
		 * textoExtraido += c; textoAnterior = true; } }
		 * 
		 * if (textoExtraido.endsWith("\n")) { textoExtraido =
		 * textoExtraido.substring(0, textoExtraido.length() - 1); }
		 * 
		 * System.out.println("Texto extraído:"); System.out.println(textoExtraido);
		 */
		
		System.out.println("¿Cuantos alumnos tienes?");
		
		Integer numA = sc.nextInt();
		double notas = 0.00;
		Double[] notasMedias = new Double[numA + 1];
		String[] nombreAlumnos = new String[numA + 1];
		
		for (int i = 1 ; i <= numA; i++) {
			
			System.out.println("¿Cual es el nombre del Alumno?");
			String s = sc.nextLine();
			nombreAlumnos[i] = sc.nextLine();
			
			for (int j = 1 ; j <= 3 ; j++) {
				
				System.out.println("Cual es la nota de " + nombreAlumnos[i] + " para el examen " + j);
				notas = sc.nextDouble();
				notas = notas + notas;
				
			}
			 notasMedias[i] = notas / 3;
		}
		System.out.println("Listado de notas");
		
		for (int p = 1; p < nombreAlumnos.length; p++) {
			
			System.out.println("\tAlmuno: " + nombreAlumnos[p] + " - " + "Nota media: " + notasMedias[p] );
			
		}
		

		sc.close();
	}

}
