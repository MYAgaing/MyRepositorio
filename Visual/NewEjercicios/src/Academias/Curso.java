package Academias;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;

public class Curso extends Academia{

	private String nombre;
	private LocalDate fecha_inicio;
	private LocalDate fecha_final;
	private BigDecimal precio;
	private Integer num_plazas_total;
	private Integer num_plazas_ocupada;
	
	public Curso(String nombre,BigDecimal precio,Integer num_plazas_total) {
		this.nombre = nombre;
		this.precio = precio;
		this.num_plazas_total = num_plazas_total;
		this.num_plazas_ocupada = 0;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public LocalDate getFecha_inicio() {
		return fecha_inicio;
	}

	public void setFecha_inicio(LocalDate fecha_inicio) {
		this.fecha_inicio = fecha_inicio;
	}

	public LocalDate getFecha_final() {
		return fecha_final;
	}

	public void setFecha_final(LocalDate fecha_final) {
		this.fecha_final = fecha_final;
	}

	public BigDecimal getPrecio() {
		return precio;
	}

	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}

	public Integer getNum_plazas_total() {
		return num_plazas_total;
	}

	public void setNum_plazas_total(Integer num_plazas_total) {
		this.num_plazas_total = num_plazas_total;
	}

	public Integer getNum_plazas_ocupada() {
		return num_plazas_ocupada;
	}

	public void setNum_plazas_ocupada(Integer num_plazas_ocupada) {
		this.num_plazas_ocupada = num_plazas_ocupada;
	}
	
	public BigDecimal getDuracionCurso() {
		Period periodo = getFecha_inicio().until(fecha_final);
		BigDecimal meses = new BigDecimal(periodo.getMonths() + periodo.getYears() * 12);
		return meses;
	}
	public Boolean isPlazasLibres() {
		if(num_plazas_ocupada >= num_plazas_total) {
			return false;
		} else {
			return true;
		}
	}
	public BigDecimal getPrecioMes() {
		return getPrecio().divide(getDuracionCurso());
	}

	@Override
	public String toString() {
		return "Curso [nombre=" + nombre + ", fecha_inicio=" + fecha_inicio + ", fecha_final=" + fecha_final
				+ ", precio=" + precio + ", num_plazas_total=" + num_plazas_total + ", num_plazas_ocupada="
				+ num_plazas_ocupada + "]";
	}
	
	
}
