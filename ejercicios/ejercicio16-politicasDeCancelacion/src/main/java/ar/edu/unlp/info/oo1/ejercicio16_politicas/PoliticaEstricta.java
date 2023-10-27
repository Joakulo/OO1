package ar.edu.unlp.info.oo1.ejercicio16_politicas;

import java.time.LocalDate;

public class PoliticaEstricta implements IPoliticaDeCancelacion{

	@Override
	public double calcularMontoAReembolsar(Alquiler reserva, LocalDate fechaTentativa) {
		return 0;
	}

}
