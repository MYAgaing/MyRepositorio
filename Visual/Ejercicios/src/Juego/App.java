package Juego;

public class App {

	public static void main(String[] args) {
		
		Asesino asesino1 = new Asesino();
		Asesino asesino2 = new Asesino();
		Asesino asesino3 = new Asesino();
		Parasito parasito1 = new Parasito();
		Jugador jugador1 = new Jugador();
		jugador1.setNombre("teamBlas");
		EquipoCombate equipo = new EquipoCombate();
		jugador1.setEquipo_de_combate(equipo);
		equipo.añadirPersonaje(asesino1);
		equipo.añadirPersonaje(asesino2);
		equipo.añadirPersonaje(asesino3);
		jugador1.setEquipo_de_combate(equipo);
		Parasito parasito2 = new Parasito();
		parasito2.setNombre("Blas");
		parasito2.setCodigo("B69");;
		System.out.println(parasito2 + " quita 2 de vida por segundo");
		equipo.añadirPersonaje(parasito2);
		System.out.println(jugador1.getEquipo_de_combate().getPuntosVida());
		equipo.añadirPersonaje(parasito2);
		System.out.println(equipo);
		Parasito parasito3 = new Parasito();
		Parasito parasito4 = new Parasito();
		jugador1.getEquipo_de_combate().añadirPersonaje(parasito3);
		jugador1.getEquipo_de_combate().añadirPersonaje(parasito4);
		System.out.println(jugador1.getEquipo_de_combate().getPuntosVida());
	}

}
