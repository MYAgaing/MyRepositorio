package Excepciones3;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class SacoNumeros {

	private List<Integer> numeros;

	Scanner sc = new Scanner(System.in);

	public SacoNumeros() {
		this.numeros = new ArrayList<>();
	}

	public void addNumero(Integer num) {
		numeros.add(num);
	}

	public Integer getNumero(Integer num) {
		try {
			return numeros.get(num);
		} catch (IndexOutOfBoundsException ecx1) {
			return null;
		} catch(InputMismatchException exc2) {
		return null;
		}
	}
	public BigDecimal division() {
		Integer i = 0;
		for (i = 0; i < numeros.size(); i++) {
			numeros.add(numeros.get(i)/numeros.get(i+1));
		}
		return numeros.get(new BigDecimal(numeros.size()-1)));
	}

	@Override
	public String toString() {
		return numeros.toString();
	}

}
