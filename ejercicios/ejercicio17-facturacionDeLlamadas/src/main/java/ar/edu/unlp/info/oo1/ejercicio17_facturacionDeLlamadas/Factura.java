package ar.edu.unlp.info.oo1.ejercicio17_facturacionDeLlamadas;

import java.time.LocalDate;
import java.util.List;

public class Factura {

	private Persona cliente;
	private LocalDate fechaFacturacion;
	private LocalDate inicio;
	private LocalDate fin;
	private double monto;
	
	public Factura (Persona cliente, LocalDate from, LocalDate to, List<Llamada> llamadas) {
		this.cliente = cliente;
		this.inicio = from;
		this.fin = to;
		this.fechaFacturacion = LocalDate.now();
		this.monto = 0.0;
		facturar(llamadas);
	}
	
	private void facturar(List<Llamada> llamadas) {
		double monto = llamadas.stream()
							.filter(l -> l.estaEntre(inicio, fin))
							.mapToDouble(l -> l.facturar())
							.sum();
		this.monto = cliente.aplicarDescuento(monto);
	}
}
