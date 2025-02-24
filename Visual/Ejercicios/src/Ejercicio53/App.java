package Ejercicio53;

import java.math.BigDecimal;

public class App {

	public static void main(String[] args) {
		
		Hucha hucha1 = new Hucha();
		System.out.println(hucha1);
		hucha1.meterDinero(new BigDecimal(100));
		System.out.println(hucha1);
		hucha1.meterDinero(new BigDecimal(50.501));
		System.out.println(hucha1);
		hucha1.sacarDinero(new BigDecimal(20.5));
		System.out.println(hucha1);
		hucha1.sacarDinero(new BigDecimal(200));
		System.out.println(hucha1);
		hucha1.meterDinero(new BigDecimal(200));
		System.out.println(hucha1);
		BigDecimal resultados = hucha1.contarDinero();
		hucha1.meterDinero(resultados);
		System.out.println(hucha1);
		BigDecimal rotos = hucha1.romperoHucha();
		hucha1.meterDinero(rotos);
		System.out.println(hucha1);
		
	}

}
