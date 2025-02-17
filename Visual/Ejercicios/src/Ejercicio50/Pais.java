package Ejercicio50;

import java.util.Objects;

public class Pais {
	
	private String codigo;
	private String descripcion;
	
	
	public Pais(String codigo,String descripcion) {
		this.codigo = codigo;
		this.descripcion = descripcion;
	}
	
	
	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}


	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	@Override
	public String toString() {
		return "Pais [descripcion= " + descripcion + ", Codigo = " + codigo +  " ]";
	}


	@Override
	public int hashCode() {
		return Objects.hash(codigo, descripcion);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (codigo.equalsIgnoreCase(codigo)) {
			return Objects.equals(codigo, codigo);
		}
		if (getClass() != obj.getClass())
			return false;
		Pais other = (Pais) obj;
		return Objects.equals(codigo, other.codigo);
	}

	
	
	
}
