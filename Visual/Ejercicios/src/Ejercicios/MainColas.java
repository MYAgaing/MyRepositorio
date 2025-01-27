package Ejercicios;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainColas {
	private List<String> Cola;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		Cola cola1 = new Cola();
		
		sc.close();
	}

	public MainColas() {
		List<String> Cola = new ArrayList<>();
	}
	public void añadirCadenas(String cadena) {
		Cola.add(cadena);
	}

	public String sacarCadena() {
		return Cola.get(Cola.size() - 1);
	}

	public Integer getTamaño() {
		return Cola.size();
	}

	@Override
	public String toString() {
		return "ColaCadenas [ " + Cola + "]";
	}

}
