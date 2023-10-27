package ar.edu.unlp.info.oo1.ejercicio11_inversor;

public class InversionEnAcciones extends Inversion{

	private String nombre;
	private int cantidad;
	private double valorUnitario;
	
	public InversionEnAcciones(String nombre, int cant, double valor) {
		this.nombre = nombre;
		this.cantidad = cant;
		this.valorUnitario = valor;
	}
	
	@Override
	public double valorActual() {
		return (cantidad * valorUnitario);
	}

}
