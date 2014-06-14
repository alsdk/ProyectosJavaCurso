package operaciones;

import algoritmo.Algoritmo;

public class AlgoritmoProducto implements Algoritmo {

	private int secreto;
	
	public AlgoritmoProducto(int secreto) {
		this.secreto = secreto;
	}
	@Override
	public int cifrar(int num) {
		return num + secreto;
	}

	@Override
	public int descifrar(int num) {
		return num - secreto;
	}

	public int getSecreto() {
		return secreto;
	}
}
