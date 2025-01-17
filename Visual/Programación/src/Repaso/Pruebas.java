package Repaso;

public class Pruebas {

	public static void main(String[] args) {

		Caballo Caballo1 = new Caballo();

		Caballo1.setColor("Marron");

		System.out.println(Caballo1.getColor());

		Caballo1.setCarrerasGanadas(10);
		Caballo1.setEdad(2);

		Caballo1.incrementarCarrerasGanadas();
		Caballo1.relincha();
		Caballo1.setNombre("Bolita");
		System.out.println(Caballo1.getNombre());
		Caballo caballo2 = new Caballo("Fideo",4,"Blanco",20);
		Caballo caballo3 = new Caballo();
	}

}
