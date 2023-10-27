package ar.edu.unlp.info.oo1.ejercicio9_cuentas;

public class CuentaCorriente extends Cuenta{

	private double limiteDeDescubierto;
	
	public CuentaCorriente() {
		super();
		this.limiteDeDescubierto = 0;
	}
	
	public void setLimiteDeDescubierto(double limite) {
		this.limiteDeDescubierto = limite;
	}
	
	public double getLimiteDeDescubierto() {
		return this.limiteDeDescubierto;
	}
	
	@Override
	public boolean puedeExtraer(double monto) {
		if (this.saldo - monto >= this.limiteDeDescubierto) {
			return true;
		}
		return false;
	}

}
