package ar.edu.unlp.info.oo1.ejercicio16_politicas;

import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;
import org.junit.jupiter.api.*;

public class DateLapseTest {

	private DateLapse lapso;
	private DateLapse lapso2;
	private DateLapse lapso3;
	private DateLapse lapso4;


	@BeforeEach
	void setUp() throws Exception {
		this.lapso = new DateLapse (LocalDate.of(2022, 10, 5), LocalDate.of(2022, 10, 15));
		this.lapso2 = new DateLapse (LocalDate.of(2022, 10, 1), LocalDate.of(2022, 10, 6));
		this.lapso3 = new DateLapse (LocalDate.of(2022, 11, 1), LocalDate.of(2022, 11, 15));
		this.lapso4 = new DateLapse (LocalDate.of(2022, 10, 1), LocalDate.of(2022, 10, 5));
	}

	@Test
	void testOverlaps() {
		assertTrue(this.lapso.overlaps(lapso2));
		assertFalse(this.lapso.overlaps(lapso3));
		assertTrue(this.lapso.overlaps(lapso4));
	}
}
