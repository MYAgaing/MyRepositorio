package Ejercicio54;

public class Retiradas extends Movimientos{
	
	

	@Override
	public String toString() {
		return "[R - " + fecha + " - " + importe + "]";
	}

	@Override
	public String tipoMovimiento() {
		
		return "R";
	}


	
	
}
