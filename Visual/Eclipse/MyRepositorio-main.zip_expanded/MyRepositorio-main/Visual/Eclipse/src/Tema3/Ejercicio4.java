package Tema3;
import java.util.Scanner;

public class Ejercicio4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("¿Cuántos números vas a ingresar? ");
        int cantidad = scanner.nextInt();
        
        int[] numeros = new int[cantidad];

        for (int i = 0; i < cantidad; i++) {
            System.out.print("Introduce el número " + (i + 1) + ": ");
            numeros[i] = scanner.nextInt();
        }
        System.out.println("\nLos números ingresados en orden inverso son:");
        for (int i = cantidad - 1; i >= 0; i--) {
            System.out.println(numeros[i]);
        }

        scanner.close();
    }
}
