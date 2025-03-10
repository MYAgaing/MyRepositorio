package Granja;

public class Cerdos extends Animales{
	
	private String raza;
	
	public Cerdos(Integer num_registro) {
		super(num_registro);
		this.tipo = false;
	}

	public String getRaza() {
		return raza;
	}

	public void setRaza(String raza) {
		this.raza = raza;
	}
	
	
	
}
