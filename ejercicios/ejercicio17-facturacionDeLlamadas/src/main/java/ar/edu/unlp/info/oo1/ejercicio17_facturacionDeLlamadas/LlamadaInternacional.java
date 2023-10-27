package ar.edu.unlp.info.oo1.ejercicio17_facturacionDeLlamadas;

import java.time.*;

public class LlamadaInternacional extends Llamada {

	private String origen;
	private String destino;

	public LlamadaInternacional(LocalDateTime comienzo, int duracion, Telefono emisor, Telefono receptor, String origen, String destino) {
		super(comienzo, duracion, emisor, receptor);
		this.origen = origen;
		this.destino = destino;
	}

	@Override
	public double facturar() {
		double monto = 0.0;
		int hora = comienzo.getHour();
		if (8 <= hora && hora < 20) {
			monto += duracion * 4;
		} else {
			monto += duracion * 3;
		}
		return 0;
	}
}
