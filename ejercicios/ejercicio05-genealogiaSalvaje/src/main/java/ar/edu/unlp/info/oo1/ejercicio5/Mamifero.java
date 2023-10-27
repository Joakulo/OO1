package ar.edu.unlp.info.oo1.ejercicio5;

import java.time.LocalDate;

public class Mamifero {

	private String identificador;
	private String especie;
	private LocalDate fechaNacimiento;
	private Mamifero madre;
	private Mamifero padre;
	
	public Mamifero() {
		
	}
	
	public Mamifero(String identificador) {
		this.identificador = identificador;
	}
	
	public String getIdentificador() {
		return identificador;
	}
	
	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}
	
	public String getEspecie() {
		return especie;
	}
	
	public void setEspecie(String especie) {
		this.especie = especie;
	}
	
	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}
	
	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	
	public Mamifero getMadre() {
		return madre;
	}
	
	public void setMadre(Mamifero madre) {
		this.madre= madre;
	}
	
	public Mamifero getPadre() {
		return padre;
	}
	
	public void setPadre(Mamifero padre) {
		this.padre= padre;
	}
	
	public Mamifero getAbuelaMaterna() {
		if (madre != null && madre.getMadre() != null)
			return madre.getMadre();
		return null;
	}
	
	public Mamifero getAbueloMaterno() {
		if (madre != null && madre.getPadre() != null)
			return madre.getPadre();
		return null;
	}
	
	public Mamifero getAbuelaPaterna() {
		if (padre != null && padre.getMadre() != null)
			return padre.getMadre();
		return null;
	}
	
	public Mamifero getAbueloPaterno() {
		if (padre != null && padre.getPadre() != null)
			return padre.getPadre();
		return null;
	}
	
	public boolean tieneComoAncestroA(Mamifero unMamifero) {
		if (this.getMadre() != null) {
			if (this.getMadre().equals(unMamifero)) {
				return true;
			} else {
				if (this.getMadre().tieneComoAncestroA(unMamifero))
					return true;
			}
		}
		
		if (this.getPadre() != null) {
			if (this.getPadre().equals(unMamifero)) {
				return true;
			} else {
				if (this.getPadre().tieneComoAncestroA(unMamifero))
					return true;
			}
		}
		
		return false;
	}
}
