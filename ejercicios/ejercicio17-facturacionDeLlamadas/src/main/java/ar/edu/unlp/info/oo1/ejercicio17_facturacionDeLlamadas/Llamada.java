package ar.edu.unlp.info.oo1.ejercicio17_facturacionDeLlamadas;

import java.time.*;

public abstract class Llamada {

	protected LocalDateTime comienzo;
	protected int duracion;
	protected Telefono emisor;
	protected Telefono receptor;
	
	public Llamada (LocalDateTime comienzo, int duracion, Telefono emisor, Telefono receptor) {
		this.comienzo = comienzo;
		this.duracion = duracion;
		this.emisor = emisor;
		this.receptor = receptor;
	}
	
	public int getNumeroEmisor() {
		return emisor.getNumero();
	}
	
	public boolean estaEntre(LocalDate from, LocalDate to) {
		return ( from.isBefore(comienzo.toLocalDate()) && to.isAfter(comienzo.toLocalDate()) );
	}
	
	public abstract double facturar();
}
