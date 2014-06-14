package empresas;

public class Operadores extends Persona{		// operadores hereda de persona, todo lo que sea public, protected y default
	private int llamadas;
	
	public Operadores(int llamadas) {
		super(null);		// llama al constructor de la clase padre (Persona) y le pasa null como nombre
		this.llamadas = llamadas;
	}
	
	public void setLlamadas(int vllamadas) {
		llamadas = vllamadas;
	}

	public int getLlamadas() {
		return llamadas;
	}
	
	public double calcularSalario() {
		// la idea es si el usuario a hecho entre 0 y 30 llamadas se le incrementa un 5% el salario
		// si ha hecho mas de 30 llamadas se le incrementa un 10%
		// salario esta en la clase padre Persona
		if (llamadas < 30)
			return salario * 1.05;				// salario es del mismo paquete
		else
			return salario * 1.10;
	}
}
