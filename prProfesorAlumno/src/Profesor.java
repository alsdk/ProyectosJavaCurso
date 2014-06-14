
public class Profesor {
	private String nombre;
	private Alumnos alumno1;
	private Alumnos alumno2;
	
	public Profesor(String nombre) {
		this.nombre = nombre;
	}
	
	public void setAlumno1(Alumnos alumno1) {
		if (alumno1 != null) {
			this.alumno1 = alumno1;
		}
		else {
			System.out.println("ERROR, alumno1 vacio");
		}
	}
	
	public void setAlumno2(Alumnos alumno2) {
		if (alumno2 != null) {
			this.alumno2 = alumno1;
		}
		else {
			System.out.println("ERROR, alumno2 vacio");
		}
	}
	
	public void ponerNota1(double nota) {
		if (alumno1 != null)
			alumno1.setNota(nota);
		else
			System.out.println("ERROR, no hay alumno");
	}
	
	public void ponerNota2(double nota) {
		if (alumno2 != null)
			alumno2.setNota(nota);
		else
			System.out.println("ERROR, no hay alumno");
	}
	
	public void ponerNota(String nombre, double nota) {
		if (alumno1 != null && alumno1.getNombre().equals(nombre)) {
			alumno1.setNota(nota);
		}
		else if (alumno2 != null && alumno2.getNombre().equals(nombre)) {
			alumno2.setNota(nota);
		}
		else {
			System.out.println("ERROR, nombre no existente");
		}
	}
	
	public Alumnos getAlumno1() {
		return alumno1;
	}
	
	public Alumnos getAlumno2() {
		return alumno2;
	}
	
	public String getNombre() {
		return nombre;
	}
}
