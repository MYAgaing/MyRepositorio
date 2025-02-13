package Ejercicio47;

public class Articulos {

	private String descripcion;
	private Integer precio;
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Integer getPrecio() {
		return precio;
	}
	public void setPrecio(Integer precio) {
		this.precio = precio;
	}
	@Override
	public String toString() {
		return "Articulos [descripcion=" + descripcion + ", precio=" + precio + "]";
	}
	
	
}
