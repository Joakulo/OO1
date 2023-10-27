package ar.edu.unlp.info.oo1.ejercicio16_politicas;

import java.time.LocalDate;

public class PoliticaFlexible implements IPoliticaDeCancelacion{

	public double calcularMontoAReembolsar(Alquiler reserva, LocalDate fechaTentativa) {
		if (reserva.esPosteriorAHoy())
			return reserva.calcularPrecio();
		return 0;
	}	
}
