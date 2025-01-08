package Tema4;

public class Ejercicio6 {

	public static void main(String[] args) {
		int num1 = 1;
		int num2 = 1;
		int sum = Calculadora(num1,num2);
		System.out.println(sum);
	}

	public static int Calculadora(int num1, int num2) {
		return Ejercicio5.suma(num1, num2);
	}
}
