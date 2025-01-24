package Ejercicios;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Arrays2 {
	static List<String> listaCadenas = new ArrayList<>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		
		for (int i = 0; i < 5; i++) {
			System.out.println("Diga una palara");
			String palabra = sc.nextLine();
			listaCadenas.add(palabra);
		}
		sc.close();
	}

	@Override
	public String toString() {
		for (int i = 0; i <  listaCadenas.size(); i++) {
			return listacadena;
		}
	}

	
}
