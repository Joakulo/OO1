package ar.edu.unlp.info.oo1.ejercicio16_politicas;

import java.time.LocalDate;
import java.util.*;

public class Usuario {
	
	private String nombre;
	private String direccion;
	private int dni;
	private Set<Propiedad> propiedades;
	private Set<Alquiler> reservas;

	public Usuario(String nombre, String direccion, int dni) {
		this.nombre = nombre;
		this.direccion = direccion;
		this.dni = dni;
		propiedades = new HashSet<>();
		reservas = new HashSet<>();
	}
	
	public Set<Alquiler> getReservas(){
		return reservas;
	}
	
	public void agregarPropiedad(Propiedad propiedad) {
		propiedades.add(propiedad);
	}
	
	public void eliminarPropiedad(Propiedad propiedad) {
		propiedades.remove(propiedad);
	}
	
	public void agregarReserva(Alquiler reserva) {
		reservas.add(reserva);
	}
	
	public void eliminarReserva(Alquiler reserva) {
		reservas.remove(reserva);
	}
	
	public double calcularIngresosEntre(LocalDate from, LocalDate to) {
		return propiedades.stream()
							.mapToDouble(p -> p.calcularIngresosEntre(from, to))
							.sum();
	}
}
