package ar.edu.unlp.info.oo1.ejercicio7;

public class EmpleadosTest {

	public static void main(String[] args) {
		Gerente alan = new Gerente("Alan Turing");
		double aportesDeAlan = alan.aportes();
		/* Gerente.aportes()
		 * Gerente.montoBasico()
		 */
		
		Gerente alan2 = new Gerente("Alan Turing");
		double sueldoBasicoDeAlan = alan2.sueldoBasico();
		/* EmpleadoJerarquico.sueldoBasico()
		 * Empleado.sueldoBasico()
		 * Gerente.montoBasico()
		 * Gerente.aportes()
		 * EmpleadoJerarquico.bonoPorCategoria()
		 */
		System.out.println("1) " + aportesDeAlan);
		System.out.println("2) " + sueldoBasicoDeAlan);

	}

}
