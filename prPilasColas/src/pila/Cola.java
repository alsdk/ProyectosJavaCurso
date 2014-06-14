package pila;

public class Cola extends ArrayDatos {
	
	// construye un array de String de tamanyo 's'
	public Cola(int s) {
		super(s);
	}
	
	@Override
	public void insertar(String p) {
		// copiar el nuevo String si el ultimo elemento esta a nulo
		if (palabras[0] == null) {
			// bucle para mover el contenido del array palabras[] una posicion a la izquierda
			for (int i = 0; i+1 < getLongitud(); ++i) {
				palabras[i] = palabras[i + 1];
			}
					
			// despues de mover el array tenemos hueco en la ultima posicion (primera de la cola)
			palabras[getLongitud() - 1] = p;
			System.out.println("[+] '" + p + "' insertado satisfactoriamente");
		}
		else
			System.out.println("[-] ERROR, no hay mas sitio en el array para '" + p + "'");
	}

	@Override
	public void eliminar() {
		String aux = palabras[getLongitud()-1];
		
		// si la ultima posicion esta a null, ya no queda mas por eliminar
		if (palabras[getLongitud()-1] != null) {
			// desplazo hacia la derecha
			for (int i = getLongitud() - 1; i-1 >= 0; --i)
				palabras[i] = palabras[i-1];
			
			// marcar el primer elemento a nulo
			palabras[0] = null;
			System.out.println("[+] '" + aux + "' eliminado");
		}
		else
			System.out.println("[-] ERROR, palabras[] ya esta vacio");
	}
}
