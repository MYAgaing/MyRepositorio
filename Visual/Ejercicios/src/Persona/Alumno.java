package Persona;

public class Alumno extends Persona{

	private Integer nota;
	private Curso curso;
	
	
	
	@Override
	public String toString() {
		return "Alumno [nota=" + nota + ", curso=" + curso + "]";
	}

	public Alumno() {
		
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
	
	
}
