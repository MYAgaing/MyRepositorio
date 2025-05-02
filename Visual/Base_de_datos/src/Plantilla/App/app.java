package Plantilla.App;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Plantilla.Modelo.Plantilla;
import Plantilla.Servicios.DatosIncompletosException;
import Plantilla.Servicios.PlantillaService;

public class app {

	public static void main(String[] args) throws SQLException, DatosIncompletosException {
		Scanner sc = new Scanner(System.in);

		try {
			PlantillaService service = new PlantillaService();
			Boolean nico = true;
			while (nico) {
				System.out.println(
						"Que desea hacer?\n1.Consultar persona con DNI\n2.Consultar personas con Nombre y apellidos\n3.Insertar usuario\n4.Actualizar Registro\n5.Borrar persona\n6.Insertar lista de personas\n7.Cerrar programa");
				Integer num = sc.nextInt();
				if (num == 1) {
					System.out.println("Digame el DNI del usuario");
					String dni = sc.nextLine();
					Plantilla p = service.consultarPersona(dni);
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
						LocalDate fechaNacimiento = LocalDate.parse(vFecha, format);
						p.setFecha_nacimiento(fechaNacimiento);
					} catch (DateTimeParseException e) {
						System.out.println("La fecha no es correcta");
					}

					service.insertarPersona(p);
					System.out.println("¿Desea hacer algo mas?");
				} else if (num == 4) {
					try {
						service.actualizarPersonas();
					} catch (SQLException e) {
						System.out.println("No hay alguien con ese DNI");
					}

				} else if (num == 5) {

					try {
						service.borrarPersona();
					} catch (SQLException e) {
						System.out.println("No existe una persona con ese dni");
					}
				} else if (num == 6) {
					try {
						List<Plantilla> lista = new ArrayList<>();
						System.out.println("Indique la lista a insertar");
						Plantilla p1 = new Plantilla();
						Plantilla p2 = new Plantilla();
						Plantilla p3 = new Plantilla();
						p1.setNombre("Nico");
						p1.setApellidos("Adones");
						p1.setDni("222222222A");
						DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
						String vFecha = "15/08/2008";
						try {
							LocalDate fechaNacimiento = LocalDate.parse(vFecha, format);
							p1.setFecha_nacimiento(fechaNacimiento);
						} catch (DateTimeParseException e) {
							System.out.println("La fecha no es correcta");
						}
						p2.setNombre("Nica");
						p2.setApellidos("Adonas");
						p2.setDni("222222222B");
						String vFecha2 = "15/07/2007";
						try {
							LocalDate fechaNacimiento = LocalDate.parse(vFecha2, format);
							p2.setFecha_nacimiento(fechaNacimiento);
						} catch (DateTimeParseException e) {
							System.out.println("La fecha no es correcta");
						}
						p3.setNombre("Nici");
						p3.setApellidos("Adonis");
						p3.setDni("222222222C");
						String vFecha3 = "15/05/2002";
						try {
							LocalDate fechaNacimiento = LocalDate.parse(vFecha3, format);
							p3.setFecha_nacimiento(fechaNacimiento);
						} catch (DateTimeParseException e) {
							System.out.println("La fecha no es correcta");
						}
						service.insertarListaPersonas(lista);
					} catch (SQLException e) {
						System.out.println("Error al inserta la lista");
					}
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
