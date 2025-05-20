package model.modulo;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.services.EstadoIncorrectoexception;
import model.services.NoExisteException;

public class Cliente {

	private String dni;
	private List<Pedido> pedidos;

	public Cliente() {

	}

	public Boolean tienePedidosPendientes() {
		for (Pedido pedido : pedidos) {
			if (pedido.getEntregado() == false) {
				return true;
			}
		}
		return false;
	}

	public BigDecimal getImportePendiente() throws EstadoIncorrectoexception {
		BigDecimal total = BigDecimal.ZERO;
		for (Pedido pedido : pedidos) {
			if (tienePedidosPendientes()) {
				total = total.add(pedido.getImporteTotal());
			}
		}
		return total;
	}
	public Map<Integer,Integer> getArticulosPedidos(){
		Map<Integer,Integer> mapa = new HashMap<>();
		for (Pedido pedido : pedidos) {
			mapa.put(pedido.getNumero(), pedido.getCantidadArticulos());
		}
		return mapa;
	}
	public Pedido getPedidoCritico() throws NoExisteException {
		Integer contador = 0;
		Integer dias = 0;
		Pedido p = new pedidoNormal(null);
		for (Pedido pedido : pedidos) {
			if(pedido.getEntregado() == false && pedido.getFechaEntregaPrevista().isBefore(LocalDate.now()) && pedido.getFechaEntregaPrevista().isBefore(pedido.getFechaEntregaPrevista().plusMonths(1))) {
				Period periodo = pedido.getFechaEntregaPrevista().until(LocalDate.now());
				if(periodo.getDays() > dias) {
					p = pedido;
				}
			}
		}
		if (contador == 0) {
			throw new NoExisteException("No existe un pedido Critico");
		}
		return p;
	}
	
	
	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public List<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}

}
