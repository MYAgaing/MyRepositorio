package Examen.App;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import Examen.Modulo.Libreria;
import Examen.Modulo.Libro;

public class App {
	Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		
		solicitarLibreria();
		
		
	}

	public static Libreria solicitarLibreria() {
		Libreria libre1 = new Libreria();
		Map<String,Libro> mapa = new HashMap<>();
		libre1.setNombre("Paginas Desiertas");
		while(true) {
			System.out.println("Indique los datos del libro");
			String datos = sc.nextLine();
			if(datos.equalsIgnoreCase("FIN")) {
				break;
			}
			String[] lista = datos.split(";");
			BigDecimal precio = new BigDecimal(lista[3]);
			Libro l1 = new Libro(lista[0],lista[1],lista[2],precio);
			mapa.put(lista[0], l1);
		}
		return libre1;		
	}
}
