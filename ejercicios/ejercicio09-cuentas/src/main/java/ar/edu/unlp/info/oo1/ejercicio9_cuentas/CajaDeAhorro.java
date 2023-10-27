package ar.edu.unlp.info.oo1.ejercicio9_cuentas;

public class CajaDeAhorro extends Cuenta{
	
	@Override
	public void depositar(double monto) {
		super.depositar(monto * 0.98);
	}
	
	@Override
	public boolean extraer(double monto) {
		return super.extraer(monto * 1.02);
	}
	
	@Override
	public boolean transferirACuenta(double monto, Cuenta cuentaDestino) {
		return super.transferirACuenta(monto * 1.02, cuentaDestino);
	}
	
	@Override
	public boolean puedeExtraer(double monto) {
		if (this.getSaldo() >= monto ) {
			return true;
		}
		return false;
	}
	
	
}
