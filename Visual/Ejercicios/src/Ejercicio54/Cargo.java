package Ejercicio54;

public class Cargo extends Movimientos {

	private String CIF;

	@Override
	public String toString() {
		return "[C - " + fecha + " - " + importe + " - " + CIF + "]";
	}

	public String getCIF() {
		return CIF;
	}

	public void setCIF(String cIF) {
		CIF = cIF;
	}

	@Override
	public String tipoMovimiento() {
		return "C";

	}
}
