package ar.edu.unlp.info.oo1.ejercicio13_correr;

import java.util.*;

public class ClienteDeCorreo {

	private Carpeta inbox;
	private Set<Carpeta> carpetas;
	
	public ClienteDeCorreo() {
		inbox = new Carpeta("inbox");
		carpetas = new HashSet<>();
	}
	
	public void agegarCarpeta(Carpeta carpeta) {
		carpetas.add(carpeta);
	}
	
	public void recibir(Email email) {
		inbox.agregarEmail(email);
	}
	
	public void mover(Email email, Carpeta origen, Carpeta destino) {
		origen.eliminarEmail(email);
		destino.agregarEmail(email);
	}
	
	public Email buscar(String texto) {
		Email buscado = null;
		
		buscado = inbox.buscar(texto);
		if (buscado != null) 
			return buscado;
		
		for (Carpeta carpeta : carpetas) {
			buscado = carpeta.buscar(texto);
			if (buscado != null) break;
		}
		
		return buscado;
	}
	
	public Email buscarStream(String texto) {
		return carpetas.stream()
						.map(carpeta -> carpeta.buscar(texto))
						.findFirst().orElse(null);
	}
	
	public int espacioOcupado() {
		return inbox.espacioOcupado() + carpetas.stream()
												.mapToInt(car -> car.espacioOcupado())
												.sum();
	}
}