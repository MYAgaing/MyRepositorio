package Juego;

public class App {

	public static void main(String[] args) {
		
		Asesino asesino1 = new Asesino();
		Asesino asesino2 = new Asesino();
		Asesino asesino3 = new Asesino();
		Parasito parasito1 = new Parasito();
		Tropa tropa1 = new Tropa();
		tropa1.add(asesino1);
		tropa1.add(asesino2);
		tropa1.add(asesino3);
		Jugador jugador1 = new Jugador();
		jugador1.add(tropa1);
		Parasito parasito2 = new Parasito();
		parasito2.setNombre("Blas");
		parasito2.setCodigo(B69);
		System.out.println(parasito2 + " quita 2 de vida por segundo");
		tropa1.add(parasito2);
		System.out.println(totalVida(tropa1));
		tropa1.add(parasito2);
		System.out.println(tropa1);
		Parasito parasito3 = new Parasito();
		Parasito parasito4 = new Parasito();
		tropa1.add(parasito3);
		tropa1.add(parasito4);
		System.out.println(totalVida(tropa1));
	}
	
	public Integer totalVida(Tropa tropa) {
		for(i = 0 ; i < tropa.size();i++) {
			integer vidatotal += tropa[i].getVida;
		}
		return vidatotal;
	}

}
