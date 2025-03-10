package Granja;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class Granja {
	public static final Double POLLOS = 1.5;
	public static final Double CERDOS = 4.5;

	private String localidad;
	private List<Animales> animal;

	public Granja(String localidad) {
		this.localidad = localidad;
		this.animal = new ArrayList<>();
	}

	public String getLocalidad() {
		return localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	public void addAnimal(Animales x) {
		animal.add(x);
	}

	public List<Animales> getAnimalesNacimiento(Integer año) {
		List<Animales> eseAño = new ArrayList<>();
		for (Animales animales : eseAño) {
			if (animales.getFecha_nacimiento().getYear() == año) {
				eseAño.add(animales);
			}
		}
		return eseAño;
	}

	public BigDecimal getPesoTotal() {
		BigDecimal total = new BigDecimal(0);
		for (Animales animales : animal) {
			total = total.add(animales.getPeso());
		}
		return total.setScale(2, RoundingMode.HALF_UP);
	}

	public BigDecimal calcularPrecioVenta() {
		BigDecimal totalPollos = new BigDecimal(0);
		BigDecimal totalCerdos = new BigDecimal(0);
		for (Animales animales : animal) {
			if (animales.tipo) {
				totalPollos = totalPollos.add(animales.getPeso());
			} else {
				totalCerdos = totalCerdos.add(animales.getPeso());
			}
		}
		Double ganancias = 0.0;
		Double pollosTotal = totalPollos.doubleValue();
		Double cerdosTotal = totalCerdos.doubleValue();
		pollosTotal = pollosTotal * POLLOS;
		cerdosTotal = cerdosTotal * CERDOS;
		ganancias = pollosTotal * cerdosTotal;
		BigDecimal ganancia = new BigDecimal(ganancias);
		return ganancia.setScale(2, RoundingMode.HALF_UP);
	}

	public void venderAnimales() {
		for (int i = 0; i < animal.size(); i++) {
			if (animal.getFirst().sePuedeVender()) {
				animal.remove(i);
			}
		}
	}

	@Override
	public String toString() {
		return "Granja de " + localidad + " // " + animal.size() + " animales con " + getPesoTotal() + " kilos";
	}

}
