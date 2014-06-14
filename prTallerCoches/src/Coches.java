
public class Coches {
	// variables de clase
	private String modelo, averia;
	private int horas;
	
	// constructores
	public Coches(String modelo, String averia) {
		this.modelo = modelo;
		this.averia = averia;
	}
	
	public Coches(String modelo) {
		this.modelo = modelo;
	}
	
	// metodos y funciones de la clase
	public void setHoras(int horas) {
		this.horas = horas;
	}
	
	public void setAveria(String averia) {
		this.averia = averia;
	}
	
	public String getModelo() {
		return modelo;
	}
	
	public String getAveria() {
		return averia;
	}
	
	public int getHoras() {
		return horas;
	}
	
	public String toString() {
		return "Modelo: " + modelo + "\nAveria: " + averia + "\nHoras: " + horas;
	}
}
