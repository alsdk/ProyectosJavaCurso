
public class Rectangulo {
	private double base, altura;
	
	// constructores
	public Rectangulo() {	
	}
	
	public Rectangulo(double base, double altura) {
		this.base = base;
		this.altura = altura;
	}
	
	// funciones y metodos
	public double getBase() {
		return base;
	}
	
	public double getAltura() {
		return altura;
	}
	
	public void setBase(double base) {
		this.base = base;
	}
	
	public void setAltura(double altura) {
		this.altura = altura;
	}
	
	public double calcularArea() {
		// A = b * h
		return base * altura;
	}
	
	public double calcularPerimetro() {
		// P = 2 * (b + h)
		return 2 * (base + altura);
	}
	
}