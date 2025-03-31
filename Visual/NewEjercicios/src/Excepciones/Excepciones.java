package Excepciones;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Excepciones {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		try {
			List<Integer> lista = new ArrayList<>();
			Integer num = 0;
			do {
				System.out.println("dame un numero");
				num = sc.nextInt();
				if(!num.equals(-1)) {
					lista.add(num);
				}
				
			} while(!num.equals(-1));
			System.out.println("Lista " + lista);
		} finally {
			sc.close();
			System.out.println("Scanner cerrado correctamente");
		}
		sc.close();
	}

}
