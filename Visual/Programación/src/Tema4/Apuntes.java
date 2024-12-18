package Tema4;

public class Apuntes {

	public static void main(String[] args) {
		Integer base = 1;
		Double altura = 2.0;
		Double num3;
		num3 = suma(base, altura);
		System.out.println(num3);
	}
	public static Double suma(Integer base, Double altura) {
		return base / (altura * altura);
	}
}
