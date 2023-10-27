package ar.edu.unlp.info.oo1.ejercicio14_tiempo;

import java.time.LocalDate;

public interface IDataLapse {
	
	public LocalDate getFrom();
	
	public LocalDate getTo();
	
	public int getSizeInDays();
	
	public boolean includesDate(LocalDate other);
}
