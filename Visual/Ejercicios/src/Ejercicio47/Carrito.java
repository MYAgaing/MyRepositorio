package Ejercicio47;

import java.math.BigDecimal;
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

	public BigDecimal getCantidad() {
		BigDecimal total2 = BigDecimal.ZERO;
		for (Articulos articulos2 : articulos) {
			BigDecimal uno = BigDecimal.ONE;
			total2 = total2.add(uno);
		};
		return total2;
	}

	public BigDecimal getTotal() {
		BigDecimal total = BigDecimal.ZERO;
			for (Articulos articulo : articulos) {
				total = total.add(articulo.getPrecio());
			}
			return total;
	}

	public BigDecimal precioMedio() {
		if (getCantidad() == BigDecimal.ZERO) {
			return BigDecimal.ZERO;
		}
		return getTotal().divide(getCantidad());
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
