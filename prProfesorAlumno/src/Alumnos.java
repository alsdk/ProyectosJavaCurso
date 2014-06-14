
public class Alumnos {
	private String nombre;
	private double nota;
	
	public Alumnos(String nombre) {
		this.nombre = nombre;
	}
	
	public void setNota(double nota) {
		this.nota = nota;
	}
	
	public double getNota() {
		return nota;
	}
	
	public String getNombre() {
		return nombre;
	}
}
