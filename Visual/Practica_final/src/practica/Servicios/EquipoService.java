package practica.Servicios;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import practica.Modelo.Equipo;
import practica.Modelo.Jugador;

/*
 * Este servicio gestiona las operaciones de los jugadores y equipos
 * En este caso se comunica con la base de datos 
 */

public class EquipoService {

	private OpenConnection openConn;

	Scanner sc = new Scanner(System.in);

	public EquipoService() throws SQLException {
		openConn = new OpenConnection();
	}
/*
 * @return Este metodo devuelve una lista de objetos equipos
 * @throws EquipoServiceException en caso de que de error en la base de datos
 * @throws SQLException en caso de que de error en la base de datos
 */
	public List<Equipo> consultarEquipos() throws EquipoServiceException, SQLException {
		List<Equipo> equipos = new ArrayList<>();
		ResultSet rs = null;
		try (Connection conn = openConn.getNewConnection(); Statement stmt = conn.createStatement()) {
			try {

				String sql = "SELECT * FROM EQUIPO";
				rs = stmt.executeQuery(sql);
				while (rs.next()) {
					Equipo j = new Equipo();
					j.setCodigo(rs.getString("CODIGO"));
					j.setNombre(rs.getString("NOMBRE"));
					equipos.add(j);
				}

			} catch (SQLException e) {
				throw new EquipoServiceException();
			}
		} catch (EquipoServiceException e) {
			System.out.println("Error al consultar los equipos");
			return null;
		}
		return equipos;
	}
/*
 * @param codigo , recive una cadena que es el codigo a buscar
 * @return Este metodo devuelve una lista de jugadores 
 * @throws SQLException en caso de que de error en la base de datos
 */
	public List<Jugador> consultarJugadoresEquipo(String codigo) throws SQLException {
		String sql = "SELECT * FROM JUGADOR WHERE CODIGO_EQUIPO = ?";
		ResultSet rs = null;
		List<Jugador> jugadores = new ArrayList<>();
		try (Connection conn = openConn.getNewConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setString(1, codigo);
			rs = stmt.executeQuery();

			while (rs.next()) {
				Jugador j1 = new Jugador();
				j1.setNombre(rs.getString("NOMBRE"));
				j1.setNumero(rs.getInt("NUMERO"));
				j1.setFecha_nacimiento(rs.getDate("NACIMIENTO").toLocalDate());
			}
		} catch (SQLException e) {
			System.out.println("Fallo al consultar jugadores");
		}
		return jugadores;
	}

/*
 * @param Codigo , recive una cadena que es el codigo a buscar
 * @return Devuelve una lista de jugadores
 * @throws SQLException en caso de que de error de base de datos 
 * @throws EquipoServiceException  en caso de que de error en la base de datos
 */
	
