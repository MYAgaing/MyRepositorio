package Ejercicio47;

import java.math.BigDecimal;

public class App {

	public static void main(String[] args) {
		
		Cliente cliente1 = new Cliente("123456x","Blas de los montes");
		Carrito carrito = new Carrito(cliente1);
		//System.out.println(carrito);
		BigDecimal num1 = new BigDecimal(30);
		Ropa ropa1 = new Ropa(num1,"Poncho","XL","Azul");
		carrito.addArticulo(ropa1);
		carrito.addArticulo(ropa1);
		System.out.println(carrito);
		Libros libro1 = new Libros();
		BigDecimal num = new BigDecimal(15);
		libro1.setPrecio(num);
		libro1.setDescripcion("Así habló Zaratustra");
		libro1.setAutor("Nietzche");
		carrito.addArticulo(libro1);
		carrito.borrarArticulo(1);
		System.out.println(carrito.precioMedio());
		carrito.vaciarCesta();
		System.out.println(carrito);
		System.out.println(carrito.precioMedio());
	}

}
