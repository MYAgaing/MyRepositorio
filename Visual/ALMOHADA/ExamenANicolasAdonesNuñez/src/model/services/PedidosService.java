package model.services;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import model.modulo.Pedido;
import model.modulo.pedidoNormal;

public class PedidosService extends OpenConnection {

	public Map<Integer, Pedido> buscarPedidos(LocalDate minima, String dni)
			throws SQLException, NoExisteException, BaseDeDatosException {
		String sql = "SELECT * FROM PEDIDO";
		Integer contador = 0;
		Map<Integer, Pedido> mapa = new HashMap<>();
		try (Connection conn = getNewConnection(); Statement stmt = conn.createStatement()) {
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				if (rs.getDate("FECHA").toLocalDate().isEqual(minima) || rs.getDate("FECHA").toLocalDate().isAfter(minima) && rs.getString("DNI_CLIENTE").equals(dni)) {
					Pedido p = new pedidoNormal(rs.getInt("NUM_PEDIDO"));
					p.setFecha_pedido(rs.getDate("FECHA").toLocalDate());
					p.setCantidadArticulos(rs.getInt("NUM_ARTICULOS"));
					p.setImporte(rs.getBigDecimal("IMPORTE"));
					p.setEntregado(rs.getBoolean("ENTREGADO"));
					mapa.put(rs.getInt("NUM_PEDIDO"), p);
					contador++;
				}
			}
			if (contador == 0) {
				throw new NoExisteException("No hay pedidos para filtros indicados");
			}
			return mapa;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new BaseDeDatosException("Error consultando pedidos");
		}

	}

}
