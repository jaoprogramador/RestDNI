package com.jao.ws.rest.vo;

public class VODocumentoDNI {
	private String nombre;
	private String apellidos;
	private String sexo;
	private String dni;
	private boolean valido=true;
	
	
	
	/*public VODocumentoDNI(String nombre, String apellidos, String sexo, String dni, boolean valido) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.sexo = sexo;
		this.dni = dni;
		this.valido = valido;
	}*/
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public boolean isValido() {
		return valido;
	}
	public void setValido(boolean valido) {
		this.valido = valido;
	}
	

}
