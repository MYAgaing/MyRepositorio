package Telefonos;

import java.math.BigDecimal;

public class App {

	public static void main(String[] args) {
		
		Fijo fijo1 = new Fijo(954954954,"Calle La Mancha");
		Movil movil1 = new Movil(654654654,new BigDecimal(100),new BigDecimal(200));
		fijo1.consultarNumero();
		movil1.consultarNumero();
		movil1.marcar(654654654);
		fijo1.marcar(610610610);
		movil1.colgar();
		movil1.colgar();
	}

}
