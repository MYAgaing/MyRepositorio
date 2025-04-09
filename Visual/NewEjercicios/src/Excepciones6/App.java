package Excepciones6;

import java.math.BigDecimal;

public class App {

	public static void main(String[] args){
		Persona persona1 = new Persona();
		try {
		persona1.setGenero("a");
		persona1.setAltura(new BigDecimal(2));
		} catch (ParametroIncorrectoException e) {
			System.out.println(e.getMessage());
		}
		System.out.println(persona1);
		
	}

}
