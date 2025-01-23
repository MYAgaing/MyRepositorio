package Persona;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Alumno extends Persona {

	private String dni;
	private Integer nota;
	private Curso curso;

	@Override
	public String toString() {
		return "Alumno DNI = " + dni + " Alumno nota = " + nota + ", curso = " + curso;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(curso, dni, nota);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Alumno other = (Alumno) obj;
		return Objects.equals(curso, other.curso) && Objects.equals(dni, other.dni) && Objects.equals(nota, other.nota);
	}

	public Alumno() {

	}

	public Alumno(String dni) {
		this.dni = dni.toUpperCase();
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public Integer getNota() {
		return nota;
	}

	public void setNota(Integer nota) {
		this.nota = nota;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni.toUpperCase();
	}

	public Boolean validarDNI() {
		String ejemploDni = "00000000T";
		Pattern patron = Pattern.compile("[0-9]{7,8}[A-Z a-z]");
		Matcher match = patron.matcher(ejemploDni);
		if(match.matches()) {
		 return true;
		}
		else {
		 return false;
		} 

	}
	public Boolean validar(Alumno alumno) {
		if (alumno.getCurso() == null) {
			return false;
		} else if(alumno.getNombre() == null || alumno.getNombre().length() < 10) {
			return false;
		} else if (alumno.getEdad() == null || alumno.getEdad() >= 12 || alumno.getEdad() <= 65 ) {
			return false;
		} else if (!validarDNI()) {
			return false;
		} else {
		}
			return true;
		}
	}
