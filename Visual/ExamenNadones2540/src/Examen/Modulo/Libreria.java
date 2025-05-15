package Examen.Modulo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Libreria {

	private String nombre;
	private Map<String, Libro> libros;
	
	public Libreria() {
		libros = new HashMap<>();
	}

	public BigDecimal getTasacionCompleta() {
		BigDecimal total = BigDecimal.ZERO;
		for (Map.Entry<String, Libro> entry : libros.entrySet()) {
			total = total.add(entry.getValue().getPrecio());
		}
		return total;
	}

	public BigDecimal getPreciomedio() {
		return getTasacionCompleta().divide(new BigDecimal(libros.size()));
	}

	public List<Libro> getLibrosBaratos(){
		List<Libro> totalLibros = new ArrayList<>();
		for (Map.Entry<String, Libro> entry : libros.entrySet()) {
			if(entry.getValue().getPrecio().compareTo(BigDecimal.TEN) <= 10) {
				 totalLibros.add(entry.getValue());
			}
		}
		return totalLibros;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Map<String, Libro> getLibros() {
		return libros;
	}

	public void setLibros(Map<String, Libro> libros) {
		this.libros = libros;
	}

	@Override
	public int hashCode() {
		return Objects.hash(nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Libreria other = (Libreria) obj;
		return Objects.equals(nombre, other.nombre);
	}

}
