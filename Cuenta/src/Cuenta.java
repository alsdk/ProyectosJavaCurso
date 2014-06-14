
public class Cuenta {
	private double saldo;
	private int clave;
	
	public Cuenta() {
		// constructor por defecto
	}
	
	public void setSaldo(double saldo) {
		if (saldo > 0) {
			this.saldo = saldo;
		}
		else {
			System.out.println("ERROR, saldo incorrecto");
		}
	}
	
	public void setClave(int clave) {
		if (clave > 1000 && clave < 9999) { 	// clave de 4 digitos
			this.clave = clave;
		}
		else {
			System.out.println("ERROR, clave incorrecta");
		}
	}
	
	public int getClave() {
		return this.clave;
	}
	
	public double getSaldo() {
		return this.saldo;
	}
	
	public void ingresar(double cantidad) {
		if (cantidad > 0) {
			this.saldo += cantidad;
		}
	}
	
	public void sacar(double cantidad) {
		if (cantidad > 0 && cantidad <= this.saldo) {
			this.saldo -= cantidad;
		}
	}
}