	public List<Jugador> consultarEquipoCompleto(String codigo) throws SQLException, EquipoServiceException {
		String sql = "SELECT * FROM JUGADOR WHERE CODIGO_EQUIPO = ?";
		List<Jugador> lista = new ArrayList<>();
		ResultSet rs = null;
		int i = 0;
		try (Connection conn = openConn.getNewConnection(); PreparedStatement stmt = conn.prepareStatement(sql);) {
			stmt.setString(1, codigo);
			rs = stmt.executeQuery();
			while (rs.next()) {
				Jugador j = new Jugador();
				j.setNumero(rs.getInt("NUMERO"));
				j.setCodigo_equipo(rs.getString("CODIGO_EQUIPO"));
				j.setNombre(rs.getString("NOMBRE"));
				LocalDate fecha = rs.getDate("NACIMIENTO").toLocalDate();
				j.setFecha_nacimiento(fecha);
				lista.add(j);
				i++;
			}
			if (i == 0) {
				throw new NotFoundException();
			}
		} catch (SQLException e) {
			throw new EquipoServiceException(e.getMessage());
		} catch (NotFoundException e) {
			System.out.println("Error a la hora de consultar el equipo");
		}
		return lista;
	}
/*
 * @param conn  J, recibe una connexción y un objeto jugador, entonces inserta a un jugador
 * @return No devuelve nada
 * @throws SQLException si hay problemas con la base de datos
 */
	public void insertarJugador(Connection conn, Jugador j) throws SQLException {
		String sql = "INSERT INTO JUGADOR VALUES (?,?,?,?)";
		try (PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setInt(1, j.getNumero());
			stmt.setString(2, j.getCodigo_equipo());
			stmt.setString(3, j.getNombre());
			stmt.setDate(4, Date.valueOf(j.getFecha_nacimiento()));
			stmt.executeUpdate();
		}
	}
/*
 * @param e , recibe un objeto equipo el cual lo crea en la base de datos
 * @return no devuelve nada
 * @throws SQLEception si hay algun problema con la base de datos
 */
	public void crearEquipo(Equipo e) throws SQLException {
		Integer contador = 0;
		String sql = "INSERT INTO EQUIPO VALUES (?,?)";
		String sql2 = "SELECT MAX(NUMERO) FROM JUGADOR WHERE CODIGO_EQUIPO = ?";
		Boolean nico = true;
		try (Connection conn = openConn.getNewConnection();
				PreparedStatement stmt = conn.prepareStatement(sql);
				PreparedStatement stmt2 = conn.prepareStatement(sql2);) {
			try {
				conn.setAutoCommit(false);

				stmt.setString(1, e.getCodigo());
				stmt.setString(2, e.getNombre());
				stmt.executeUpdate();

				while (nico) {
					Jugador j = new Jugador();
					System.out.println("Indique el nombre del jugador");
					j.setNombre(sc.nextLine());
					System.out.println("Indica Fecha nacimiento Jugador (dd/MM/yyyy)");
					DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
					try {
						String fecha = sc.nextLine();
						LocalDate nacimiento = LocalDate.parse(fecha, format);
						j.setFecha_nacimiento(nacimiento);
					} catch (DateTimeParseException e2) {
						System.out.println("Error a introducir la fecha, utilize el formato correcto");
					}
					stmt2.setString(1, e.getCodigo());
					ResultSet rs = stmt2.executeQuery();
					if (rs.next()) {
						contador = rs.getInt(1);
					}
					j.setNumero(contador + 1);
					j.setCodigo_equipo(e.getCodigo());
					insertarJugador(conn, j);
					conn.commit();
					System.out.println("¿Desea añadir otro jugador? (S/N)");
					try {
						String seguir = sc.nextLine();
						if (seguir.equalsIgnoreCase("N".trim())) {
							nico = false;
						}
					} catch (InputMismatchException e3) {
						System.out.println("(S/N)");
					}

				}
				conn.commit();
				conn.close();
				System.out.println("Equipo guardado!!");
			} catch (SQLException e4) {
				conn.rollback();
				throw new EquipoServiceException(e4.getMessage());
			}
		} catch (EquipoServiceException e5) {
			System.out.println("Fallo al introducir los datos " + e5.getMessage());
		}
	}
/*
 * @param codigo , recive un codigo como cadena que es el equipo a borrar
 * @return no devuelve nada
 * @throws SQLException Si hay problemas con la base de datos o NotFoundException si no encuentra nada en la base de datos
 */
	public void borrarEquipoCompleto(String codigo) throws SQLException, NotFoundException {
		String sql = "DELETE FROM JUGADOR WHERE CODIGO_EQUIPO = ?";
		String sql2 = "DELETE FROM EQUIPO WHERE CODIGO = ?";
		String sql3 = "SELECT COUNT(*) FROM EQUIPO WHERE CODIGO = ?";
		Integer num = 0;
		ResultSet rs = null;
		try (Connection conn = openConn.getNewConnection();
				PreparedStatement stmt = conn.prepareStatement(sql);
				PreparedStatement stmt2 = conn.prepareStatement(sql2);
				PreparedStatement stmt3 = conn.prepareStatement(sql3)) {
			try {
				conn.setAutoCommit(false);

				try {
					stmt3.setString(1, codigo);
					rs = stmt3.executeQuery();
					if (rs.next()) {
						num = rs.getInt(1);
					}
					if (num == 1) {
						stmt.setString(1, codigo);
						stmt.executeUpdate();
						stmt2.setString(1, codigo);
						stmt2.executeUpdate();
					} else {
						conn.rollback();
						throw new NotFoundException();
					}
					conn.commit();
				} catch (NotFoundException e) {
					System.out.println("Error al borrar el equipo" + e.getMessage());
				} catch (Exception e) {
					throw new EquipoServiceException();
				}
			} catch (EquipoServiceException e) {
				System.out.println("Error al borrar el equipo");
				conn.rollback();
			}
		}

	}
/*
 * @param a  b , recive un objeto Equipo y Jugador, se encargar de meter un jugador a un equipo
 * @return no devulve nada
 * @throws SQLException si hay algun error con la base de datos y EquipoServiceException si hay algun problema con el usuario
 */
	public void añadirJugadorAEquipo(Equipo a, Jugador b) throws SQLException, EquipoServiceException {
		Integer contador = 0;
		String sql = "SELECT MAX(NUMERO) FROM JUGADOR WHERE CODIGO_EQUIPO = ?";
		try (Connection conn = openConn.getNewConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setString(1, a.getCodigo());
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				contador = rs.getInt(1);
			}
			b.setNumero(contador + 1);
			b.setCodigo_equipo(a.getCodigo());

			insertarJugador(conn, b);
		} catch (Exception e) {
			throw new EquipoServiceException();
		}
	}
	/*
	 * @param codigo  ruta, recive una cadena codigo y la ruta donde se le exportara la lista de jugadores del equipo
	 * @return no devulve nada
	 * @throws SQLException si hay algun error con la base de datos y EquipoServiceException si hay algun problema con el usuario, y 
	 * IOException si hay problemas al exportar.
	 */
	public void exportarJugadores(String codigo, String ruta) throws IOException, SQLException, NotFoundException {
		File archivo = new File(ruta);
		try {
			try {
				Boolean fichero = archivo.createNewFile();
				FileWriter write = new FileWriter(archivo);
				List<Jugador> lista = consultarEquipoCompleto(codigo);
				System.out.println(lista);
				if (fichero) {
					if (lista.size() == 0) {
						write.close();
						throw new NotFoundException();
					} else {
						for (Jugador jugador : lista) {
							write.write(jugador.getNumero() + " - " + jugador.getNombre() + " - "
									+ jugador.getFecha_nacimiento() + "\n");
						}
						write.close();
					}
				} else {
					for (Jugador jugador : lista) {
						write.write(jugador.getNumero() + " - " + jugador.getNombre() + " - "
								+ jugador.getFecha_nacimiento() + "\n");
					}
					write.close();
				}
			} catch (IOException e) {
				System.out.println("Error al crear el fichero: " + e.getMessage());
			} catch (NotFoundException e) {
				System.out.println("Error al encontrar el equipo: " + e.getMessage());
			} catch (Exception e) {
				throw new EquipoServiceException();
			}
		} catch (EquipoServiceException e) {
			System.out.println("Error al crear el archivo: " + e.getMessage());
		}

	}

}
