package Objetos;

import java.util.Scanner;

public class Ejercicio20constructor {

	public static void main(String[] arg) {
		
		Scanner sc = new Scanner(System.in);
		
		Alumno1 alumno = new Alumno1();	
		
		System.out.println("Digame su DNI");
		String dni = sc.nextLine();
		alumno.setDni(dni);
		Alumno1 alumno2 = new Alumno1(dni);

		System.out.println("Digame su nombre");
		String nombre = sc.nextLine();
		alumno.setNombre(nombre);
		
		System.out.println("digame su edad");
		Integer edad = sc.nextInt();
		alumno.setEdad(edad);
		
		System.out.println("Digame su nota");
		Integer nota = sc.nextInt();
		alumno.setNota(nota);
		
		
		sc.close();
	}
	
}
