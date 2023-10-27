package ar.edu.unlp.info.oo1.ejercicio3bis;

import java.time.LocalDate;
import java.util.*;

public class Ticket {

	private LocalDate fecha;
	private List<Producto> productos;
	
	public Ticket()
	{	
	}
	
	public Ticket(List<Producto> productos)
	{
		this.fecha = LocalDate.now();
		this.productos = productos;
	}
	
	public LocalDate getFecha() {
		return fecha;
	}
	
	public int getCantidadDeProductos() {
		return productos.size();
	}
	
	public double getPesoTotal() {
		return productos.stream().mapToDouble(p -> p.getPeso()).sum();
	}
	
	public double getPrecioTotal() {
		return productos.stream().mapToDouble(p -> p.getPrecio()).sum();
	}
	
	public double impuesto()
	{
		return this.getPrecioTotal() * 0.21;
	}
}
