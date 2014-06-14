package empresas;

public class Vendedor extends Persona {
	private int numeroVentas;
	
	public Vendedor(String nombre, int ventas) {
		super(nombre);
		this.numeroVentas = ventas;
	}
	public void setNumeroVentas(int ventas) {
		numeroVentas = ventas;
	}
	
	public int getNumeroVentas() {
		return numeroVentas;
	}
	
	public double calcularSalario() {
		if (numeroVentas > 10)
			return salario+100;
		else
			return salario;
	}
}
