package Reloj;

public class Reloj {

	private Integer hora;
	private Integer minuto;
	private Integer segundo;
	private Boolean formato24hora;

	public Reloj() {
		this.hora = 00;
		this.minuto = 00;
		this.segundo = 00;
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
	}

	public Boolean Check(Integer hora, Integer minuto, Integer segundo) {
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
		if(formato24hora == true) {return hora + ":" + minuto + ":" + segundo;}
		return "Reloj [hora=" + hora + ", minuto=" + minuto + ", segundo=" + segundo + ", formato24hora="
				+ formato24hora + "]";
	}
}
