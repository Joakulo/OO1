package ar.edu.unlp.info.oo1.ejercicio12_solidos;

public class Esfera extends Pieza{

	private int radio;
	
	public Esfera(String material, String color, int radio) {
		super(material, color);
		this.radio = radio;
	}

	@Override
	public double getVolumen() {
		return ( 4.0 / 3.0 * Math.PI * Math.pow(radio, 3));
	}

	@Override
	public double getSuperficie() {
		return (4 * Math.PI * Math.pow(radio, 3));
	}
}
