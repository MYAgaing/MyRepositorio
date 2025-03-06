package Libreria;

import java.math.BigDecimal;
import java.time.LocalDate;

public abstract class Libros {

	private String titulo;
	private String autor;
	private LocalDate fecha_edicion;
	private Integer numpaginas;
	protected Boolean isFisico;
	protected BigDecimal peso;
	
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public LocalDate getFecha_edicion() {
		return fecha_edicion;
	}
	public void setFecha_edicion(LocalDate fecha_edicion) {
		this.fecha_edicion = fecha_edicion;
	}
	public Integer getNumpaginas() {
		return numpaginas;
	}
	public void setNumpaginas(Integer numpaginas) {
		this.numpaginas = numpaginas;
	}
	public Boolean getIsFisico() {
		return isFisico;
	}
	public void setIsFisico(Boolean isFisico) {
		this.isFisico = isFisico;
	}
	public BigDecimal getPeso() {
		return peso;
	}
	public abstract BigDecimal setPeso();
	
	
}
