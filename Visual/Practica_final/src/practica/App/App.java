package practica.App;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import practica.Modelo.Equipo;
import practica.Modelo.Jugador;
import practica.Servicios.EquipoService;
import practica.Servicios.EquipoServiceException;
import practica.Servicios.NotFoundException;

public class App {

	public static void main(String[] args) throws SQLException, EquipoServiceException {
		Scanner sc = new Scanner(System.in);
		List<Equipo> lista = new ArrayList<>();
		try {
			Boolean nico = true;
			Integer num = 0;

			EquipoService service = new EquipoService();
			do {

				System.out.println("----------------------------------------------------------");
				System.out.println(
						"Elige una de estas opciones:\n\t (1) Ver todos los equipos registrados\n\t (2) Crear un nuevo equipo\n\t (3) Consulta un equipo por su codigo\n\t (0) Salir");
				System.out.println("----------------------------------------------------------");
				num = sc.nextInt();
				if (num == 0) {
					System.out.println("Bye!!");
					nico = false;
				} else if (num == 1) {
					lista = service.consultarEquipos();
					System.out.println("Listado de equipos:");
					for (Equipo string : lista) {
						System.out.println("\tEquipo: " + string.getCodigo() + " / " + string.getNombre());
					}
				} else if (num == 2) {
					Equipo e = new Equipo();
					System.out.println("Indica Código equipo");
					sc.nextLine();
					e.setCodigo(sc.nextLine().trim());
					System.out.println("Indica Nombre equipo");
					e.setNombre(sc.nextLine().trim());
					service.crearEquipo(e);
				} else if (num == 3) {
					Boolean nico2 = true;
					System.out.println("Indica Código equipo:");
					sc.nextLine();
					String codigo2 = sc.nextLine().trim();
					List<Jugador> listaJu = service.consultarEquipoCompleto(codigo2);
					System.out.println(">> PLANTILLA:");
					for (Jugador jugador : listaJu) {
						System.out.println(jugador.getNumero() + " - " + jugador.getNombre() + " - "
								+ jugador.getFecha_nacimiento() + "\n");
					}
					while (nico2) {
						System.out.println("----------------------------------------------------------");
						System.out.println(
								"Elige una de estas opciones para el equipo:\n\t (1) Ver plantilla del equipo\n\t (2) Borrar equipo\n\t (3) Añadir un jugador\n\t (4) Calcular edad media de la plantilla\n\t (5) Exportar plantilla del equipo a fichero\n\t (0) Volver al menu principal");
						System.out.println("----------------------------------------------------------");
						Integer num2 = sc.nextInt();
						if (num2 == 0) {
							break;
						} else if (num2 == 1) {
							List<Jugador> lista2 = service.consultarEquipoCompleto(codigo2);
							System.out.println(">> PLANTILLA:");
							for (Jugador jugador : lista2) {
								System.out.println(jugador.getNumero() + " - " + jugador.getNombre() + " - "
										+ jugador.getFecha_nacimiento() + "\n");
							}
						} else if (num2 == 2) {
							try {
								service.borrarEquipoCompleto(codigo2);
								System.out.println("Equipo eliminado!!");
							} catch (NotFoundException e) {
								System.out.println("Error al realizar la operación");
							}

						} else if (num2 == 3 ) {
							Equipo a = new Equipo();
							Jugador b = new Jugador();
							try {
								a.setCodigo(codigo2);
								System.out.println("Introduzca Nombre jugador: ");
								sc.nextLine();
								b.setNombre(sc.nextLine());
								System.out.println("Introduzca Fecha nacimiento Jugador (dd/MM/yyyy)");
								DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
								try {
									String fecha = sc.nextLine();
									LocalDate nacimiento = LocalDate.parse(fecha, format);
									b.setFecha_nacimiento(nacimiento);
								} catch (DateTimeParseException e2) {
									System.out.println("Error a introducir la fecha, utilize el formato correcto");
								}
								service.añadirJugadorAEquipo(a, b);
								System.out.println("Jugador guardado!!");
							}catch(Exception e) {
								System.out.println("Error al introducir el jugador" + e.getMessage());
							}
						} else if (num2 == 4) {
							Equipo c = new Equipo();
							c.setJugadores(listaJu);
							System.out.println(c.getEdadMedia());
						} else if (num2 == 5) {
							try {
							System.out.println("Indica Ruta fichero");
							sc.nextLine();
							service.exportarJugadores(codigo2, sc.nextLine());
							System.out.println("Exportacion exitosa");
							} catch (Exception e) {
								System.out.println("Error al exportar fichero");
							}
						}
					}

				} else {
					System.out.println("Error, por favor especifique de nuevo :");
				}

				
			} while (nico);
		} finally {
			sc.close();
		}
	}

}
