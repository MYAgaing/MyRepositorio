package Biblioteca;

import java.time.LocalDate;

public class Libros extends Publicaciones{
	
	private Boolean prestado;
	private Boolean consultado;

	public Libros(String codigo, String autor, String titulo, LocalDate año) {
		super( codigo,  autor,  titulo,  año);
		this.prestado = false;
		this.consultado = false;
	}

	@Override
	public String toString() {
		return "Libros [prestado=" + prestado + ", consultado=" + consultado + ", codigo=" + codigo + ", autor=" + autor
				+ ", titulo=" + titulo + ", año=" + año + "]";
	}
	
	
}
