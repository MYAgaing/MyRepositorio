package Gourmet.App;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import Gourmet.Modulo.Producto;
import Gourmet.Service.GourmetService;

public class App {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try {
			GourmetService service = new GourmetService();
			System.out.println("Introduzca tres productos");
			List<Producto> lista = new ArrayList<>();
			/*
			 * Parte1
			 */
			for (int i = 0; i < 3; i++) {
				System.out.println("Digame el id");
				Integer id = sc.nextInt();
				sc.next();
				System.out.println("Digame el nombre");
				String nombre = sc.nextLine();
				System.out.println("Digame el tipo");
				String tipo = sc.nextLine();
				System.out.println("Digame el precio");
				BigDecimal precio = sc.nextBigDecimal();
				System.out.println("Digame si esta disponible(S/N)");
				Boolean disponible = null;
				if (sc.nextLine().equalsIgnoreCase("S")) {
					disponible = true;
				} else if (sc.nextLine().equalsIgnoreCase("N")) {
					disponible = false;
				}
				Producto p = new Producto(id, nombre, tipo, precio, disponible);
				lista.add(p);
			}
			service.insertarProductos(lista);
			/*
			 * Parte 2
			 */
			System.out.println("¿Que tipo de producto desea ver?");
			String tipo = sc.nextLine();
			List<Producto> lista2 = service.consultaTipoProductos(tipo);
			System.out.println("*** Productos de tipo " + tipo + " ***");
			BigDecimal total = null;
			for (Producto producto : lista2) {
				System.out.println(producto);
				total = total.add(producto.getPrecio());
			}
			BigDecimal redondeado = total.setScale(2, RoundingMode.HALF_DOWN);
			System.out.println("TOTAL DE PRODUCTOS DE TIPO " + tipo + ": " + redondeado );
			/*
			 * Parte 3
			 */
			Map<Integer, Producto> mapa = service.consultarProductosDisponibles();
			String nombre = null;
			BigDecimal mayor = BigDecimal.ZERO;
			for (Map.Entry<Integer, Producto> entry : mapa.entrySet()) {
				if (mayor.compareTo(entry.getValue().getPrecio()) == 1) {
					nombre = entry.getValue().getNombre();
					mayor = entry.getValue().getPrecio();
				}
			}
			System.out.println("El producto mas caro es " + nombre + " siendo " + mayor );
			/*
			 * Parte 4
			 */
			Map<Integer, Producto> mapa2 = service.consultarProductosDisponibles();
			Producto p = mapa2.get(5);
			if(p == null) {
				System.out.println("El producto no existe");
			} else {
				System.out.println(p);
			}
			/*
			 * Parte 5 
			 */
			System.out.println("Digame el id del producto a eliminar");
			service.eliminarProducto(sc.nextInt());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			sc.close();
		}
	}

}
