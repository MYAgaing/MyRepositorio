package Telefonos;

public class Movil extends Telefonos {

	private LocalizacionGPS localizacion;
	
	public Movil(Integer numero) {
		this.numero = numero;
		this.enLlamada = false;
	}

	public LocalizacionGPS getLocalizacion() {
		return localizacion;
	}

	public void setLocalizacion(LocalizacionGPS localizacion) {
		this.localizacion = localizacion;
	}
	
	
}
