package Telefonos;

public class Telefonos {

	protected Integer numero;
	protected Boolean enLlamada;
	
	public Integer consultarNumero() {
		return numero;
	}
	
	public void marcar(Integer numero) {
		System.out.println("Llamando a..." + numero);
		if(numero.equals(numero)) {
			System.out.println("COMUNICANDO...");
		} else {
			System.out.println("En comunicacion...");
			this.enLlamada = true;
		}
	}
	public void colgar() {
		if (enLlamada) {
			System.out.println("Comunicacion terminada");
			enLlamada = false;
		}
	}
	
}
