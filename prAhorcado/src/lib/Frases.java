package lib;

public class Frases {
	// palabras es el array con lo que tenemos que adivinar
	private char [] palabras;
	private char [] encontrado;

	public Frases(int s) {
		// el constructor define el tamaño de la palabra
		palabras = new char[s];
		encontrado = new char [s];
		
		// inicializar los arrays con guiones
		for (int i = 0; i < palabras.length; ++i) {
			palabras[i] = '-';
			encontrado[i] = '-';
		}
	}
		
	// introduce una letra en el array palabras[] si hay espacio para ella '-'
	public void introducir (char c) {
		// flag para salir del bucle
		boolean introducido = false;
		
		for (int i = 0; i < palabras.length && !introducido; ++i) {
			if (palabras[i] == '-') {
				palabras[i] = c;
				introducido = true;
			}
		}
	}
	
	public int eliminar(char c) {
		// cada letra que se encuentre del array palabras[] las ponemos en
		// encontrado[] y ponemos un guion  en la posicion de la letra en palabras[]
		int letras_eliminadas = 0;

		for (int i = 0; i < palabras.length; ++i) {
			if (palabras[i] == c) {
				encontrado[i] = palabras[i];
				palabras[i] = '-';
				letras_eliminadas++;
			}
		}

		return letras_eliminadas;
	}
	
	// busca una letra en palabras[]
	// devuelve el indice donde se encuentra la primera ocurrencia de 'c'
	// -1 si no esta en el array
	public int buscar(char c) {
		int pos = -1;
		
		for (int i = 0; i < palabras.length; ++i) {
			if (palabras[i] == c)
				pos = i;
		}
		
		return pos;
	}
	
	// devuelve el caracter que se encuentra en la posicion 'pos' de palabras[]
	public char buscar(int pos) {
		return palabras[pos];
	}
	
	// imprime los aciertos que llevamos
	public void imprimir() {
		for (char pal : encontrado)
			System.out.print(pal);
		System.out.println();
	}
	
	public int getLongitud() {
		return palabras.length;
	}
	
	public int numIntentos() {
		return palabras.length + 2;
	}
}
