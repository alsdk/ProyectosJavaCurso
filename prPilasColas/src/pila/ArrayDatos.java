package pila;

public class ArrayDatos {
	static protected int contador = 1;
	protected String [] palabras;
	
	// el constructor crea un array palabras[] de tamanyo 's'
	public ArrayDatos(int s) {
		palabras = new String[s];
	}
	
	public int getLongitud() {
		return palabras.length;
	}

	// devuelve una posicion aleatoria valida (< palabras.length) 
	// para el array palabras[]
	private int getPosicionAleatoria() {
		int pos = 0;
		int i = 0; 		// contador para no entrar en bucle infinito si el array esta lleno de primeras

		// voy haciendo random hasta encontrar un numero que sirva de posicion para palabras[]
		// menor que palabras.length y este a nulo (no haya otra cadena en el array)
		do {
			pos = (int)(Math.random() * getLongitud());
			i++;
		}
		while (palabras[pos] != null && i < palabras.length);
		
		return pos;
	}
	
	// inserta una palabra en el array en una posicion aleatoria
	// que este a null.
	public void insertar(String p) {
		int pos = 0;

		// hay espacio para mas palabras ?
		if (contador <= getLongitud()) {
			// pido posiciones hasta encontrar una que este a null 
			do {
				pos = getPosicionAleatoria();
			} while (palabras[pos] != null);
			
			palabras[pos] = p;
			contador++;
			System.out.println("[+] '" + p + "' insertado satisfactoriamente");
		}
		else
			System.out.println("[-] ERROR, No hay mas espacio en palabras[] para introducir '" + p + "'");
		
	}
	
	// devuelve la posicion de 'palabra' en el array palabras[] o -1 si no esta
	public int buscar(String palabra) {
		int pos = 0;
		
		for (pos = 0; pos < palabras.length && !palabra.equalsIgnoreCase(palabras[pos]); pos++);
		if (pos == palabras.length)
			return -1;
		else
			return pos;
	}
	
	// elimina el contenido de una posicion aleatoria, si esta contiene un String
	// sino vuelve a buscar otra posicion y lo intenta 
	public void eliminar() {
		int pos = 0;
		
		// buscamos una posicion no vacia
		do {
			pos = getPosicionAleatoria();
		} while(palabras[pos] == null);
		
		System.out.println("[+] palabras[" + pos + "] eliminado: " + palabras[pos]);
		palabras[pos] = null;
	}
	
	public void listar() {
		System.out.println("===================");
		for (int i = 0; i < getLongitud(); ++i)
			System.out.println("palabras[" + i + "]: " + palabras[i]);
		System.out.println("===================");
	}
	
}
