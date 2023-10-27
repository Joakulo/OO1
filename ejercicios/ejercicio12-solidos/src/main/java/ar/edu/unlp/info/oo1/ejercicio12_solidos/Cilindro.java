package ar.edu.unlp.info.oo1.ejercicio12_solidos;

public class Cilindro extends Pieza{

	private int radio;
	private int altura;
	
	public Cilindro(String material, String color, int radio, int altura) {
		super(material, color);
		this.radio = radio;
		this.altura = altura;
	}

	@Override
	public double getVolumen() {
		return (Math.PI * Math.pow(radio, 2) * altura);
	}

	@Override
	public double getSuperficie() {
		return ( (2 * Math.PI * radio * altura) + ( 2 * Math.PI * Math.pow(radio, 2)) );
	}

}
