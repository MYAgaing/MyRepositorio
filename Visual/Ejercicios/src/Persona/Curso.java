package Persona;

public class Curso extends Alumno {

	private Integer identificador;
	private String descripcion;
	private Alumno[] numAlumnos;
	
	
	
	public Curso() {
		
	}
	public Curso(Integer numAlumnos) {
		Alumno = new Alumno[numAlumnos];
	}
	
	
	@Override
	public String toString() {
		return "Curso identificador = " + identificador + ", descripcion = " + descripcion;
	}



	public Curso(Integer identificador, String descripcion) {
		super();
		this.identificador = identificador;
		this.descripcion = descripcion;
	}
	
	public Integer getIdentificador() {
		return identificador;
	}
	public void setIdentificador(Integer identificador) {
		this.identificador = identificador;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	for(int i = 0; i < alumnos.length; i++) {
		if (alumnos.get(i) == null) {
			alumnos.get(i) = alumno;
			return;
		}
	}
	
	
	
}
