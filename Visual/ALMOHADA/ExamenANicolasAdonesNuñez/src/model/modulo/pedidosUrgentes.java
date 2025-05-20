package model.modulo;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

import model.services.EstadoIncorrectoexception;

public class pedidosUrgentes extends Pedido {

	public pedidosUrgentes(Integer numero) {
		super(numero);

	}

	public LocalDate getFechaEntregaPrevista() {
		LocalDate nuevaFecha = getFecha_pedido().plusDays(1);
		return nuevaFecha;

	}

	@Override
	public BigDecimal getImporteTotal() throws EstadoIncorrectoexception {
		if (getEntregado() == true) {
			throw new EstadoIncorrectoexception("El estado del pedido es incorrecto");
		} else {
			if (getFechaEntregaPrevista().isBefore(getFecha_pedido())) {
				setImporte(BigDecimal.ZERO);
			} else {
				double total = getImporte().intValue();
				total = total * 0.10;
				BigDecimal nuevo = getImporte().add(new BigDecimal(total));
				return nuevo.setScale(2, RoundingMode.HALF_DOWN);
			}
		}
		return null;
	}

}
