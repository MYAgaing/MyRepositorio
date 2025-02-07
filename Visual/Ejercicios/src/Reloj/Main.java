package Reloj;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		Reloj reloj1 = new Reloj();
		
		System.out.println("diga la hora");
		
		Integer hora = sc.nextInt();
		
		System.out.println("diga los minutos");
		
		Integer minuto = sc.nextInt();
		
		System.out.println("Diga los segundo");
		
		Integer segundo = sc.nextInt();
		
		reloj1.ponerHora(hora, minuto, segundo);
		
		reloj1.setFormato24hora(false);
		
		reloj1.ponerHora(24, 17);
		reloj1.ponerHora(21, 82);
		reloj1.ponerHora(17, 16, 15);
		Reloj reloj2 = new Reloj(17, 16, 15);
		System.out.println(reloj1.equals(reloj2));
		;
		sc.close();
	}

}
