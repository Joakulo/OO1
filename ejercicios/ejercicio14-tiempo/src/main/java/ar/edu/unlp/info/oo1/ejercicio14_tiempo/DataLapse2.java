package ar.edu.unlp.info.oo1.ejercicio14_tiempo;

import java.time.LocalDate;

public class DataLapse2 implements IDataLapse{

	private LocalDate from;
	private int sizeInDays;
	
	public DataLapse2(LocalDate from, int sizeInDays) {
		this.from = from;
		this.sizeInDays = sizeInDays;
	}
	
	@Override
	public LocalDate getFrom() {
		return from;
	}

	@Override
	public int getSizeInDays() {
		return sizeInDays;
	}
	
	@Override
	public LocalDate getTo() {
		return from.plusDays(sizeInDays);
	}

	@Override
	public boolean includesDate(LocalDate other) {
		return (from.isBefore(other) && other.isBefore(from.plusDays(sizeInDays)));
	}

}
