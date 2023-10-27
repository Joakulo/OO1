package ar.edu.unlp.info.oo1.ejercicio9_cuentas;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;


public class CajaDeAhorroTest {
	
	private Cuenta cajaDeAhorro;
	
	@BeforeEach
	void setUp() throws Exception{
		cajaDeAhorro = new CajaDeAhorro();
	}
	
	@Test
	void testConstructor() {
		assertEquals(0, cajaDeAhorro.getSaldo());
	}
	
	@Test
	void testDepositar() {
		cajaDeAhorro.depositar(100);
		assertEquals(98, cajaDeAhorro.getSaldo());
	}
	
	@Test
	void testExtraer() {
		cajaDeAhorro.depositar(100);				//Le llegan 98
		assertFalse(cajaDeAhorro.extraer(100));		//Intenta sacar ((102))
		assertTrue(cajaDeAhorro.extraer(50));		//Intenta sacar ((51))
		assertEquals(47, cajaDeAhorro.getSaldo());
	}
	
	@Test
	void testTransferirACajaDeAhorro() {
		Cuenta otraCajaDeAhorro = new CajaDeAhorro();
		cajaDeAhorro.depositar(100);										//Le llegan 98
		assertTrue(cajaDeAhorro.transferirACuenta(50, otraCajaDeAhorro));	//Intenta transferir ((51))
		assertEquals(47, cajaDeAhorro.getSaldo());
		assertEquals(49.98, otraCajaDeAhorro.getSaldo());					//Despues de depositar (51) queda con 49.98
	}
	
	@Test
	void testTransferirACuentaCorriente() {
		Cuenta otraCajaDeAhorro = new CuentaCorriente();
		cajaDeAhorro.depositar(100);										//Le llegan 98
		assertTrue(cajaDeAhorro.transferirACuenta(50, otraCajaDeAhorro));	//Intenta transferir ((51))
		assertEquals(47, cajaDeAhorro.getSaldo());
		assertEquals(51, otraCajaDeAhorro.getSaldo());
	}
}
