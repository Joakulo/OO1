package ar.edu.unlp.info.oo1.ejercicio17_facturacionDeLlamadas;

import java.time.*;

public class LlamadaLocal extends Llamada {

	public LlamadaLocal(LocalDateTime comienzo, int duracion, Telefono emisor, Telefono receptor) {
		super(comienzo, duracion, emisor, receptor);
	}

	@Override
	public double facturar() {
		return (double) duracion;
	}

}
