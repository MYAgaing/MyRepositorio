package Ejercicio54;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class CuentaAhorros {

	private String numero;
	private List<Movimientos> movimiento;
	private BigDecimal dinero;

	public CuentaAhorros(String numero) {
		if (numero.length() == 20) {
			this.numero = numero;
		} else {
			System.out.println("Tiene que se de 20 digitos");
		}
		this.movimiento = new ArrayList<>();
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public List<Movimientos> getMovimiento() {
		return movimiento;
	}

	public void setMovimiento(List<Movimientos> movimiento) {
		this.movimiento = movimiento;
	}

	public void MovimientoCuenta(Movimientos x) {

		movimiento.add(x);
	}

	public BigDecimal getDinero() {
		return dinero;
	}

	public void setDinero(BigDecimal dinero) {
		this.dinero = dinero;
	}

	@Override
	public String toString() {
		return "CuentaAhorros [numero=" + numero + ", movimiento=" + movimiento + ", dinero=" + dinero + "]";
	}

	public void añadirMovimientos(Movimientos mov) {
		movimiento.add(mov);
	}

	public void ingresar() {

	}

	public BigDecimal getTotal() {
		BigDecimal saldoTotal = BigDecimal.ZERO;
		for (Movimientos movimientos : movimiento) {
			if (movimientos.tipoMovimiento().equals("I")) {
				saldoTotal = saldoTotal.add(movimientos.getImporte());
			} else {
				saldoTotal = saldoTotal.subtract(movimientos.getImporte());
			}
		}
		return saldoTotal.setScale(2, RoundingMode.HALF_DOWN);
	}

	public void mostrar() {
		for (Movimientos movimientos : movimiento) {
			System.out.println(movimientos);
		}
	}

	public void mostrarRetirarad() {
		for (Movimientos movimientos : movimiento) {
			if (movimientos.tipoMovimiento().equals("R")) {
				System.out.println(movimientos);
			}
		}
	}
	public List<String> mostrarCargos() {
		List<String> resultado = new ArrayList<>();
		for (String movimientos : movimiento) {
			if (movimientos.tipoMovimiento().equals("C")) {
				resultado.add(movimientos);
			} else {
				 System.out.println("No hay");
			}
		}
	}
	public void mostrarIngresos() {
		for (Movimientos movimientos : movimiento) {
			if (movimientos.tipoMovimiento().equals("I")) {
				System.out.println(movimientos);
			} else {
				 System.out.println("No hay");
			}
		}
	}

}
