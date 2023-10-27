package ar.edu.unlp.info.oo1.ejercicio14_tiempo;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class DataLapse implements IDataLapse {
	
	private LocalDate from;
	private LocalDate to;
	
	public DataLapse(LocalDate from, LocalDate to) {
		this.from = from;
		this.to = to;
	}
	
	@Override
	public LocalDate getFrom() {
		return from;
	}
	
	@Override
	public LocalDate getTo() {
		return to;
	}
	
	@Override
	public int getSizeInDays() {
		return (int) from.until(to, ChronoUnit.DAYS);
	}
	
	@Override
	public boolean includesDate(LocalDate other) {
		return (from.isBefore(other) && other.isBefore(to));
	}

}
