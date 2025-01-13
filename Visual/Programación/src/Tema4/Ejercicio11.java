package Tema4;

public class Ejercicio11 {

	public static void main(String[] args) {
		
		String[] array = new String[] {"hola","adios"};
		Integer numero = buscarPalabra(array, "adios");
			System.out.println(numero);
	}
	
	public static Integer buscarPalabra(String[] array, String cad) {
		
		for (int i = 0; i < array.length; i++) {
			if(array[i].equalsIgnoreCase(cad)) {
				return i;
			}
		}
		
		return -1;
		
	}

}
