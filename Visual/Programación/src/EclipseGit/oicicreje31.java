package EclipseGit;

import java.util.Scanner;

public class oicicreje31 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String frase;
		String contador = "";
		while (true) {
			System.out.println("Escriba una frase(Fin para terminar):");
			frase = sc.nextLine();
			
			if (frase.equalsIgnoreCase("FIN")) {
				break;
			}
			
			contador += frase ;
		}
		System.out.println(contador);
		
		sc.close();
		}
	}
