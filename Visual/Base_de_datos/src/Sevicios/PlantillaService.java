package Sevicios;

import Modelo.Plantilla;

public class PlantillaService {

	private OpenConnection openConn;
	
	public PlantillaService() {
		openConn = new OpenConnection();
		System.out.println("Conexcion establecida");
	}
	public Plantilla consultarPersona(Plantilla plantilla1) {
		return plantilla1;
	}
	
}
