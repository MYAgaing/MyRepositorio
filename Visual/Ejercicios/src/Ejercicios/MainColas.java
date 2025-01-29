package Ejercicios;

public class MainColas {

	public static void main(String[] args) {


		PilaCadenas pila = new PilaCadenas();
		System.out.println(pila);
		pila.añadirCadenas("Primero");
		pila.añadirCadenas("Segundo");
		System.out.println(pila);
		System.out.println(pila.sacarCadena());
		pila.añadirCadenas("Tercero");
		System.out.println(pila);
		pila.añadirCadenas("Cuarto");
	}

}
