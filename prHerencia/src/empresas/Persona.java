package empresas;

public class Persona {
	private String nombre;
	protected double salario;
	
	public Persona (String nombre) {
		this.nombre = nombre;
	}
	public void setNombre(String vnombre) {
		nombre = vnombre;
	}
	
	public void setSalario(double vsalario) {
		salario = vsalario;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public double getSalario() {
		return salario;
	}
	
	public double calcularSalario() {
		return salario;
	}
}
