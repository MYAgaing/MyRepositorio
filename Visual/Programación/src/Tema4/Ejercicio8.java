package Tema4;

public class Ejercicio8 {
	public static final String add = "add";
	public static final String rest = "rest";
	public static final String mul = "mul";
	public static final String div = "div";

	public static void main(String[] args) {

		System.out.println(calcular(1,1,add));
		System.out.println(calcular(1,1,rest));
		System.out.println(calcular(1,1,mul));
		System.out.println(calcular(1,1,div));
	}

	

	public static int calcular(int num1, int num2, String cad) {
		if (cad == "add") {
			return Ejercicio7.suma(num1, num2);
		} else if (cad == "rest") {
			return Ejercicio7.restar(num1, num2);
		} else if (cad == "mul") {
			return Ejercicio7.multiplicar(num1, num2);
		} else if (cad == "div") {
			return Ejercicio7.dividir(num1, num2);
		}
		return 0;
	}
}
