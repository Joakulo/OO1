package ar.edu.unlp.info.oo1.ejercicio17_facturacionDeLlamadas;

public class Telefono {
	
	private int numero;
	private boolean usado;
	
	public Telefono(int numero) {
		this.numero = numero;
		usado = false;
	}
	
	public int getNumero() {
		return numero;
	}

}
