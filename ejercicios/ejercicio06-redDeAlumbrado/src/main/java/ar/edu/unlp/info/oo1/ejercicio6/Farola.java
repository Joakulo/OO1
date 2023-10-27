package ar.edu.unlp.info.oo1.ejercicio6;

import java.util.*;

public class Farola {

	private Boolean encendida;
	private List<Farola> vecinas;
	
	public Farola() {
		encendida = false;
		vecinas = new ArrayList<>(); 
	}
	
	public void pairWithNeighbor(Farola otraFarola) {
		if (!vecinas.contains(otraFarola)) {
			vecinas.add(otraFarola);
			otraFarola.getNeighbors().add(this);
		}
	}
	
	public List<Farola> getNeighbors(){
		return vecinas;
	}
	
	public void turnOn() {
		if (!encendida) {
			encendida = true;
			vecinas.stream()
			.filter(far -> !far.encendida)
			.forEach(far -> far.turnOn());
		}
	}
	
	public void turnOff() {
		if (encendida) {
			encendida = false;
			vecinas.stream()
			.filter(far -> far.encendida)
			.forEach(far -> far.turnOff());
		}
	}
	
	public boolean isOn() {
		return encendida;
	}
	
	
}