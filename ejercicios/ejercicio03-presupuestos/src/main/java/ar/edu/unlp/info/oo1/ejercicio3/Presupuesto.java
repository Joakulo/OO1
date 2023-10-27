package ar.edu.unlp.info.oo1.ejercicio3;

import java.time.LocalDate;
import java.util.*;

public class Presupuesto {
	
	private LocalDate fecha;
	private String cliente;
	private List<Item> items;
	
	public Presupuesto(String cliente) {
		this.cliente = cliente;
		this.fecha = LocalDate.now();
		items = new ArrayList<>();
	}
	
	public LocalDate getFecha() {
		return fecha;
	}
	
	public String getCliente() {
		return cliente;
	}
	
	public void agregarItem(Item item) {
		this.items.add(item);
	}

	public double calcularTotal() {
		return items.stream().mapToDouble(i -> i.costo()).sum();
	}
}
