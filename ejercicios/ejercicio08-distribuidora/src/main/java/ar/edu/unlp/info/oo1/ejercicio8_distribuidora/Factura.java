package ar.edu.unlp.info.oo1.ejercicio8_distribuidora;

import java.time.LocalDate;

public class Factura {

	private double montoEnergiaActiva;
	private double descuento;
	private LocalDate fecha;
	private Usuario user;
	
	public Factura(double montoEnergiaActiva, double descuento, Usuario user) {
		this.montoEnergiaActiva = montoEnergiaActiva;
		this.descuento = descuento;
		this.fecha = LocalDate.now();
		this.user = user;
	}
	
	public double montoTotal() {
		return montoEnergiaActiva * (1 - (descuento / 100.0));
	}
	
	public double getMontoEnergiaActiva() {
		return this.montoEnergiaActiva;
	}
	
	public Usuario getUsuario() {
		return this.user;
	}
	
	public LocalDate getFecha() {
		return this.fecha;
	}
	
	public double getDescuento() {
		return this.descuento;
	}
}
