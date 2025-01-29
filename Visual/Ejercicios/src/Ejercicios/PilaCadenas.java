package Ejercicios;

import java.util.ArrayList;
import java.util.List;

public class PilaCadenas {
	private List<String> Cola;


	public PilaCadenas() {
		this.Cola = new ArrayList<>();
	}
	public void añadirCadenas(String cadena) {
		Cola.add(cadena);
	}

	public String sacarCadena() {
		System.out.println(Cola.getFirst());
		return Cola.removeFirst();
	}

	public Integer getTamaño() {
		return Cola.size();
	}

	@Override
	public String toString() {
		return "ColaCadenas  " + Cola ;
	}
	public List<String> getCola() {
		return Cola;
	}
	public void setCola(List<String> cola) {
		Cola = cola;
	}

	
}
