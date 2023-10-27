package ar.edu.unlp.info.oo1.ejercicio16_politicas;

import java.time.LocalDate;

public interface IPoliticaDeCancelacion {

	public double calcularMontoAReembolsar(Alquiler reserva, LocalDate fechaTentativa);
}
