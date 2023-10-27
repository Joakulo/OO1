package ar.edu.unlp.info.oo1.ejercicio11_inversor;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class InversorTest {
	
	private Inversor inversor;
	
	@BeforeEach
	public void setUp() {
		inversor = new Inversor("Josco");
		inversor.agregarInvesion(new PlazoFijo(100, 5));
		inversor.agregarInvesion(new InversionEnAcciones("Inv", 25, 4));
	}
	
	@Test
	public void testValorActual() {
		assertEquals(220, inversor.valorActualStream());
	}
	
}