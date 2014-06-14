package operaciones;
import operacion.Operacion;

public class OperacionChar implements Operacion {

	private char [] numeros;
	
	public OperacionChar(int s) {
		numeros = new char [s];
		
		for (int i = 0; i < numeros.length; ++i)
			numeros[i] = '-';
	}
	
	@Override
	public void sumar(int pos) {
		int nuevaPos = 0;
		
		for (int i = 0; i < numeros.length; i++) {
			nuevaPos = (int)numeros[i] + pos;
			if (numeros[i] == '-')							// posicion vacia: no hago nada
				continue;
			else if (nuevaPos >= 97 && nuevaPos <= 122)	 	// caso normal a-z
				numeros[i] = (char)nuevaPos;
			else											// nos pasamos de 'z'
				numeros[i] = (char)((nuevaPos - 122) + 96);
		}
	}

	@Override
	public void restar(int pos) {
		int nuevaPos = 0;
		
		for (int i = 0; i < numeros.length; i++) {
			nuevaPos = (int)numeros[i] - pos;
			if (numeros[i] == '-')							// posicion vacia: no hago nada
				continue;
			else if (nuevaPos >= 97 && nuevaPos <= 122)	 	// caso normal a-z
				numeros[i] = (char)nuevaPos;
			else								// menor que 'a' (97 dec ascii)
				numeros[i] = (char)((nuevaPos - 97) + 123 );
		}
	}

	@Override
	public void listar() {
		for (char numero : numeros)
			System.out.print(numero + " ");
		System.out.println();
		
	}

	@Override
	public void introducir(int num) {
		boolean encontrado = false;
		
		for (int i = 0; i < numeros.length && !encontrado; ++i) {
			if (numeros[i] == '-') {
				numeros[i] = Character.toLowerCase((char)num);
				encontrado = true;
			}
		}
		if (!encontrado)
			System.out.println("ERROR, no hay mas sitio para " + (char)num);
		else
			System.out.println((char)num + " introducido satisfactoriamente");
	}

}
