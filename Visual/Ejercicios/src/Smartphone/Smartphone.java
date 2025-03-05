package Smartphone;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;

public class Smartphone {
	
	private String marca;
	private String modelo;
	private String imei;
	private BigDecimal precio;
	private LocalDate fecha_fabricacion;
	private Boolean activo;

	public Smartphone() {
		this.precio = new BigDecimal(0);
		this.activo = true;
	}
	public Smartphone(String imei) {
		this.imei = "";
		this.precio = new BigDecimal(0);
		this.activo = true;
	}
	public Smartphone(String imei, String marca, String modelo) {
		this.imei = "";
		this.precio = new BigDecimal(0);
		this.activo = true;
	}
	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}
	public Boolean activar(Boolean x) {
		return true;
	}
	public Boolean desactivar(Boolean x) {
		return false;
	}
	public Integer getEdad(LocalDate edad) {
		LocalDate fecha = LocalDate.of(2000, 4 , 1);
		Period p = fecha.until(fecha_fabricacion);
		return p.getYears();
	}
	public void cambiarMarcaModelo(String x,String y) {
		this.marca = x;
		this.modelo = y;
	}
	public void establecerFabricacion(LocalDate x) {
		this.fecha_fabricacion = x;
	}
	public BigDecimal getPrecioMasIva() {
		BigDecimal precioMasIva = new BigDecimal(0);
		BigDecimal Iva = new BigDecimal(1.21);
		return precioMasIva.multiply(Iva);
	}
	public Boolean isAltaGama(BigDecimal precioBase) {
		if (precio.max(precioBase).equals(precio)) {
			return true;
		} else {
			return false;
		}
	}
	public Boolean isDatosCompletos() {
		if (imei.isEmpty() || imei.isBlank() || precio == null) {
			return false;
		} else {
			return true;
		}
	}
	public void isGratis() {
		if (precio.equals(0)) {
			System.out.println("Es gratis");
		} else {
			System.out.println("Cuesta " + precio);
		}
	}
	public void rebajar() {
		this.precio = this.precio.subtract(new BigDecimal(10));
	}
	@Override
	public String toString() {
		if(!this.activo) {
			return marca + "(" + modelo + ") - Inactivo";
		}
		return marca + "(" + modelo + ")";
	}
	
	
	
}
