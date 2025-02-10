package Juego;

import java.util.ArrayList;
import java.util.List;

public class EquipoCombate {
	private List<Personaje> tropa;
	private Integer puntosVida;

	public EquipoCombate() {
		this.tropa = new ArrayList<>();
		puntosVida = 0;
	}

	public List<Personaje> getTropa() {
		return tropa;
	}

	public void setTropa(List<Personaje> tropa) {
		this.tropa = tropa;
	}

	public Integer getPuntosVida() {
		return puntosVida;
	}

	public void setPuntosVida(Integer puntosVida) {
		this.puntosVida = puntosVida;
	}

	public void añadirPersonaje(Personaje personaje) {
		if (tropa.size() < 5 && !tropa.contains(personaje)) {
			tropa.add(personaje);
			puntosVida += personaje.getVida();
		}
	}
}
