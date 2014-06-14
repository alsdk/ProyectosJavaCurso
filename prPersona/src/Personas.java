
public class Personas {
	// 1- propiedades, atributos, caracteristicas de la clase
	// las caracteristicas son siempre privadas
	// si fuera publico en cualquier sitio de mi proyecto
	// (otra clase) podria cambiar la edad
	// privado significa que solo se podra ver y cambiar dentro
	// de esta clase (mayor control)
	// por EJ 'private edad'
	// estas variables de instancia no se inicializan
	// a diferencia de las variables locales
	// String se inicializa a NULL
	// char se inicializa al caracter nulo (0 hexadecimal)
	// int se inicializa a 0
	// double se inicializa a 0.0
	// boolean se inicializa a FALSE
	private String nombre;
	private int edad;
	
	// 2- constructor
	// es dar un valor de partida a la hora de la creacion (new) del objeto Personas
	// es siempre publico porque sino no puedo construir el objeto (no tendriamos acceso desde fuera para construir)
	// tiene que ser exactamente el mismo nombre que la clase.
	// Java tiene un constructor por defecto si no ponemos ninguno:
	// public Personas() {
	// }
	public Personas() {
		nombre = "Jose";
		edad = 10;
	}
	
	// 2.1- otro constructor pero esta vez tiene como argumento una cadena con el nombre
	// cuando construya desde main -> Personas p;
	// p apunta a nulo
	// p = new Personas();
	// 'p' ahora apunta a una zona de memoria donde 'nombre' es nulo, 'edad' es 0
	// es decir con Personas p; solamente RESERVAMOS memoria para ese objeto y con new hacemos la inicializacion
	// o instanciacion del objeto en memoria.
	// p = new Personas(); buscara al primer constructor
	// p = new Personas("Manolo"); llama a este segundo constructor
	// a esto se le llama SOBRECARGA porque tenemos varias maneras de invocar a Personas 
	// dependiendo de los argumentos a la hora de la instanciacion.
	// esta variable String nombre es local a este constructor.
	// los constructores en resumen no tienen valor de retorno y se declaran como la clase
	public Personas(String nombre) {
		// this.variable se refiere a atributos de la clase
		this.nombre = nombre;
	}
	
	// 3- comportamiento de la clase (METODOS)
	// son procedimientos y funciones
	// vamos a crear un metodo para cambiar el nombre (private) desde fuera de esta clase
	public void setNombre(String nombre){
		// como usamos nombre para la var q viene de fuera
		// y para el nombre local que es privado
		// ponemos this.nombre para referirnos a la variable de la clase
		// sobreescrimos nombre = "Jose" (si usasemos el constructor primero)
		this.nombre = nombre;
		this.edad = edad;
	}
	
	// la diferencia entre un metodo y una funcion es que los primeros no tienen
	// valor de retorno (void) mientras que las funciones si devuelven valores (solo uno).
	// Los procedimientos/funciones empiezan en minusculas y si son nombres compuestos
	// se escribe la primera letra en mayusculas, al contrario que las clases que empiezan
	// en mayusculas por convencion
	public String getNombre() {
		// return [variable | valor | expresion ]
		// return -> devolver valor al finalizar la funcion
		// despues de llamar a return las intrucciones de debajo
		// no se ejecutan.
		// El valor de retorno del return coincide con el tipo de valor de retorno
		// declarado en la funcion (String)
		return this.nombre;
	}
	
	public void setEdad(int edad) {
		if (edad >= 0 && edad <= 120) {
			this.edad = edad;
		}
		else {
			System.out.println("Error, edad incorrecta");
		}
	}
	
	public int getEdad() {
		return this.edad;
	}
}
