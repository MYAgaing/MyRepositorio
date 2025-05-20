package model.modulo;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

import model.services.EstadoIncorrectoexception;

public abstract class Pedido {

	private Integer numero;
	private LocalDate fecha_pedido;
	private Integer cantidadArticulos;
	private BigDecimal importe;
	private Boolean entregado;

	public Pedido(Integer numero) {
		this.numero = numero;
		this.entregado = false;
		this.fecha_pedido = LocalDate.now();
		this.cantidadArticulos = 0;
	}

	public abstract LocalDate getFechaEntregaPrevista();
	
	public abstract BigDecimal getImporteTotal() throws EstadoIncorrectoexception;
	
	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public LocalDate getFecha_pedido() {
		return fecha_pedido;
	}

	public void setFecha_pedido(LocalDate fecha_pedido) {
		this.fecha_pedido = fecha_pedido;
	}

	public Integer getCantidadArticulos() {
		return cantidadArticulos;
	}

	public void setCantidadArticulos(Integer cantidadArticulos) {
		this.cantidadArticulos = cantidadArticulos;
	}

	public BigDecimal getImporte() {
		return importe;
	}

	public void setImporte(BigDecimal importe) {
		this.importe = importe;
	}

	public Boolean getEntregado() {
		return entregado;
	}

	public void setEntregado(Boolean entregado) {
		this.entregado = entregado;
	}

	@Override
	public int hashCode() {
		return Objects.hash(numero);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pedido other = (Pedido) obj;
		return Objects.equals(numero, other.numero);
	}

	@Override
	public String toString() {
		return numero + " // " + fecha_pedido + " > " + importe + " € (" + cantidadArticulos + " articulos)";
	}

}
