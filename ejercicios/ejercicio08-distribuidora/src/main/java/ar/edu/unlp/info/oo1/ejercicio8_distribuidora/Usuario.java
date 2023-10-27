package ar.edu.unlp.info.oo1.ejercicio8_distribuidora;

import java.util.*;

public class Usuario {

	private String domicilio;
	private String nombre;
	private List<Factura> facturas;
	private List<Consumo> consumos;
	
	public Usuario(String domicilio, String nombre) {
		this.domicilio = domicilio;
		this.nombre = nombre;
		facturas = new ArrayList<>();
		consumos = new ArrayList<>();
	}
	
	public void agregarMedicion(Consumo medicion) {
		consumos.add(medicion);
	}
	
	public double ultimoConsumoActiva() {
		return this.ultimoConsumo().getConsumoEnergiaActiva();
	}
	
	public Factura facturarEnBaseA(double precioKWh) {
		Consumo ultimoConsumo = this.ultimoConsumo();
		
		if (ultimoConsumo == null) {
			return new Factura(0, 0, this);
		}
		
		double descuento = 0;
		if (ultimoConsumo.factorDePotencia() > 0.8) {
			descuento = 10;
		}
		
		Factura fact = new Factura(ultimoConsumo.costoEnBaseA(precioKWh), descuento, this);
		this.facturas.add(fact);
		return fact;
	}
	
	public List<Factura> getFacturas(){
		return this.facturas;
	}
	
	private Consumo ultimoConsumo() {
		return consumos.get(consumos.size() - 1);
	}
	
	public String getDomicilio() {
		return this.domicilio;
	}
	
	public String getNombre() {
		return this.nombre;
	}
}
