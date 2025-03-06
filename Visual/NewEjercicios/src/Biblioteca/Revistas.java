package Biblioteca;

import java.time.LocalDate;

public class Revistas extends Publicaciones{
	
	private Boolean consultado;

	public Revistas(String codigo, String autor, String titulo, LocalDate año) {
		super( codigo,  autor,  titulo,  año);
		this.consultado = false;
	}

	@Override
	public String toString() {
		return "Revistas [consultado=" + consultado + ", codigo=" + codigo + ", autor=" + autor + ", titulo=" + titulo
				+ ", año=" + año + "]";
	}
	
	
}
