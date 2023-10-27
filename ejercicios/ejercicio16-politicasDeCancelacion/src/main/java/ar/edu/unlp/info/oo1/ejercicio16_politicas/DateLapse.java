package ar.edu.unlp.info.oo1.ejercicio16_politicas;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class DateLapse {
	
	private LocalDate from;
	private LocalDate to;
	
	public DateLapse(LocalDate from, LocalDate to) {
		this.from = from;
		this.to = to;
	}
	
	public LocalDate getFrom() {
		return from;
	}
	
	public LocalDate getTo() {
		return to;
	}
	
	public int getSizeInDays() {
		return (int) from.until(to, ChronoUnit.DAYS);
	}
	
	public boolean includesDate(LocalDate other) {
		return (from.isBefore(other) && other.isBefore(to));
	}

	public boolean overlaps(DateLapse otroDataLapse) {
		return (from.minusDays(1).isBefore(otroDataLapse.getFrom()) && to.plusDays(1).isAfter(otroDataLapse.getFrom())) 
				||
				(from.minusDays(1).isBefore(otroDataLapse.getTo()) && to.plusDays(1).isAfter(otroDataLapse.getTo()))
				||
				(otroDataLapse.includesDate(from) || otroDataLapse.includesDate(to));
	}
	
}
