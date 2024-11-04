package EclipseGit;
import java.util.Scanner;
public class Ejercicio2 {

	public static void main(String[] args) {
			int año = 2024;
			
			Scanner scanner = new Scanner(System.in);
			System.out.println("Digame su año de nacimiento: ");
			
			int edad = scanner.nextInt();
			
			int suEdad = año - edad;
			
			System.out.println(suEdad);
			
	}

}
