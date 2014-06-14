
public class Principal {

	/**
	 * @param args
	 */
	// static solo se relacionan con static
	// los procedimientos static solo pueden ser llamados
	// por otro procedimiento static
	// este procedimiento se hace fuera de la clase personas
	// porque no es especifico de la clase personas
	// seria mejor hacer otra clase para imprimir cosas
	// de un objeto
	// imprimir a consola, imprimir a ventana, etc.
	public static void imprimir(Personas per) {
		System.out.println("Nombre: " + per.getNombre());
		System.out.println("Edad: " + per.getEdad());
	}
	
	public static void main(String[] args) {
		// p esta apuntando a un objeto que ya tiene un nombre y edad inicializadas
		// p hereda de la clase Object por defecto
		Personas p = new Personas();
		Personas p1 = new Personas("Maria");
		Personas p2 = null; 		// creamos un objeto en memoria de tamaño p2 pero inicializado a nulo
		
		p1.setEdad(22);
		p.setNombre("Paco");
		p.setEdad(52);
		// p2 apunta a la misma zona de memoria que p1, es decir p2 y p1 son el mismo objeto
		p2 = p1;
		// esto funcionaria si el atributo 'nombre' en la clase Personas fuese public
		/*
		 * 	System.out.println(p.nombre);
		 * 	p.nombre="a";
		 * 
		 */

		imprimir(p);
		imprimir(p1);
		imprimir(p2);
	}

}
