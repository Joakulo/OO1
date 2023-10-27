package ar.edu.unlp.info.oo1.ejercicio12_solidos;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ReporteDeConstruccionTest {

	private ReporteDeConstruccion report;
	
	@BeforeEach
	public void setUp() {
		report = new ReporteDeConstruccion();

	}
	
	@Test
	public void getVolumenTest() {
		assertEquals(0, report.volumenDeMaterial("Hierro"));
		report.agregarPieza(new Cilindro("Hierro", "Rojo", 1, 5));
		report.agregarPieza(new Cilindro("Hierro", "Verde", 1, 5));
		report.agregarPieza(new Cilindro("Aluminio", "Rojo", 1, 5));
		assertEquals(Math.PI * 10, report.volumenDeMaterial("Hierro"));
		assertEquals(Math.PI * 5, report.volumenDeMaterial("Aluminio"));
		assertEquals(0, report.volumenDeMaterial("Oro"));
	}
	
	@Test
	public void getSuperficieTest() {
		assertEquals(0, report.superficieDeColor("Rojo"));
		report.agregarPieza(new PrismaRectangular("Hierro", "Rojo", 5, 3, 7));
		report.agregarPieza(new PrismaRectangular("Hierro", "Verde", 5, 3, 7));
		report.agregarPieza(new PrismaRectangular("Aluminio", "Rojo", 5, 3, 7));
		assertEquals(284, report.superficieDeColor("Rojo"));
		assertEquals(142, report.superficieDeColor("Verde"));
		assertEquals(0, report.superficieDeColor("Azul"));
	}
}
