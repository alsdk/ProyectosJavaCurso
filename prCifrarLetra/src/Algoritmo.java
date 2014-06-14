
public class Algoritmo {
	private char letra;
	private int contador;
	
	// desplazar la letra introducida 'contador' veces
	public Algoritmo(int contador) {
		this.contador = contador;
	}
	
	public char getLetra() {
		return this.letra;
	}
	
	public void setLetra(char letra) {
		this.letra = letra;
	}
	
	public char cifrar() {
		char letra_cifrada = ' ';
		
		letra_cifrada = (char)((int)letra + contador);
		return letra_cifrada;
	}
	
	public char descifrar(char letraC) {
		char letra = ' ';
		
		letra = (char)((int)letraC - contador);
		return letra;
	}
}
