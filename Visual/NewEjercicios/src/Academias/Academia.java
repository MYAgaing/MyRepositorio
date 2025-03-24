package Academias;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Academia{

	private String Ciudad;
	private String telefono;
	private List<Curso> recursos;
	
	public Academia() {
		
	}

	public String getCiudad() {
		return Ciudad;
	}

	public void setCiudad(String ciudad) {
		Ciudad = ciudad;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public List<Curso> getRecursos() {
		return recursos;
	}

	public void setRecursos(List<Curso> recursos) {
		this.recursos = recursos;
	}
	
	public List<Curso> getCursosDisponibles(List<Curso> lista){
		List<Curso> cursos = new ArrayList<>();
		LocalDate fecha = LocalDate.now();
		for (Curso curso : lista) {
			Integer i = 0;
			if(lista.get(i).isPlazasLibres() && fecha.isBefore(curso.getFecha_final())) {
				cursos.add(curso);
			}
			i++;
		}
		return lista;
	}
	public BigDecimal getPrecioMedio(String x) {
		Integer i = 0;
		for (Curso curso : recursos) {
			if (curso.getNombre().equalsIgnoreCase(x)) {
				return curso.getPrecioMes();
			}
		}
		return null;
		
	}
	public void borrarCursosPasados() {
		LocalDate fecha = LocalDate.now();
		for (Curso curso : recursos) {
		if (curso.getFecha_final().isAfter(fecha)) {
			recursos.remove(curso);
		}
		}
	}
	public Curso getCursoMasBarato(List<Curso> lista) {
		
		BigDecimal masBarato = recursos.getFirst().getPrecio();
		LocalDate fecha = LocalDate.now();
		for (Curso curso : lista) {
			if(fecha.isBefore(curso.getFecha_inicio())) {
				if(curso.getPrecio().max(masBarato).equals(masBarato)) {
					masBarato = curso.getPrecio();
				}
			}
		}
		for (Curso curso : lista) {
			if (curso.getPrecio().equals(masBarato)){
				return curso;
			}
		}
		return null;
	}
	public Integer getTotalPlazasTotales() {
		Integer total = 0;
		for (Curso curso : recursos) {
			total = curso.getNum_plazas_total() - curso.getNum_plazas_ocupada();
			total += total;
		}
		return total;
	}

	@Override
	public String toString() {
		return "Academia [Ciudad=" + Ciudad + ", telefono=" + telefono + ", recursos=" + recursos + "]";
	}
	
}
