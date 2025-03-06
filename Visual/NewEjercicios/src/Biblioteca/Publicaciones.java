package Biblioteca;

import java.time.LocalDate;

public class Publicaciones {

	protected String codigo;
	protected String autor;
	protected String titulo;
	protected LocalDate año;
	
	public Publicaciones(String codigo, String autor, String titulo, LocalDate año) {
		this.codigo = codigo;
		this.autor = autor;
		this.titulo = titulo;
		this.año = año;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public LocalDate getAño() {
		return año;
	}

	public void setAño(LocalDate año) {
		this.año = año;
	}
	
}
