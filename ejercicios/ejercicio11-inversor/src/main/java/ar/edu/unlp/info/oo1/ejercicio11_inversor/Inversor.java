package ar.edu.unlp.info.oo1.ejercicio11_inversor;

import java.util.*;

public class Inversor {
	private String nombre;
	private List<Inversion> inversiones;
	
	public Inversor(String nombre) {
		this.nombre = nombre;
		inversiones = new ArrayList<>();
	}
	
	public void agregarInvesion(Inversion inv) {
		inversiones.add(inv);
	}
	
	public double valorActual() {
		double monto = 0;
		for (Inversion inv : inversiones) {
			monto += inv.valorActual();
		}
		return monto;
	}
	
	public double valorActualStream() {
		return inversiones.stream()
						.mapToDouble(inv -> inv.valorActual())
						.sum();		
	}
}