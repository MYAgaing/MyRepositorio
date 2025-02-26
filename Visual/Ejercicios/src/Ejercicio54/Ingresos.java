package Ejercicio54;

public class Ingresos extends Movimientos{

	

	private String descripcion;

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "[I - " + fecha + " - " + importe + " - " + descripcion + "]";
	}

	@Override
	public String tipoMovimiento() {
		
		return "I";
	}
	
	
}
