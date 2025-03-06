package Libreria;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public abstract class Libreria {

	private List<Libros> libro;
	private String direccion;
	private Integer numtelefono;
	
	
	public Libreria() {
		this.libro = new ArrayList<>();
	}
	
	public Libros obtenerLibroMasAntiguo() {
		LocalDate masVieja = libro.getFirst().getFecha_edicion();
		for (Libros libros : libro) {
			if(libros.getFecha_edicion().isBefore(masVieja)) {
				masVieja = libros.getFecha_edicion();
			}
		}
		for (Libros libros : libro) {
			if(libros.getFecha_edicion().equals(masVieja)) {
				return libros;
			} 
			
		}
		return null;
		}

	
	public BigDecimal obtenerPesoTotal() {
		BigDecimal pesoTotal = new BigDecimal(0);
		for (Libros libros : libro) {
			if (libros.getIsFisico()) {
				pesoTotal.add(libros.getPeso());
			}
		}
		return pesoTotal;
		
	}
	}
	
