package model.app;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import model.modulo.Cliente;
import model.modulo.Pedido;
import model.services.BaseDeDatosException;
import model.services.NoExisteException;
import model.services.PedidosService;

public class App {

	public static void main(String[] args) throws SQLException, NoExisteException, BaseDeDatosException {
		Scanner sc = new Scanner(System.in);
		PedidosService service = new PedidosService();
		try {
			System.out.println("Digame una fecha (dd/MM/yyyy)");
			LocalDate fechaNueva;
			while (true) {
				try {
					DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
					String fecha = sc.nextLine();
					fechaNueva = LocalDate.parse(fecha, formato);
					break;
				} catch (DateTimeParseException e) {
					System.out.println("Fecha introducida de forma incorrecta, pruebe de nuevo");
				}
			}
			service.buscarPedidos(fechaNueva, "123456");
			Cliente cliente1 = new Cliente();
			cliente1.setDni("123456");
			List<Pedido> lista = new ArrayList<>();
			Map<Integer, Pedido> mapa = service.buscarPedidos(fechaNueva, "123456");
			 for (Map.Entry<Integer, Pedido> entry : mapa.entrySet()) {
				lista.add(entry.getValue());
			}
			cliente1.setPedidos(lista);
			 System.out.println(cliente1.getPedidos());
			System.out.println(cliente1.getPedidoCritico());
		} catch (BaseDeDatosException e) {
			System.out.println(e.getMessage());
		} catch(NoExisteException e) {
			System.out.println(e.getMessage());
		} finally {
			sc.close();
		}

	}

}
