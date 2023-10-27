package ar.edu.unlp.info.oo1.ejercicio15_alquiler;

import java.time.LocalDate;
import java.util.*;

public class SistemaDeAlquileres {
	
	private Set<Usuario> usuarios;
	private Set<Propiedad> propiedades;

	public SistemaDeAlquileres() {
		usuarios = new HashSet<>();
		propiedades = new HashSet<>();
	}
	
	public Usuario registrarUsuario(String nombre, String direccion, int dni) {
		Usuario user = new Usuario(nombre, direccion, dni);
		usuarios.add(user);
		return user;
	}
	
	public Propiedad registrarPropiedad(String nombre, String descripcion, double precio, String direccion, Usuario propietario) {
		Propiedad prop = new Propiedad(nombre, descripcion, precio, direccion, propietario);
		propiedades.add(prop);
		return prop;
	}
	
	public List<Propiedad> buscarPropiedadesDisponibles(LocalDate from, LocalDate to) {
		return propiedades.stream()
							.filter(p -> p.estaDisponible(from, to))
							.toList();
	}
	
	public Alquiler hacerReserva(Propiedad propiedad, DateLapse periodo, Usuario inquilino) {
		Alquiler alq = null;
		if (propiedad.estaDisponible(periodo.getFrom(), periodo.getTo())) {
			alq = new Alquiler(propiedad, inquilino, periodo);
			propiedad.agregarReserva(alq);
			inquilino.agregarReserva(alq);
		}
		return alq;
	}
	
	public double calcularPrecioDeReserva(Alquiler reserva) {
		return reserva.calcularPrecio();
	}
	
	public void eliminarReserva(Alquiler reserva) {
		if (reserva.esPosteriorAHoy()) {
			reserva.eliminarse();
		}
	}
	
	public Set<Alquiler> obtenerReservasDe(Usuario usuario){
		return usuario.getReservas();
	}
	
	public double calcularIngresosDe(Usuario usuario, LocalDate from, LocalDate to) {
		return usuarios.stream()
							.filter(user -> user.equals(usuario))
							.mapToDouble(user -> user.calcularIngresosEntre(from, to))
							.sum();
	}
	
}
