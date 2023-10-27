package ar.edu.unlp.info.oo1.ejercicio17_facturacionDeLlamadas;

import java.time.*;

public class LlamadaInterurbana extends Llamada {
	
	private int  distancia;
	
	public LlamadaInterurbana(LocalDateTime comienzo, int duracion, Telefono emisor, Telefono receptor, int distancia) {
		super(comienzo, duracion, emisor, receptor);
		this.distancia = distancia;
	}

	@Override
	public double facturar() {
		double monto = 5;
		if (this.distancia < 100) {
			monto += duracion * 2.0;
		} else if (this.distancia < 500) {
			monto += duracion * 2.5;
		} else {
			monto += duracion * 3.0;
		}
		return monto;
	}
}
