package Ejercicios;

import java.util.ArrayList;
import java.util.List;

public class PilaCadenas2 {
	private List<String> Cola2;
	
	
	
	public PilaCadenas2(){
		this.Cola2 = new ArrayList<>();
	}
	public void añadirCadenas(String cadena) {
		Cola2.add(cadena);
	}

	public String sacarCadena() {
		Cola2.removeLast();
		return Cola2.getLast();
	}
	public Integer getTamaño() {
		return Cola2.size();
	}
	@Override
	public String toString() {
		return "PilaCadenas2 "+ Cola2 ;
	}
	
}
