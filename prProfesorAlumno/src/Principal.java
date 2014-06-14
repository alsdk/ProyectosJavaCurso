import java.util.Scanner;


public class Principal {

	/**
	 * @param args
	 */
	public static Scanner lector = new Scanner(System.in);

	public static void crearAlumnos(Profesor p) {
		Alumnos alum;
		String nombre;
		
		System.out.print("Introduce nombre del alumno: ");
		nombre = lector.nextLine();
		alum = new Alumnos(nombre);
		if (p.getAlumno1() == null) {
			p.setAlumno1(alum);
		}
		else if (p.getAlumno2() == null) {
			p.setAlumno2(alum);
		}
		else {
			System.out.println("ERROR, no se pude asignar alumno porque no hay sitio");
		}
	}
	
	private static void imprimir(Profesor po) {
		System.out.println("Nombre Profesor: " + po.getNombre());
		if (po.getAlumno1() != null) {
			System.out.println("Nombre Alumno 1: " + po.getAlumno1().getNombre());
			System.out.println("Nota Alumno 1: " + po.getAlumno1().getNota());
		}
		if (po.getAlumno2() != null) {
			System.out.println("Nombre Alumno 2: " + po.getAlumno2().getNombre());
			System.out.println("Nota Alumno 2: " + po.getAlumno2().getNota());
		}
		System.out.println(po.getAlumno1());
	}
	public static void main(String[] args) {
		Profesor profe = new Profesor("Luis");
		crearAlumnos(profe);
		profe.ponerNota1(10);
		crearAlumnos(profe);
		//profe.ponerNota2(6);
		//profe.getAlumno1().getNota();
		imprimir(profe);
	}

}
