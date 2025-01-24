package Semaforo;

public class Semaforo {
	public static final String ROJO = "ROJO";
	public static final String VERDE = "VERDE";
	public static final String AMBAR = "AMBAR";

	private String color;
	private Boolean parpadear;
	
	
	public Semaforo(){
		color = ROJO;
		parpadear = false;
	}


	public String getColor() {
		return color;
	}


	public void setColor(String color) {
		this.color = color;
	}


	public Boolean getParpadear() {
		return parpadear;
	}


	public void setParpadear(Boolean parpadear) {
		this.parpadear = parpadear;
	}
	public void setColor2(String color) {
		if (color.equals(ROJO) || color.equals(AMBAR) || color.equals(VERDE)) {
			this.color = color;
		}
	}
	public void setParpadeando(Boolean parpadear) {
		if (parpadear && !color.equals(AMBAR)) {
			return;
		}
		this.parpadear = parpadear;
	}


	@Override
	public String toString() {
		String mensaje = "Semaforo en " + color;
		if (parpadear) {
			return mensaje  += " parpadeando";
		}
		return mensaje;
	}
	
	
}

