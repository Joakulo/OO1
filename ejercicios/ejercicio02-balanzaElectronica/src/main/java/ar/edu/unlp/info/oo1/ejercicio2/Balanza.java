package ar.edu.unlp.info.oo1.ejercicio2;

public class Balanza {

	private int cantidadDeProductos;
	private double precioTotal;
	private double pesoTotal;
	
	public int getCantidadDeProductos() {
		return cantidadDeProductos;
	}
	
	public double getPesoTotal() {
		return pesoTotal;
	}
	
	public double getPrecioTotal() {
		return precioTotal;
	}
	
	public void ponerEnCero()
	{
		cantidadDeProductos = 0;
		precioTotal = 0;
		pesoTotal = 0;
	}
	
	public void agregarProducto (Producto producto)
	{
		cantidadDeProductos++;
		precioTotal+=producto.getPrecio();
		pesoTotal+=producto.getPeso();
	}
	
	public Ticket emitirTicket()
	{
		Ticket ticket = new Ticket(cantidadDeProductos, pesoTotal, precioTotal);
		return ticket;
	}
}
