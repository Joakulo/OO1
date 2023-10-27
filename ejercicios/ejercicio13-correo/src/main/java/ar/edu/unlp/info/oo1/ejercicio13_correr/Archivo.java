package ar.edu.unlp.info.oo1.ejercicio13_correr;

public class Archivo {

	private String nombre;
	
	public Archivo(String nombre) {
		this.nombre = nombre;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public int getTamaño() {
		return nombre.length();
	}
}
