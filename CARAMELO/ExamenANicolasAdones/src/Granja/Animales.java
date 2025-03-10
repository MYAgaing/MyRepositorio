package Granja;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;

public class Animales{
	public static final Double POLLOS = 1.5;
	public static final Double CERDOS = 4.5; 
	
	private Integer num_registro;
	private LocalDate fecha_nacimiento;
	private BigDecimal peso;
	protected Boolean tipo;
	
	public Animales(Integer num_registro) {
		this.num_registro = num_registro;
		this.fecha_nacimiento = LocalDate.now();
		this.peso = new BigDecimal(0);
	}

	public LocalDate getFecha_nacimiento() {
		return fecha_nacimiento;
	}

	public void setFecha_nacimiento(LocalDate fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}

	public BigDecimal getPeso() {
		return peso;
	}

	public void setPeso(BigDecimal peso) {
		this.peso = peso;
	}
	
	public Boolean getTipo() {
		return tipo;
	}

	public void setTipo(Boolean tipo) {
		this.tipo = tipo;
	}

	public Integer getNumRegistro() {
		return num_registro;
	}
	public BigDecimal getPesoMinVenta() {
		if (tipo) {
		return new BigDecimal(5);
		}
		if(!tipo) {
			return new BigDecimal(100);
		}
		return null;
	}
	public String getPrecioVentaKg() {
		if (tipo) {
			return CERDOS + "€/kg";
		}
		if(!tipo) {
			return POLLOS + "€/Kg";
		}
		return null;
	}
	public Integer getEdad() {
		Period periodo = fecha_nacimiento.until(LocalDate.now());
		Integer meses = periodo.getMonths() + (periodo.getYears()*12);
		return meses;
	}
	public Boolean sePuedeVender() {
		Integer entero = peso.intValue();
		if(tipo) {
			if(entero >= 5) {
				return true;
			} else {
				return false;
			}
		}
		if(!tipo) {
			if(entero >= 100) {
				return true;
			} else {
				return false;
			}
		}
		return false;
	}

	@Override
	public int hashCode() {
		return Objects.hash(num_registro);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Animales other = (Animales) obj;
		return Objects.equals(num_registro, other.num_registro);
	}
	
	
	
}
