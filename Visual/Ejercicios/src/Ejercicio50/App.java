package Ejercicio50;

import java.util.HashSet;
import java.util.Set;

public class App {

	public static void main(String[] args) {
		
		Set<Pais> paises = new HashSet<>();
		Set<Pais> paises2 = new HashSet<>();
		System.out.println(paises);
		Pais España = new Pais("ES","España");
		Pais Islas_cook = new Pais("CK","Islas Cook");
		Pais Islas_Caiman = new Pais("CK","Islas_Caiman");
		paises.add(España);
		paises.add(Islas_Caiman);
		paises.add(Islas_cook);
		Pais España2 = new Pais("es","España2");
		paises.add(España2);
		for (Pais pais : paises) {
			if (!pais.getCodigo().equals("ES")) {
				paises2.add(pais);
			}
			paises = paises2;
		}
		System.out.println(paises);
		paises.clear();
		System.out.println(paises);
	}

}
