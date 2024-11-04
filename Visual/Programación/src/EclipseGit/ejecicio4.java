package EclipseGit;
import java.util.Scanner;

public class ejecicio4 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Indique su año de nacimiento: ");
		int nacimiento = scanner.nextInt();
		String generacion;
		if (nacimiento > 1883) {
			System.out.println("Generacion perdida");
		}
		else if (nacimiento < 1900) {
			System.out.println("Generacion perdida");
		}
		else if (nacimiento > 1901) {
			System.out.println("Generacion Grandiosa");
		}
		else if (nacimiento < 1927) {
			System.out.println("Generacion Grandiosa");
		}
		else if (nacimiento > 1928) {
			System.out.println("Generacion silenciosa");
		}
		else if (nacimiento > 1945) {
			System.out.println("Generacion silencioas");
		}
		else if (nacimiento < 1929) {
			System.out.println("Generac");
		}
		else if (nacimiento > 1945) {
			System.out.println("Generacion Grandiosa");
		}
		
		scanner.close();
	}
}
