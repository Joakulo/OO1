package ar.edu.unlp.info.oo1.ejercicio15_alquiler;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PropiedadTest {
	private Propiedad propiedad1;
	private Propiedad propiedad2;
	private Usuario propietario1;
	private Alquiler reserva1;
	private Alquiler reserva2;
	private Alquiler reserva3;
	private DateLapse lapso;
	private DateLapse lapso2;
	private DateLapse lapso3;

	@BeforeEach
	void setUp() throws Exception {
		this.propietario1 = new Usuario ("SoyPropietario1", "ABC", 123);
		this.lapso = new DateLapse (LocalDate.of(2022, 10, 5), LocalDate.of(2022, 10, 15));
		this.lapso2 = new DateLapse (LocalDate.of(2022, 10, 1), LocalDate.of(2022, 10, 6));
		this.lapso3 = new DateLapse (LocalDate.of(2025, 11, 1), LocalDate.of(2025, 11, 15));
		this.propiedad1 = new Propiedad ("Propiedad1", "abc" , 500, "Avenida Siempre Viva 742", propietario1);
		this.propiedad2 = new Propiedad ("Propiedad2", "bca" , 200, "Avenida San Martin 421", propietario1);
		this.reserva1 = new Alquiler (this.propiedad1, propietario1, this.lapso);
		this.reserva2 = new Alquiler (this.propiedad2, propietario1, this.lapso2);
		this.reserva3 = new Alquiler (this.propiedad2, propietario1, this.lapso3);
		this.propietario1.agregarPropiedad(propiedad1);
		this.propietario1.agregarPropiedad(propiedad2);
		this.propiedad1.agregarReserva(reserva1);
		this.propiedad2.agregarReserva(reserva2);
		this.propiedad2.agregarReserva(reserva3);
	}

	@Test
	void testDisponibilidad() {
		assertFalse(this.propiedad1.estaDisponible(lapso.getFrom(), lapso.getTo()));
		assertTrue(this.propiedad1.estaDisponible(lapso3.getFrom(), lapso3.getTo()));
	}
	
	@Test
	void testCalcularIngresoPropiedad() {
		assertEquals(4500,this.propiedad1.calcularIngresosEntre(LocalDate.of(2022, 9, 30), LocalDate.of(2025, 11, 15)));
		assertEquals(3400,this.propiedad2.calcularIngresosEntre(LocalDate.of(2022, 9, 30), LocalDate.of(2025, 11, 15)));
		assertEquals(0,this.propiedad1.calcularIngresosEntre(LocalDate.of(2022, 10, 16), LocalDate.of(2025, 11, 15)));
	}

}
