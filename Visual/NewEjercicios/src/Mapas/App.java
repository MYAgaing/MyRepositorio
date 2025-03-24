package Mapas;

import java.math.BigDecimal;

public class App {

	public static void main(String[] args) {
		
		Evaluacion evaluacion1 = new Evaluacion();
		evaluacion1.addNota("1", new BigDecimal(5));
		evaluacion1.addNota("2", new BigDecimal(7));
		evaluacion1.addNota("3", new BigDecimal(2));
		evaluacion1.addNota("4", new BigDecimal(3));
		evaluacion1.addNota("5", new BigDecimal(9));
		System.out.println(evaluacion1);
		evaluacion1.addNota("1", new BigDecimal(5));
		evaluacion1.corregirNota("2", new BigDecimal(8));
		System.out.println(evaluacion1);
		System.out.println(evaluacion1.NotaAlumno("1"));
		System.out.println(evaluacion1.NotaMedia());
		
	}

}
