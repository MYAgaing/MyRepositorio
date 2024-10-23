package EclipseGit;
import java.util.Scanner;
public class OWO {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Digame una palabra");
		String palabra = sc.nextLine();
		while (true)
		if (palabra.length() < 8) {
			System.out.println("Minimo 8 caracteres");
		} else if (palabra.length() >= 8) {
			System.out.println("esta bien");
		}
	}

}
