package model.modulo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Almacen {

	private String nombreComercial;
	private Map<String, Cliente> mapa;

	public Almacen(String nombreComercial) {
		this.nombreComercial = nombreComercial;
		this.mapa = new HashMap<>();
	}

	public Integer getCantidadPedidos() {
		Integer total = 0;
		for (Map.Entry<String, Cliente> entry : mapa.entrySet()) {
			List<Pedido> lista = entry.getValue().getPedidos();
			total += lista.size();
		}
		return total;
	}

	public void borrarClientesServidos() {
		List<Cliente> lista = new ArrayList<>();
		for (Map.Entry<String, Cliente> entry : mapa.entrySet()) {
			lista.add(entry.getValue());
		}
		Iterator<Cliente> iterador = mapa.values().iterator();
		while (iterador.hasNext()) {
			Cliente nuevo = iterador.next();
			if (nuevo.tienePedidosPendientes()) {
				mapa.remove(nuevo.getDni());
			}
		}
	}

	public String getNombreComercial() {
		return nombreComercial;
	}

	public void setNombreComercial(String nombreComercial) {
		this.nombreComercial = nombreComercial;
	}

	public Map<String, Cliente> getMapa() {
		return mapa;
	}

	public void setMapa(Map<String, Cliente> mapa) {
		this.mapa = mapa;
	}

}
