package ar.edu.unlp.info.oo1.ejercicio17_facturacionDeLlamadas;

public class PersonaJuridica extends Persona {

	private String CUIT;
	private String tipo;
	
	public PersonaJuridica(int numero, String nombre, String direccion, String CUIT, String tipo) {
		super(numero, nombre, direccion);
		this.CUIT = CUIT;
		this.tipo = tipo;
	}

	@Override
	public double aplicarDescuento(double monto) {
		return monto;
	}

}
