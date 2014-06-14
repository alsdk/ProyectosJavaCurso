package pila;

public class Pila extends ArrayDatos {
	
	// crear un array de String de tamanyo 's'
	public Pila(int s) {
		super(s);
	}
	
	@Override
	public void insertar(String p) {
		// copiar el nuevo String si el ultimo elemento esta a nulo
		if (palabras[getLongitud() - 1] == null) {
			// bucle para mover el contenido del array palabras[] una posicion a la derecha
			for (int i = getLongitud() - 1; i-1 >= 0; --i) {
				palabras[i] = palabras[i - 1];
			}
			
			// despues de mover el array tenemos hueco en la primera posicion
			palabras[0] = p;
			System.out.println("[+] '" + p + "' insertado satisfactoriamente");
		}
		else
			System.out.println("[-] ERROR, no hay mas sitio en el array para '" + p + "'");
	}

	@Override
	public void eliminar() {
		String aux = palabras[0];
		
		// si el primer elemento es nulo es que no queda nada por borrar
		if (palabras[0] != null) {
			// desplazamos a la izquierda
			for (int i = 0; i+1 < getLongitud(); ++i)
				palabras[i] = palabras[i+1];
			
			// marcamos como libre el ultimo elemento
			palabras[getLongitud()-1] = null;
			System.out.println("[+] '" + aux + "' eliminado");
		}
		else
			System.out.println("[-] ERROR, palabras[] ya esta vacio");

	}
}
