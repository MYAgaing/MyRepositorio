package LocalDate;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Fechas {

	LocalDate fecha = LocalDate.now();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 1
		Boolean igualFecha = true;
		Integer año;
		Integer mes;
		Integer dia;
		LocalDate fechaCumpleaños = LocalDate.of(2002, 4, 15);
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("DD/HH/YYYY HH/MM/SS");
		LocalDate fecha;
		do {
			System.out.println("Digame el año de nacimiento");
			año = sc.nextInt();
			System.out.println("Digame el mes de nacimiento");
			mes = sc.nextInt();
			System.out.println("Digame el dia de nacimiento");
			dia = sc.nextInt();
			fecha = LocalDate.of(año, mes, dia);

			if (fecha.isEqual(fechaCumpleaños)) {
				System.out.println("Son iguales");
				igualFecha = false;
			} else {
				System.out.println("No son iguales");
			}
		} while (igualFecha);

		// 2
		Boolean bisiesto = fecha.isLeapYear();
		if (bisiesto) {
			System.out.println("Cumples en año bisiesto");
		} else {
			System.out.println("No cumples en año bisiesto");
		}
		// 3
		System.out.println("tu dia de nacimiento " + fecha.getDayOfWeek());
		// 4
		LocalDate fechaActual = LocalDate.now();
		Period period = fecha.until(fechaActual);
		System.out.println("Tienes " + period.getYears() + " años");
		// 5
		System.out.println("Viviras " + (100 - period.getYears() + " años" + "/" + period.getMonths() + " meses" + "/"
				+ period.getDays() + " dias"));
		// 6
		DateTimeFormatter formatto = DateTimeFormatter.ofPattern("HH:mm:ss");
		LocalTime hora = LocalTime.now();
		System.out.println("Hora actual " + formatto.format(hora));
		
		sc.close();
	}

}
