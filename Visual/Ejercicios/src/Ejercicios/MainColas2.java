package Ejercicios;

public class MainColas2 {

	public static void main(String[] args) {
		
		PilaCadenas pila2 = new PilaCadenas();
		System.out.println(pila2);
		pila2.añadirCadenas("Primero");
		pila2.añadirCadenas("Segundo");
		System.out.println(pila2);
		String elemento = pila2.sacarCadena();
		System.out.println(elemento);
		pila2.añadirCadenas("Tercero");
		System.out.println(pila2);
		for (String string : args) {
			System.out.println(string);
			pila2.sacarCadena();
		}
		pila2.añadirCadenas("Cuarto");
		System.out.println(pila2);
	}

}
