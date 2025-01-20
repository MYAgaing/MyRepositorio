package Persona;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		
		Profesor profesor1 = new Profesor();
		Curso curso1 = new Curso();
		curso1.setNombre("C1");
		System.out.println("Dime el nombre del profesor");
		profesor1.setNombre(sc.nextLine());
		System.out.println("Digame su edad");
		profesor1.setEdad(sc.nextInt());
		Alumno alumno1 = new Alumno();
		alumno1.setNombre("nico");
		alumno1.setEdad(11);
		alumno1.setCurso(curso1);
		alumno1.setNota(20);
		System.out.println(alumno1);
		
		sc.close();
	}

}
