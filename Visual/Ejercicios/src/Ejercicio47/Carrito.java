package Ejercicio47;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Carrito {

	protected LocalDate fecha_creacion;
	protected LocalDate fecha_ultima;
	private Cliente cliente1;
	private List<Articulos> articulos;
	DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	public LocalDate getFecha_creacion() {
		return fecha_creacion;
	}
	String ultima_fecha;
	public String getFecha_ultima() {
		ultima_fecha = fecha_ultima.format(formato);
		return ultima_fecha;
	}

	public Cliente getCliente1() {
		return cliente1;
	}

	public List<Articulos> getArticulos() {
		return articulos;
	}

	public Integer getCantidad() {
		return articulos.size();
	}

	public Integer getTotal() {
		Integer total = 0;
			for (Articulos articulo : articulos) {
				total += articulo.getPrecio();
			}
			return total;
	}

	public Integer precioMedio() {
		Integer precioMedio;
		return precioMedio = getTotal()/articulos.size();
	}

	@Override
	public String toString() {
		return "Carrito [fecha_ultima=" + ultima_fecha + ", cliente1=" + cliente1 + ", articulos=" + articulos
				+ ", getTotal()=" + getTotal() + "]";
	}
	public void addArticulo(Articulos articulo) {
		articulos.add(articulo);
	}
	public void borrarArticulo(Integer integer) {
		articulos.remove(integer);
	}
	public void vaciarCesta() {
		articulos.clear();
	}
	
}
