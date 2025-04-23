package App;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Scanner;

import Modelo.Plantilla;
import Sevicios.DatosIncompletosException;
import Sevicios.PlantillaService;

public class app {

	public static void main(String[] args) throws SQLException, DatosIncompletosException {
		Scanner sc = new Scanner(System.in);
		/*
		 * System.out.println("Indica el DNI de la persona"); String vDNI =
		 * sc.nextLine(); PlantillaService service = new PlantillaService(); Plantilla p
		 * = service.consultarPersona(vDNI); try { if (p == null) {
		 * System.out.println("No existe usuario con dni " + vDNI); } else {
		 * System.out.println(p); } } finally { sc.close(); }
		 * 
		 * PlantillaService service2 = new PlantillaService();
		 * 
		 * Plantilla p2 = new Plantilla(); System.out.println("Digame el dni");
		 * p2.setDni("11111111C"); System.out.println("Digame el Nombre");
		 * p2.setNombre("Nano"); System.out.println("Digame los apellidos");
		 * p2.setApellidos("Nini"); System.out.println("Digame la fecha de nacimiento");
		 * String date = "10/01/1976"; try { if (p2.validar(p2)) { try {
		 * service2.isertarPersona(p2,date); } catch (Exception e) {
		 * System.out.println("Error " + e); } finally { sc.close(); } } } finally {
		 * sc.close(); }
		 */
		try {
			PlantillaService service = new PlantillaService();
			Boolean nico = true;
			while (nico) {
				System.out.println(
						"Que desea hacer?\n1.Consultar persona con DNI\n2.Consultar personas con Nombre y apellidos\n3.Insertar usuario\n4.Cerrar programa");
				Integer num = sc.nextInt();
				if (num == 1) {
					System.out.println("Digame el DNI del usuario");
					Plantilla p = service.consultarPersona(sc.nextLine());
					System.out.println(p);
					System.out.println("¿Desea hacer algo mas?");
				} else if (num == 2) {
					System.out.println("Digame el Nombre o apellidos a consultar");
					List<Plantilla> resultado = service.buscarPersonas(sc.nextLine());
					System.out.println(resultado);
					System.out.println("¿Desea hacer algo mas?");
				} else if (num == 3) {
					System.out.println("Para insertar un usuario digame el Nombre, apellido, DNI y fecha nacimiento");
					Plantilla p = new Plantilla();
					p.setNombre(sc.nextLine());
					p.setApellidos(sc.nextLine());
					p.setDni(sc.nextLine());
					DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
					String vFecha = sc.nextLine();
					try {
						LocalDate fechaNacimiento = LocalDate.parse(vFecha,format);
						p.setFecha_nacimiento(fechaNacimiento);
					} catch(DateTimeParseException e) {
						System.out.println("La fecha no es correcta");
					}
					
					service.insertarPersona(p);
					System.out.println("¿Desea hacer algo mas?");
				} else {
					System.out.println("Cerrando programa");
					nico = false;
				}
			}

		} finally {
			sc.close();
		}
	}

}
