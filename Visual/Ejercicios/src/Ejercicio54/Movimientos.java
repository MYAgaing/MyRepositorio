package Ejercicio54;

import java.math.BigDecimal;
import java.time.LocalDate;

public abstract class Movimientos {	

	protected LocalDate fecha;
	protected BigDecimal importe;

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public abstract String tipoMovimiento();

	public BigDecimal getImporte() {
		return importe;
	}

	public void setImporte(BigDecimal importe) {
		this.importe = importe;
	}
	

	
}
