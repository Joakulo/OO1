package ar.edu.unlp.info.oo1.ejercicio16_politicas;

import java.time.LocalDate;

public class PoliticaModerada implements IPoliticaDeCancelacion {

	@Override
	public double calcularMontoAReembolsar(Alquiler reserva, LocalDate fechaTentativa) {
		double monto = 0.0;
		if (reserva.esPosteriorAHoy()) {
			if (reserva.esPosteriorA(fechaTentativa.plusDays(7))) {
				monto = reserva.calcularPrecio();
			} else if (reserva.esPosteriorA(fechaTentativa.plusDays(2))){
				monto = reserva.calcularPrecio() / 2.0;
			}
		}
		return monto;
	}

}
