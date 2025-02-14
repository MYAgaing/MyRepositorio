package Ejercicio47;

public class App {

	public static void main(String[] args) {
		
		Cliente cliente1 = new Cliente("123456x","Blas de los montes");
		Carrito carrito = new Carrito(cliente1);
		//System.out.println(carrito);
		Ropa ropa1 = new Ropa(20,"Poncho","XL","Azul");
		carrito.addArticulo(ropa1);
		carrito.addArticulo(ropa1);
		System.out.println(carrito);
		Libros libro1 = new Libros();
		libro1.setPrecio(15);
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
