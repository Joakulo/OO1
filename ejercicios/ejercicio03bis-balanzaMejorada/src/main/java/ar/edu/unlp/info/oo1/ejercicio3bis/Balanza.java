package ar.edu.unlp.info.oo1.ejercicio3bis;

import java.util.*;;

public class Balanza {

	private List<Producto> productos;
	
	public Balanza() {
		productos = new ArrayList<>();
	}
	
	public List<Producto> getProductos(){
		return productos;
	}
	
	public void ponerEnCero()
	{
		productos.clear();
	}
	
	public void agregarProducto (Producto producto)
	{
		productos.add(producto);
	}
	
	public Ticket emitirTicket()
	{
		Ticket ticket = new Ticket(productos);
		return ticket;
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
}
