package App;

import java.sql.SQLException;
import java.util.Scanner;

import Modelo.Plantilla;
import Sevicios.DatosIncompletosException;
import Sevicios.PlantillaService;

public class app {

	public static void main(String[] args) throws SQLException, DatosIncompletosException {
		Scanner sc = new Scanner(System.in);
		/*
		 * System.out.println("Indica el DNI de la persona"); String vDNI =
		 * sc.nextLine(); PlantillaService service = new PlantillaService(); Plantilla p
		 * = service.consultarPersona(vDNI); try { if (p == null) {
		 * System.out.println("No existe usuario con dni " + vDNI); } else {
		 * System.out.println(p); } } finally { sc.close(); }
		 */
		PlantillaService service2 = new PlantillaService();

		Plantilla p2 = new Plantilla();
		System.out.println("Digame el dni");
		p2.setDni("11111111C");
		System.out.println("Digame el Nombre");
		p2.setNombre("Nano");
		System.out.println("Digame los apellidos");
		p2.setApellidos("Nini");
		System.out.println("Digame la fecha de nacimiento");
		String date = "10/01/1976";
		try {
			if (p2.validar(p2)) {
				try {
					service2.isertarPersona(p2,date);
				} catch (Exception e) {
					System.out.println("Error " + e);
				} finally {
					sc.close();
				}
			}
		} finally {
			sc.close();
		}

		do {
			
		}while(estrue);
		
	}

}
