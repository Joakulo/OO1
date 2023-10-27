package ar.edu.unlp.info.oo1.ejercicio15_alquiler;

import java.time.LocalDate;

public class Alquiler {
	
	private Propiedad propiedad;
	private Usuario inquilino;
	private DateLapse periodo;

	public Alquiler(Propiedad propiedad, Usuario inquilino, DateLapse periodo) {
		this.propiedad = propiedad;
		this.inquilino = inquilino;
		this.periodo = periodo;
	}
	
	public boolean estaDisponible(LocalDate from, LocalDate to) {
		return !periodo.overlaps( new DateLapse(from, to) );
	}
	
	public double calcularPrecio() {
		return cantNoches() * propiedad.getPrecioPorNoche();
	}
	
	private int cantNoches() {
		return periodo.getSizeInDays() - 1;
	}
	
	public boolean esPosteriorAHoy() {
		return LocalDate.now().isBefore(periodo.getFrom());
	}
	
	public void eliminarse() {
		propiedad.eliminarReserva(this);
		inquilino.eliminarReserva(this);
	}
}
