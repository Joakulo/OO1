package ar.edu.unlp.info.oo1.ejercicio14_tiempo;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import org.junit.jupiter.api.*;

public class DataLapse2Test {

	private IDataLapse lapso;
	
	@BeforeEach
	void setUp() {
		lapso = new DataLapse2(LocalDate.of(2023, 10, 1), 6);
	}
	
	@Test
	void getToTest() {
		assertNotEquals(LocalDate.of(2023, 10, 6), lapso.getTo());
		assertEquals(LocalDate.of(2023, 10, 7), lapso.getTo());
		assertNotEquals(LocalDate.of(2023, 10, 8), lapso.getTo());
	}
	
	@Test
	void includesDateTest() {
		assertFalse(lapso.includesDate(LocalDate.of(2023, 10, 1)));
		assertTrue(lapso.includesDate(LocalDate.of(2023, 10, 4)));
		assertFalse(lapso.includesDate(LocalDate.of(2023, 10, 7)));
	}
}
