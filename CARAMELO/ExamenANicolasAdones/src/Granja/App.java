package Granja;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class App {

	public static void main(String[] args) {
		
		Granja granja1 = new Granja("Sevilla");
		System.out.println(granja1);
		Cerdos cerdo1 = new Cerdos(1);
		cerdo1.setRaza("Iberico bellota");
		Cerdos cerdo2 = new Cerdos(2);
		cerdo2.setRaza("Iberico cebo");
		Pollos pollo3 = new Pollos(3);
		Pollos pollo4 = new Pollos(4);
		Pollos pollo5 = new Pollos(5);
		granja1.addAnimal(cerdo1);
		granja1.addAnimal(cerdo2);
		granja1.addAnimal(pollo3);
		granja1.addAnimal(pollo4);
		granja1.addAnimal(pollo5);
		System.out.println(granja1);
		cerdo1.setPeso(new BigDecimal(120.4));
		cerdo1.setFecha_nacimiento(LocalDate.of(2024, 1, 15));
		cerdo2.setPeso(new BigDecimal(84));
		pollo3.setFecha_nacimiento(cerdo1.getFecha_nacimiento().plusMonths(3));
		pollo4.setFecha_nacimiento(cerdo1.getFecha_nacimiento().plusMonths(3));
		pollo5.setFecha_nacimiento(cerdo1.getFecha_nacimiento().plusMonths(3));
		pollo3.setPeso(new BigDecimal(3));
		pollo4.setPeso(new BigDecimal(3));
		pollo5.setPeso(new BigDecimal(13));
		System.out.println(granja1);
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String fecha = pollo3.getFecha_nacimiento().format(formato);
		System.out.println(fecha);
		System.out.println(pollo3.getEdad() + " meses");
		DecimalFormat formato2 = new DecimalFormat("#,###.##€");
		System.out.println(formato2.format(granja1.calcularPrecioVenta()));
		granja1.venderAnimales();
		System.out.println(granja1);
	}

}
