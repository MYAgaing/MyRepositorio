package Persona;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		Curso c1 = new Curso();
		c1.setIdentificador(1);
		c1.setDescripcion("DAM-DAW");
		List<Alumno> alumnos = new ArrayList<>();
		//Alumno[] alumnos = new Alumno[3];
		for (int i = 0; i < 3; i++) {
			System.out.println("DNI");
			String dni;
			boolean si = true;
			do {
				System.out.println("Dime DNI");
				dni = sc.nextLine();
				if (!alumno.validarDNI()) {
					System.out.println("DNI no valido");
				} else si = true;
			} while (!si);
			alumno.setDni(dni);
			System.out.println("Digame la nota");
			Integer nota = sc.nextInt();
			alumno.setNota(nota);
			System.out.println("Digame el nombre");
			sc.nextLine();
			String nombre = sc.nextLine();
			alumno.setNombre(nombre);
			System.out.println("Edad");
			Integer edad = sc.nextInt();
			sc.nextLine();
			alumno.setEdad(edad);
			alumno.setCurso(c1);
			alumnos.add(alumno);

		}
		for (Alumno alumno : alumnos) {
			System.out.println(alumno);
			if (alumno.validar(alumno)) {
				System.out.println("Cumple las validaciones");
			} else {
				System.out.println("No cumple validaciones");
			}
		}

		if (alumnos[0].equals(alumnos[1]) || alumnos[0].equals(alumnos[2]) || alumnos[1].equals(alumnos[2])) {
			System.out.println("2 son iguales");
		} else {
			System.out.println("No hay ninguno igual");
		}
			sc.close();
	}

}
