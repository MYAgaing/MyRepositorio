package Gourmet.Service;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Gourmet.Modulo.Producto;

public class GourmetService {

	private OpenConnection openConn;

	public GourmetService() throws SQLException {
		openConn = new OpenConnection();
	}

	public void insertarProducto(Producto p) throws SQLException, ProductoInvalidoException {
		String sql = "INSERT INTO PRODUCTOS_GOURMET VALUES (?,?,?,?,?)";
		try (Connection conn = openConn.getNewConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
			if (p.getPrecio().compareTo(new BigDecimal(0)) <= 0) {
				throw new ProductoInvalidoException("Producto invalido, inserte otro producto");
			}

			stmt.setInt(1, p.getId());
			stmt.setString(2, p.getNombre());
			stmt.setString(3, p.getTipo());
			stmt.setBigDecimal(4, p.getPrecio());
			stmt.setBoolean(5, p.getDisponible());
			stmt.executeUpdate();
		}
	}

	public void insertarProductoB(Producto p, Connection conn) throws SQLException, ProductoInvalidoException {
		String sql = "INSERT INTO PRODUCTOS_GOURMET VALUES (?,?,?,?,?)";
		try (PreparedStatement stmt = conn.prepareStatement(sql)) {
			conn.setAutoCommit(false);
			if (p.getPrecio().compareTo(new BigDecimal(0)) <= 0) {
				throw new ProductoInvalidoException("Producto invalido, inserte otro producto");
			}

			stmt.setInt(1, p.getId());
			stmt.setString(2, p.getNombre());
			stmt.setString(3, p.getTipo());
			stmt.setBigDecimal(4, p.getPrecio());
			stmt.setBoolean(5, p.getDisponible());
			stmt.executeUpdate();
		}
	}

	public void insertarProductos(List<Producto> lista) throws SQLException, ProductoInvalidoException {

		try (Connection conn = openConn.getNewConnection()) {
			conn.setAutoCommit(false);
			try {
				for (Producto producto : lista) {
					insertarProductoB(producto, conn);
				}
				conn.commit();
			} catch (Exception e) {
				conn.rollback();
				System.out.println("Error al introducir productos");
			}
		}
	}

	public List<Producto> consultaTipoProductos(String tipo) throws SQLException, ProductoNoEncontradoException {
		String sql = "SELECT * FROM PRODUCTOS_GOURMET WHERE TIPO = ?";
		List<Producto> lista = new ArrayList<>();
		ResultSet rs = null;
		try (Connection conn = openConn.getNewConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setString(1, tipo);
			Integer contador = stmt.executeUpdate();
			rs = stmt.getResultSet();

			while (rs.next()) {
				Producto p = new Producto(rs.getInt("ID"), rs.getString("NOMBRE"), rs.getString("TIPO"),
						rs.getBigDecimal("PRECIO"), rs.getBoolean("DISPONIBLE"));
				lista.add(p);
			}
			if (contador == 0) {
				throw new ProductoNoEncontradoException("No es ha encontrado productos de ese tipo");
			}
			return lista;
		}

	}

	public void eliminarProducto(Integer id) throws SQLException, ProductoNoEncontradoException {
		String sql = "DELETE FROM PRODUCTOS_GOURMET WHERE ID = ?";
		try (Connection conn = openConn.getNewConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setInt(1, id);
			Integer contador = stmt.executeUpdate();
			if (contador == 0) {
				throw new ProductoNoEncontradoException("No se ha encontrado ningun producto con ese ID");
			}
			System.out.println("Borrado exitosamente");
		}
	}

	public Map<Integer, Producto> consultarProductosDisponibles() throws SQLException {
		Map<Integer, Producto> mapa = new HashMap<>();
		String sql = "SELECT * FROM PRODUCTOS_GOURMET WHERE DISPONIBLE = ?";
		ResultSet rs = null;
		try (Connection conn = openConn.getNewConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setInt(1, 1);
			rs = stmt.executeQuery();
			while (rs.next()) {
				Producto p = new Producto(rs.getInt("ID"), rs.getString("NOMBRE"), rs.getString("TIPO"),
						rs.getBigDecimal("PRECIO"), rs.getBoolean("DISPONIBLE"));
				mapa.put(rs.getInt("ID"), p);
			}
			return mapa;
		}

	}
}
