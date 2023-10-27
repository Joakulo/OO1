package ar.edu.unlp.info.oo1.ejercicio17_facturacionDeLlamadas;

import java.time.*;
import java.util.*;

public class Sistema {
	
	private List<Telefono> numerosDisponibles = new ArrayList<>();
	private List<Telefono> numerosUsados = new ArrayList<>();
	private List<Llamada> llamadas = new ArrayList<>();
	
	public void agregarNumero(int numero) {
		Telefono t = new Telefono (numero);
		numerosDisponibles.add(t);
	}
	
	public Persona altaPersonaFisica(String nombre, String direccion, String dni) {
		Telefono t = numerosDisponibles.stream()
										.findAny()
										.get();
		numerosDisponibles.remove(t);
		numerosUsados.add(t);
		Persona p = new PersonaFisica(t.getNumero(), nombre, direccion, dni);
		return p;
	}
	
	public Persona altaPersonaJuridica(String nombre, String direccion, String CUIT, String tipo) {
		Telefono t = numerosDisponibles.stream()
										.findAny()
										.get();
		numerosDisponibles.remove(t);
		numerosUsados.add(t);
		Persona p = new PersonaJuridica(t.getNumero(), nombre, direccion, CUIT, tipo);
		return p;
	}
	
	public Llamada registrarLlamadaLocal(LocalDateTime comienzo, int duracion, Telefono emisor, Telefono receptor) {
		Llamada l = new LlamadaLocal (comienzo, duracion, emisor, receptor);
		llamadas.add(l);
		return l;
	}
	
	public Llamada registrarLlamadaInterurbana(LocalDateTime comienzo, int duracion, Telefono emisor, Telefono receptor, int distancia) {
		Llamada l = new LlamadaInterurbana(comienzo, duracion, emisor, receptor, distancia);
		llamadas.add(l);
		return l;
	}
	
	public Llamada registrarLlamadaInternacional(LocalDateTime comienzo, int duracion, Telefono emisor, Telefono receptor, String origen, String destino) {
		Llamada l = new LlamadaInternacional(comienzo, duracion, emisor, receptor, origen, destino);
		llamadas.add(l);
		return l;
	}
	
	public Factura facturarCliente(Persona cliente, LocalDate from, LocalDate to) {
		List<Llamada> llam = llamadas.stream()
							.filter(l -> l.getNumeroEmisor() == cliente.getNumero())
							.toList();
		Factura f = new Factura (cliente, from, to, llam);
		return f;
	}
	

}
