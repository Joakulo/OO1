package ar.edu.unlp.info.oo1.ejercicio13_correr;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ClienteDeCorreoTest {

	private ClienteDeCorreo correo;
	
	@BeforeEach
	void setUp() {
		correo = new ClienteDeCorreo();
		
		Email e1 = new Email("Titulo", "Cuerpo");
		e1.agregarAdjunto( new Archivo("ArchivoUno") );
		e1.agregarAdjunto( new Archivo("ArchivoDos") );
		e1.agregarAdjunto( new Archivo("ArchivoTres") );
		
		Carpeta c1 = new Carpeta("Carpeta1");
		c1.agregarEmail(e1);
		
		correo.agegarCarpeta(c1);
		
		Email e2 = new Email("UnTitulo", "UnCuerpo");
		e2.agregarAdjunto( new Archivo("ArchivoCuatro") );
		e2.agregarAdjunto( new Archivo("ArchivoCinco") );
		
		Email e3 = new Email("OtroTitulo", "OtroCuerpo");
		e3.agregarAdjunto( new Archivo("ArchivoSeis") );
		e3.agregarAdjunto( new Archivo("ArchivoSiete") );
		
		Carpeta c2 = new Carpeta("Carpeta1");
		c2.agregarEmail(e2);
		c2.agregarEmail(e3);
		
		correo.agegarCarpeta(c2);
		
		correo.recibir(e1);
		correo.recibir(e2);
		correo.recibir(e3);
		
	}
	
	@Test
	void buscarTest() {
		assertNull(correo.buscar("Este email no existe"));
		assertNotNull(correo.buscar("UnCuerpo"));
	}
	
	@Test
	void espacioOcupadoTest() {
		assertEquals(254, correo.espacioOcupado());
		correo = new ClienteDeCorreo();
		assertEquals(0, correo.espacioOcupado());
	}
}
