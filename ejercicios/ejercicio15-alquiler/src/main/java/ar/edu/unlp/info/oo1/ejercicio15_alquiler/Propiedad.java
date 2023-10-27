package ar.edu.unlp.info.oo1.ejercicio15_alquiler;

import java.time.LocalDate;
import java.util.*;

public class Propiedad {
	
	private String nombre;
	private String descripcion;
	private double precioPorNoche;
	private String direccion;
	private Usuario propietario;
	private Set<Alquiler> alquileres;

	public Propiedad(String nombre, String descripcion, double precio, String direccion, Usuario propietario) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precioPorNoche = precio;
		this.direccion = direccion;
		this.propietario = propietario;
		alquileres = new HashSet<>();
	}
	
	public void agregarReserva(Alquiler alquiler) {
		alquileres.add(alquiler);
	}
	
	public double getPrecioPorNoche() {
		return precioPorNoche;
	}
	
	public boolean estaDisponible(LocalDate from, LocalDate to) {
		if (alquileres.isEmpty()) return true;
		return alquileres.stream()
							.anyMatch(a -> a.estaDisponible(from, to));
	}
	
	public void eliminarReserva(Alquiler reserva) {
		alquileres.remove(reserva);
	}
	
	public double calcularIngresosEntre(LocalDate from, LocalDate to) {
		return alquileres.stream()
							.filter(alq -> !alq.estaDisponible(from, to))
							.mapToDouble(alq -> alq.calcularPrecio())
							.sum();
	}
	
}
