package EclipseGit; 
import java.util.Scanner;
public class Ejercicio16 {

	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		/*String palabra = sc.nextLine();
		int contador;
		for (contador = 0 ; contador < palabra.length() ; contador++) {
			System.out.println(palabra.charAt(contador));
		}*/
		//Ejercicio 17
		for ( int i = 0 ; i == 0 ; i++) {
		int numero = sc.nextInt();
		int num1 = 0;
		int num2 = 1;
		 System.out.print(num1 + " ");
		 System.out.print(num2 + " ");
		if (numero < 2) {
			System.out.println("Por favor repitalo");
			numero = sc.nextInt();
		} else if (numero > 2) {
			int num3 = num1 + num2;
			for (int j = 0 ; j < numero ; j++) {
				 
				 num3 += num3;
				 System.out.print(num3 + " ");
				 }
			}
		 
		}
		sc.close();
	}

}
