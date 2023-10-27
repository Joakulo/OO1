package ar.edu.unlp.info.oo1.ejercicio14_tiempo;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import org.junit.jupiter.api.*;

public class DataLapseTest {

	private IDataLapse lapso;
	
	@BeforeEach
	void setUp() {
		lapso = new DataLapse(LocalDate.of(2023, 10, 1), LocalDate.of(2023, 10, 7));
	}
	
	@Test
	void sizeInDaysTest() {
		assertNotEquals(5, lapso.getSizeInDays());
		assertEquals(6, lapso.getSizeInDays());		//Cuenta el tiempo que paso entre las fechas
		assertNotEquals(7, lapso.getSizeInDays());
	}
	
	@Test
	void includesDateTest() {
		assertFalse(lapso.includesDate(LocalDate.of(2023, 10, 1)));
		assertTrue(lapso.includesDate(LocalDate.of(2023, 10, 4)));
		assertFalse(lapso.includesDate(LocalDate.of(2023, 10, 7)));
	}
}
