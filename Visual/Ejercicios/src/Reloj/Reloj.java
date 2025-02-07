package Reloj;

import java.util.Objects;

public class Reloj {

	private Integer hora;
	private Integer minuto;
	private Integer segundo;
	private Boolean formato24hora;

	public Reloj() {
		this.hora = 0;
		this.minuto = 0;
		this.segundo = 0;
		this.formato24hora = true;
	}

	public Reloj(Integer hora, Integer minuto, Integer segundo) {
		this.formato24hora = true;
	}

	public Integer getHora() {
		return hora;
	}

	public Integer getMinuto() {
		return minuto;
	}

	public Integer getSegundo() {
		return segundo;
	}

	public Boolean getFormato24hora() {
		return formato24hora;
	}

	public void setFormato24hora(Boolean formato24hora) {
		this.formato24hora = formato24hora;
	}

	public void ponerHora(Integer hora, Integer minuto) {
		this.hora = hora;
		this.minuto = minuto;
	}

	public void ponerHora(Integer hora, Integer minuto, Integer segundo) {
		this.hora = hora;
		this.minuto = minuto;
		this.segundo = segundo;
		this.formato24hora = true;
	}

	public Boolean Check() {
		if (hora > 0 && hora < 23) {
			if (minuto > 0 && minuto < 59) {
				if (segundo > 0 && minuto < 59) {
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public String toString() {
		if (!Check()) {
			return "La hora no es correcta";
		}
		if (formato24hora) {
			return hora + ":" + minuto + ":" + segundo;
		} else {
			if (hora <= 12) {
				return hora + ":" + minuto + ":" + segundo + " AM";
			} else {
				return (hora - 12) + ":" + minuto + ":" + segundo + " PM";
			}
		}
	}

	@Override
	public int hashCode() {
		return Objects.hash(hora, minuto, segundo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Reloj other = (Reloj) obj;
		return Objects.equals(hora, other.hora) && Objects.equals(minuto, other.minuto)
				&& Objects.equals(segundo, other.segundo);
	}
	
}
