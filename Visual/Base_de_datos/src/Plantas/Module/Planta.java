package Plantas.Module;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Planta {

	private Integer id;
	private String nombre;
	private String tipo;
	private BigDecimal altura;
	private LocalDate fecha_plantacion;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public BigDecimal getAltura() {
		return altura;
	}
	public void setAltura(BigDecimal altura) {
		this.altura = altura;
	}
	public LocalDate getFecha_plantacion() {
		return fecha_plantacion;
	}
	public void setFecha_plantacion(LocalDate fecha_plantacion) {
		this.fecha_plantacion = fecha_plantacion;
	}
	
	
	
}
