package model;

public class Estudiante {
	private String nombre;
	private String apellido;
	private String rut;
	private String matricula;
	public Carrera unnamed_Carrera_;

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return this.apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getRut() {
		return this.rut;
	}

	public void setRut(String rut) {
		this.rut = rut;
	}

	public String getMatricula() {
		return this.matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public Estudiante(String nombre, String apellido, String rut, String matricula) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.rut = rut;
		this.matricula = matricula;
	}
	public String toString(){
		return "\n Nombre: "+this.nombre+"\n Apellido: "+this.apellido+"\n Rut: "+this.rut+"\n Matrícula: "+this.matricula;
	}
}