package Ejercicio47;

public class App {

	public static void main(String[] args) {
		
		Cliente cliente1 = new Cliente("123456x","Blas de los montes");
		Carrito carrito1 = new Carrito();
		//System.out.println(carrito1);
		Ropa ropa1 = new Ropa(20,"Poncho","XL","Azul");
		carrito1.addArticulo(ropa1);
		carrito1.addArticulo(ropa1);
		System.out.println(carrito1);
		Libros libro1 = new Libros();
		libro1.setPrecio(15);
		libro1.setDescripcion("Así habló Zaratustra");
		libro1.setAutor("Nietzche");
		carrito1.addArticulo(libro1);
		Integer precioMedio = carrito1.precioMedio();
		System.out.println(precioMedio);
		carrito1.vaciarCesta();
		System.out.println(carrito1);
		carrito1.precioMedio(ropa1);
	}

}
