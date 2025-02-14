package Ejercicio47;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Set;

public class Carrito {

	protected LocalDate fecha_creacion;
	protected LocalDate fecha_ultima;
	private Cliente cliente;
	private Set<Articulos> articulos;
	
	public Carrito() {
		
	}
	
	public Carrito(Cliente cliente) {
		this.cliente = cliente;
		fecha_creacion = LocalDate.now();
		fecha_ultima = LocalDate.now();
		articulos = new HashSet<>();
	}
	public LocalDate getFecha_creacion() {
		return fecha_creacion;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public Set<Articulos> getArticulos() {
		return articulos;
	}

	public int getCantidad() {
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
		if (getCantidad() == 0) {
			return 0;
		}
		return getTotal() / getCantidad();
	}

	@Override
	public String toString() {
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		return "cliente1=" + cliente + ", articulos=" + getCantidad()
				+ ", getTotal()=" + getTotal() + "]" + fecha_ultima.format(formato);
	}
	public void addArticulo(Articulos articulo) {
		articulos.add(articulo);
		fecha_ultima = LocalDate.now();
	}
	public void borrarArticulo(int posicion) {
		if (posicion >=0 && posicion<this.articulos.size())
		articulos.remove(posicion);
		fecha_ultima = LocalDate.now();
	}
	public void vaciarCesta() {
		articulos.clear();
		fecha_ultima = LocalDate.now();
	}
	
	
}
