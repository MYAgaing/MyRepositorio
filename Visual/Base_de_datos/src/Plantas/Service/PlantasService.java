package Plantas.Service;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import Plantas.Module.Planta;
import Plantilla.Servicios.OpenConnection;

public class PlantasService extends OpenConnection {

	private OpenConnection openConn;

	public PlantasService() throws SQLException {
		openConn = new OpenConnection();
	}

	public void consultarPersona(Planta p) throws SQLException, PlantaAlturaException {
		String sql = "INSERT INTO PLANTAS VALUES(?,?,?,?,?)";
		try (Connection conn = openConn.getNewConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
			if (p.getAltura().compareTo(new BigDecimal(2)) >= 0) {
				throw new PlantaAlturaException("La planta ha superado la altura maxima");
			}
			stmt.setInt(1, p.getId());
			stmt.setString(2, p.getNombre());
			stmt.setString(3, p.getTipo());
			stmt.setBigDecimal(4, p.getAltura());
			stmt.setDate(4, Date.valueOf(LocalDate.now()));
			stmt.executeUpdate();
		}

	}

	public void actualizarPlantasMedias() throws SQLException, PlantaServiceException {
		String sql = "UPDATE PLANTAS SET TIPO := MEDIA ALTURA WHERE ALTURA <= 1 AND ALTURA >= 1.15;";
		try (Connection conn = openConn.getNewConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

			Integer update = stmt.executeUpdate();
			if (update == 0) {
				throw new PlantaServiceException("No se encontró ninguna planta dentro del rango para actualizar");
			}
		}
	}

	public LocalDate actualizarFechaPlanta(Integer id, LocalDate fecha_nueva)
			throws SQLException, PlantaServiceException {
		String sql = "SELECT * FROM PLANTAS WHERE ID = " + id;
		LocalDate fecha_antigua = null;
		Integer contador = 0;
		try (Connection conn = openConn.getNewConnection(); Statement stmt = conn.createStatement()) {
			ResultSet rs = stmt.executeQuery(sql);
			if (rs.next()) {
				fecha_antigua = rs.getDate("FECHA_PLANTACION").toLocalDate();
				contador++;
			}
			if (contador == 0) {
				throw new PlantaServiceException("No se encontró la planta con ID: " + id);
			}
			return fecha_antigua;
		}
	}

	public Integer eliminarPlantas(LocalDate fecha) throws SQLException {
		String sql = "SELECT * FROM PLANTAS";
		String sql2 = "DELETE FROM PLANTAS WHERE ID = ?";
		Integer plantasEliminadas = 0;
		try (Connection conn = openConn.getNewConnection();
				Statement stmt = conn.createStatement();
				PreparedStatement stmt2 = conn.prepareStatement(sql2)) {
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				if (rs.getDate("FECHA_PLANTACION").toLocalDate().isBefore(fecha)) {
					plantasEliminadas = stmt2.executeUpdate();
					
				}
			}
			return plantasEliminadas;
		}
	}
	public List<Planta> consultarPlantas(Integer año) throws SQLException {
		String sql = "SELECT * FROM PLANTAS WHERE TO_CHAR(FECHA_PLANTACION) = ?";
		List<Planta> lista = new ArrayList<>();
		try (Connection conn = openConn.getNewConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
		stmt.setInt(1, año);
		ResultSet rs = stmt.executeQuery();
		Planta p = new Planta();
		while(rs.next()) {
			p.setId(rs.getInt("ID"));
			p.setNombre(rs.getString("NOMBRE"));
			p.setTipo(rs.getString("TIPO"));
			p.setAltura(rs.getBigDecimal("ALTURA"));
			p.setFecha_plantacion(rs.getDate("FECHA_PLANTACION").toLocalDate());
			lista.add(p);
		}
			return lista;
		}
		
	}
}
