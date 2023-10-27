package ar.edu.unlp.info.oo1.ejercicio13_correr;

import java.util.*;

public class Carpeta {

	private String nombre;
	private Set<Email> emails;
	
	public Carpeta(String nombre) {
		this.nombre = nombre;
		emails = new HashSet<>();
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void agregarEmail(Email email) {
		emails.add(email);
	}
	
	public void eliminarEmail(Email email) {
		emails.remove(email);
	}
	
	
	//Preguntar
	public Email buscar(String texto) {
		Email buscado = null;
		for (Email email : emails) {
			if (email.contiene(texto)) {
				buscado = email;
				break;
			}
		}
		return buscado;
	}
	
	//Preguntar
	public Email buscarStream(String texto) {
		return emails.stream()
				.filter(email -> email.contiene(texto))
				.findFirst().orElse(null);
	}
	
	
	public int espacioOcupado() {
		return emails.stream()
				.mapToInt(email -> email.espacioOcupado())
				.sum();
	}
}
