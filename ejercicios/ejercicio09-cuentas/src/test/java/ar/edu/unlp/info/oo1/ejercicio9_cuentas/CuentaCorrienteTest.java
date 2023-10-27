package ar.edu.unlp.info.oo1.ejercicio9_cuentas;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CuentaCorrienteTest {
	private Cuenta cuentaCorriente;
	
	@BeforeEach
	void setUp() throws Exception{
		cuentaCorriente= new CuentaCorriente();
	}
	
	@Test
	void testConstructor() {
		assertEquals(0, cuentaCorriente.getSaldo());
	}
	
	@Test
	void testDepositar() {
		cuentaCorriente.depositar(100);
		assertEquals(100, cuentaCorriente.getSaldo());
	}
	
	@Test
	void testExtraer() {
		cuentaCorriente.depositar(100);
		assertTrue(cuentaCorriente.extraer(100));
		assertFalse(cuentaCorriente.extraer(50));
		assertEquals(0, cuentaCorriente.getSaldo());
	}
	
	@Test
	void testTransferirACajaDeAhorro() {
		Cuenta cajaDeAhorro = new CajaDeAhorro();
		cuentaCorriente.depositar(100);	
		assertTrue(cuentaCorriente.transferirACuenta(50, cajaDeAhorro));
		assertEquals(50, cuentaCorriente.getSaldo());
		assertEquals(49, cajaDeAhorro.getSaldo());
	}
	
	@Test
	void testTransferirACuentaCorriente() {
		Cuenta otraCuentaCorriente = new CuentaCorriente();
		cuentaCorriente.depositar(100);
		assertTrue(cuentaCorriente.transferirACuenta(50, otraCuentaCorriente));
		assertEquals(50, cuentaCorriente.getSaldo());
		assertEquals(50, otraCuentaCorriente.getSaldo());
	}
}
