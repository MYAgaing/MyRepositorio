package Ejercicio51;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import console.console;

public class BigMoma {

	public static void main(String[] args) {
		List<BigDecimal> big = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		BigDecimal x1;
		for (int i = 0; i < 4; i++) {
			do {
				console.log("Digame un numero");
				Integer numero = sc.nextInt();
				x1 = new BigDecimal(numero);

				big.add(x1);
			} while (big.get(i).min(x1).equals(x1));
		}
		BigDecimal total = BigDecimal.ZERO;
		for (BigDecimal bigDecimal : big) {
			total = total.add(bigDecimal);
		}
		console.log(total);
		console.log(big.get(0).divide(big.get(1), 3, RoundingMode.HALF_UP));
		sc.close();

	}
}
