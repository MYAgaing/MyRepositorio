package Examen.Servicio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import Examen.Modulo.Libro;

public class LibreriaService extends OpenConnection {

	public void insertarUnLibronuevo(Libro libro) throws SQLException, LibrosException {
		String sql = "INSERT INTO LIBROS VALUES (?,?,?,?)";

		try (Connection conn = getNewConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setString(1, libro.getISBN());
			stmt.setString(2, libro.getTitulo());
			stmt.setString(3, libro.getAutor());
			stmt.setBigDecimal(4, libro.getPrecio());
		} catch (Exception e) {
			throw new LibrosException();
		}
	}

	public Boolean actualizarPrecioLibroNuevo(Libro libro) throws SQLException, LibrosException {
		String sql = "UPDATE LIBROS SET PRECIO = ? WHERE ISBN = ?";
		try (Connection conn = getNewConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setBigDecimal(1, libro.getPrecio());
			stmt.setString(2, libro.getISBN());
			Integer feches = stmt.executeUpdate();
			if (feches == 0) {
				return false;
			}
			return true;
		} catch (SQLException e) {
			throw new LibrosException();
		}
	}

}
