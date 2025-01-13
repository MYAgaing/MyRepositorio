package Objetos;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		Alumno alumno1 = new Alumno();
		System.out.println("Diagme el dni");
		alumno1.setDni(sc.nextLine());
		System.out.println("Digame el nombre");
		alumno1.setNombre(sc.nextLine());
		System.out.println("Digame la edad");
		alumno1.setEdad(sc.nextInt());
		System.out.println("Digame la nota");
		alumno1.setNota(sc.nextInt());
		

		System.out.println(
				alumno1.getDni() + " " + alumno1.getNombre() + " " + alumno1.getEdad() + " " + alumno1.getNota());

		
		
		sc.close();
	}
}
