package ar.edu.unlp.info.oo1.ejercicio12_solidos;

import java.util.*;
import java.util.stream.Collectors;

public class ReporteDeConstruccion {

	private Set<Pieza> piezas;
	
	public ReporteDeConstruccion() {
		piezas = new HashSet<>();
	}
	
	public void agregarPieza(Pieza pieza) {
		piezas.add(pieza);
	}
	
	public double volumenDeMaterial(String material) {
		return piezas.stream()
				.filter(pieza -> pieza.getMaterial().equals(material))
				.collect(Collectors.toSet())
				.stream()
				.mapToDouble(pieza -> pieza.getVolumen())
				.sum();
	}
	
	public double superficieDeColor(String color) {
		return piezas.stream()
				.filter(pieza -> pieza.getColor().equals(color))
				.collect(Collectors.toSet())
				.stream()
				.mapToDouble(pieza -> pieza.getSuperficie())
				.sum();
	}
}
