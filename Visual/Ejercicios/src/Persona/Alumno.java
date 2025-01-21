package Persona;

import java.util.Objects;

public class Alumno extends Persona{
	
	private String dni;
	private Integer nota;
	private Curso curso;
	
	
	
	@Override
	public String toString() {
		return "Alumno DNI = " + dni +  " Alumno nota = " + nota + ", curso = " + curso ;
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
		return (dni!=null && dni.length() == 9);
	}
	
	
}
