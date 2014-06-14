
public class Triangulo {
	// variables de clase
	private double base, altura;
	
	// constructores
	public Triangulo() {
		
	}
	
	public Triangulo(double base, double altura) {
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
		// A = (b * h) / 2
		return (base * altura) / 2;
	}
	
	private double getHipotenusa() {
		// a^2 = b^2 + c^2
		return Math.sqrt(Math.pow(base, 2) + Math.pow(altura, 2));
	}
	
	public double calcularPerimetro() {
		// P = base + altura + hipotenusa
		return base + altura + this.getHipotenusa();
	}
	
}