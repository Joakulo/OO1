package ar.edu.unlp.info.oo1.ejercicio8_distribuidora;

import java.util.*;

public class Distribuidora {

	private double precioKWh;
	private List<Usuario> usuarios;

	public Distribuidora(double precioKWh) {
		this.precioKWh = precioKWh;
		usuarios = new ArrayList<>();
	}
	
	public void agregarUsuario(Usuario usuario) {
		this.usuarios.add(usuario);
	}

	public List<Factura> facturar(){
		List<Factura> facts = new ArrayList<>();
		for (Usuario user : usuarios) {
			facts.add(user.facturarEnBaseA(precioKWh));
		}
		return null;
	}

	public double consumoTotalActiva() {
		double total = 0;
		for (Usuario user : usuarios) {
			total += user.ultimoConsumoActiva();
		}
		return total;
	}

	public void setPrecioKWh(double precio) {
		this.precioKWh = precio;
	}
	
	public double getPrecioKWh() {
		return precioKWh;
	}
	
	public List<Usuario> getUsuarios(){
		return usuarios;
	}
}