package EclipseGit;
import java.util.Scanner;
public class ejercicio3 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Cuanto le gustaria cobrar?");
		
		int sueldo = scanner.nextInt();
		
		int mes = sueldo / 12;
		
		System.out.println("Usted cobraria al mes " + mes);
	}

}
