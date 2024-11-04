package EclipseGit;
import java.util.Scanner;

public class Ejercicio1 {

	public static void main(String[] args) {
			System.out.print("main");
			Scanner scanner = new Scanner(System.in);
			System.out.println("Indique su nombre :");
			String Usuario = scanner.nextLine();
			System.out.println("Indique su apellido :");
			String Apellido = scanner.nextLine();
			System.out.print("Tu nombre compreto es :" + Usuario + " " + Apellido);
			
	}

}
