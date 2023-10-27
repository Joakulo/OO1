package ar.edu.unlp.info.oo1.ejercicio2;

public class Producto {
	
	
	private double peso;
	private double precioPorKilo;
	private String descripcion;
	
	public void setPeso(double peso) {
		this.peso = peso;
	}
	
	public double getPeso() {
		return peso;
	}
	
	public void setPrecioPorKilo(double precio) {
		this.precioPorKilo = precio;
	}
	
	public double getPrecioPorKilo() {
		return precioPorKilo;
	}
	
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	
	public double getPrecio() {
		return peso * precioPorKilo;
	}
}
