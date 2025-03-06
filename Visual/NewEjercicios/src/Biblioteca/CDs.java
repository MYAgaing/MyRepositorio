package Biblioteca;

import java.time.LocalDate;

public class CDs extends Publicaciones{
	
	private Boolean prestado;

	public CDs(String codigo, String autor, String titulo, LocalDate año) {
		super( codigo,  autor,  titulo,  año);
		this.prestado = false;
	}

	@Override
	public String toString() {
		return "CDs [prestado=" + prestado + ", codigo=" + codigo + ", autor=" + autor + ", titulo=" + titulo + ", año="
				+ año + "]";
	}
	
}
