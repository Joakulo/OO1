package ar.edu.unlp.info.oo1.ejercicio17_facturacionDeLlamadas;

public abstract class Persona {

	private int numero;
	private String nombre;
	private String direccion;
	
	public Persona(int numero, String nombre, String direccion) {
		this.numero = numero;
		this.nombre = nombre;
		this.direccion = direccion;
	}
	
	public int getNumero() {
		return numero;
	}
	
	public abstract double aplicarDescuento(double monto);
}
