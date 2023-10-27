package ar.edu.unlp.info.oo1.ejercicio16_politicas;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.*;

public class AlquilerTest {

	private Alquiler reserva1;
	private Alquiler reserva2;
	private Alquiler reserva3;
	private DateLapse lapso;
	private DateLapse lapso2;
	private DateLapse lapso3;
	private DateLapse lapso4;
	private Propiedad propiedad1;
	private Propiedad propiedad2;
	
	@BeforeEach
	void setUp() throws Exception {
		this.lapso = new DateLapse (LocalDate.of(2022, 10, 5), LocalDate.of(2022, 10, 15));
		this.lapso2 = new DateLapse (LocalDate.of(2022, 10, 1), LocalDate.of(2022, 10, 6));
		this.lapso3 = new DateLapse (LocalDate.of(2025, 11, 1), LocalDate.of(2025, 11, 15));
		this.lapso4 = new DateLapse (LocalDate.of(2022, 10, 1), LocalDate.of(2022, 10, 5));
		this.propiedad1 = new Propiedad ("Propiedad1", "abc" , 500, "Avenida Siempre Viva 742", new Usuario ("Lana", "Dir", 333));
		this.propiedad2 = new Propiedad ("Propiedad2", "bca" , 0, "Avenida San Martin 421", new Usuario ("Madonna", "Dir", 222));
		this.reserva1 = new Alquiler (this.propiedad1, new Usuario("a", "b", 123), this.lapso);
		this.reserva2 = new Alquiler (this.propiedad2, new Usuario("a", "b", 123), this.lapso2);
		this.reserva3 = new Alquiler (this.propiedad2, new Usuario("a", "b", 123), this.lapso3);
	}

	@Test
	void testCalcularReserva() {
		assertEquals(4500, this.reserva1.calcularPrecio());
		assertEquals(0, this.reserva2.calcularPrecio());
	}
	
	@Test
	void testOverlaps() {
		assertFalse (this.reserva1.estaDisponible(lapso2.getFrom(), lapso2.getTo()));
		assertFalse(this.reserva1.estaDisponible(lapso4.getFrom(), lapso4.getTo()));
		assertFalse (this.reserva1.estaDisponible(lapso.getFrom(), lapso.getTo()));
		
	}
	
	@Test
	void testLaterFrom() {
		assertTrue (this.reserva3.esPosteriorAHoy());
		assertFalse (this.reserva1.esPosteriorAHoy());
		
	}
	

}
