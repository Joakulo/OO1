package ar.edu.unlp.info.oo1.ejercicio17_facturacionDeLlamadas;

public class PersonaFisica extends Persona {

	private String dni;
	
	public PersonaFisica(int numero, String nombre, String direccion, String dni) {
		super(numero, nombre, direccion);
		this.dni = dni;
	}

	@Override
	public double aplicarDescuento(double monto) {
		return monto * 0.9;
	}

}
