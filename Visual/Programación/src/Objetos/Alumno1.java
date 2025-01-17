package Objetos;

public class Alumno1 {


		private String dni;
		private Integer edad;
		private String nombre;
		private Integer nota;
		
		
		


		public String getDni() {
			return dni;
		}


		public void setDni(String dni) {
			this.dni = dni;
		}


		public Integer getEdad() {
			return edad;
		}


		public void setEdad(Integer edad) {
			this.edad = edad;
		}


		public String getNombre() {
			return nombre;
		}


		public void setNombre(String nombre) {
			this.nombre = nombre;
		}


		public Integer getNota() {
			return nota;
		}


		public void setNota(Integer nota) {
			this.nota = nota;
		}
	
		public void aprobar() {
			this.nota = 5;
		}
		public Alumno1(String dni) {
			this.dni = dni;
		}
}
