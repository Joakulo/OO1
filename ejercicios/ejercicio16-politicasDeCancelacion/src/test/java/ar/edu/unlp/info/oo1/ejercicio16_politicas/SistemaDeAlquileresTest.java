package ar.edu.unlp.info.oo1.ejercicio16_politicas;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SistemaDeAlquileresTest {
	
	private SistemaDeAlquileres sistema;
	private Usuario usuarioConReservas;
	private Usuario usuarioSinReservas;
	private Usuario propietario1;
	private Usuario propietarioSinPropiedades;
	private Alquiler reserva1;
	private Alquiler reserva2;
	private Alquiler reserva3;
	private DateLapse lapso;
	private DateLapse lapso2;
	private DateLapse lapso3;
	private Propiedad propiedad1;
	private Propiedad propiedad2;
		

	@BeforeEach
	void setUp() throws Exception {
		this.sistema = new SistemaDeAlquileres();
	
		this.usuarioConReservas = this.sistema.registrarUsuario("Lana", "Dir", 333);
		this.usuarioSinReservas = this.sistema.registrarUsuario("Madonna", "Dir", 222);
		this.propietario1 = this.sistema.registrarUsuario("SoyPropietario1", "ABC", 123);
		this.propietarioSinPropiedades = this.sistema.registrarUsuario("SoyPropietario2", "ABC", 123);
		
		this.propiedad1 = this.sistema.registrarPropiedad("Propiedad1", "abc" , 500, "Avenida Siempre Viva 742", propietario1);
		this.propiedad2 = this.sistema.registrarPropiedad("Propiedad2", "bca" , 200, "Avenida San Martin 421", propietario1);
	
		this.propietario1.agregarPropiedad(propiedad1);
		this.propietario1.agregarPropiedad(propiedad2);
		
		this.lapso = new DateLapse (LocalDate.of(2022, 10, 5), LocalDate.of(2022, 10, 15));
		this.lapso2 = new DateLapse (LocalDate.of(2022, 10, 1), LocalDate.of(2022, 10, 6));
		this.lapso3 = new DateLapse (LocalDate.of(2025, 11, 1), LocalDate.of(2025, 11, 15));
		
		this.reserva1 = new Alquiler (this.propiedad1, usuarioSinReservas, this.lapso);
		this.reserva2 = new Alquiler (this.propiedad2, usuarioSinReservas, this.lapso2);
		this.reserva3 = new Alquiler (this.propiedad2, usuarioSinReservas, this.lapso3);
	
	}

	@Test
	void testListarPropiedadesDisponibles() {
		assertEquals(2,this.sistema.buscarPropiedadesDisponibles(lapso3.getFrom(), lapso3.getTo()).size());
		this.propiedad1.agregarReserva(reserva1);
		assertEquals(1,this.sistema.buscarPropiedadesDisponibles(lapso.getFrom(), lapso.getTo()).size());
	}

	@Test 
	void testRealizarReserva() {
		assertNotNull(this.sistema.hacerReserva(propiedad1, lapso, usuarioConReservas));
		assertNull(this.sistema.hacerReserva(propiedad1, lapso, usuarioConReservas));
		assertNotNull(this.sistema.hacerReserva(propiedad1, lapso3, usuarioConReservas));
	}
	
	@Test
	void testEliminarReserva() {
		this.reserva1 = this.sistema.hacerReserva(propiedad1, lapso, usuarioConReservas);
		this.reserva2 = this.sistema.hacerReserva(propiedad2, lapso2, usuarioConReservas);
		this.reserva3 = this.sistema.hacerReserva(propiedad2, lapso3, usuarioConReservas);
		assertEquals(0,this.sistema.buscarPropiedadesDisponibles(lapso.getFrom(), lapso.getTo()).size());
		assertEquals(0,this.sistema.buscarPropiedadesDisponibles(lapso2.getFrom(), lapso2.getTo()).size());
		assertEquals(1,this.sistema.buscarPropiedadesDisponibles(lapso3.getFrom(), lapso3.getTo()).size());
		this.sistema.eliminarReserva(reserva1);
		this.sistema.eliminarReserva(reserva2);
		this.sistema.eliminarReserva(reserva3);
		assertEquals(0,this.sistema.buscarPropiedadesDisponibles(lapso.getFrom(), lapso.getTo()).size());
		assertEquals(0,this.sistema.buscarPropiedadesDisponibles(lapso2.getFrom(), lapso2.getTo()).size());
		assertEquals(2,this.sistema.buscarPropiedadesDisponibles(lapso3.getFrom(), lapso3.getTo()).size());
	}

	@Test
	void testObtenerReservaUsuario() {
		this.reserva1 = this.sistema.hacerReserva(propiedad1, lapso, usuarioConReservas);
		assertEquals(1,this.sistema.obtenerReservasDe(usuarioConReservas).size());
		assertEquals(0,this.sistema.obtenerReservasDe(usuarioSinReservas).size());
		
	}

	@Test
	void testCalcularIngresosPropietario() {
		this.reserva1 = this.sistema.hacerReserva(propiedad1, lapso, usuarioConReservas);
		this.reserva2 = this.sistema.hacerReserva(propiedad2, lapso2, usuarioConReservas);
		this.reserva3 = this.sistema.hacerReserva(propiedad2, lapso3, usuarioConReservas);
		assertEquals(8800,this.sistema.calcularIngresosDe(this.propietario1, LocalDate.of(2022, 9, 30), LocalDate.of(2025, 11, 15)));
		assertEquals(7800,this.sistema.calcularIngresosDe(this.propietario1, LocalDate.of(2022, 10, 13), LocalDate.of(2025, 11, 15)));
		assertEquals(2800,this.sistema.calcularIngresosDe(this.propietario1, LocalDate.of(2022, 10, 16), LocalDate.of(2025, 11, 15)));
		assertEquals(0,this.sistema.calcularIngresosDe(this.propietarioSinPropiedades, lapso.getFrom(), lapso.getTo()));
		
	}
}