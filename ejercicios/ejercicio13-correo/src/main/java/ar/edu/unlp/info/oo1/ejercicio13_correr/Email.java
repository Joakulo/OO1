package ar.edu.unlp.info.oo1.ejercicio13_correr;

import java.util.*;

public class Email {

	private String titulo;
	private String cuerpo;
	private Set<Archivo> adjuntos;
	
	public Email(String titulo, String cuerpo) {
		this.titulo = titulo;
		this.cuerpo = cuerpo;
		adjuntos = new HashSet<>();
	}
	
	public String getTitulo() {
		return titulo;
	}
	
	public String getCuerpo() {
		return cuerpo;
	}
	
	public void agregarAdjunto(Archivo archivo) {
		adjuntos.add(archivo);
	}
	
	public Set<Archivo> getAdjuntos(){
		return adjuntos;
	}
	
	public boolean contiene(String texto) {
		return (this.getTitulo().equals(texto) || this.getCuerpo().equals(texto));
	}
	
	public int espacioOcupado() {
		int adjuntosTam = adjuntos.stream()
								.mapToInt(adj -> adj.getTamaño())
								.sum();
		return titulo.length() + cuerpo.length() + adjuntosTam;
	}
}
