package Ejercicio47;

public class App {

	public static void main(String[] args) {
		
		Cliente cliente1 = new Cliente("123456x","Blas de los montes");
		Carrito carrito1 = new Carrito();
		System.out.println(carrito1);
		Ropa ropa1 = new Ropa(20,"Poncho","XL","Azul");
		carrito1.addArticulo(ropa1);
		carrito1.addArticulo(ropa1);
		
	}

}
