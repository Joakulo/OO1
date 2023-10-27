package ar.edu.unlp.info.oo1.ejercicio11_inversor;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class PlazoFijo extends Inversion{
	
	private LocalDate fechaDeConstitucion;
	private double montoDepositado;
	private double porcentajeDeInteresDiario;

	public PlazoFijo(double montoDepositado, double porcentaje) {
		this.fechaDeConstitucion = LocalDate.of(2023, 10, 1);
		this.montoDepositado = montoDepositado;
		this.porcentajeDeInteresDiario = porcentaje;
	}
	
	@Override
	public double valorActual() {
		long diferenciaEnDias = this.fechaDeConstitucion.until(LocalDate.now(), ChronoUnit.DAYS);
		double interes = diferenciaEnDias * this.porcentajeDeInteresDiario;
		return this.montoDepositado + (this.montoDepositado * interes / 100.0);
	}

}
