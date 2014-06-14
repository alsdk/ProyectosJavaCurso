package operaciones;
import operacion.Operacion;

public class OperacionEntero implements Operacion {

	private int [] numeros;
	
	public OperacionEntero(int s) {
		numeros = new int [s];
	}
	
	@Override
	public void sumar(int pos) {
		/* CREAR UN ARRAY AUXILIAR Y DESPLAZAR EN EL
		int [] numeros2 = new int [numeros.length];
		
		if (pos <= numeros.length) {
			for (int i = 0; i < numeros.length; ++i) {
				if (i + pos >= numeros.length)
					numeros2[(i + pos) - numeros.length] = numeros[i];
				else
					numeros2[i+pos] = numeros[i];
			}
		}
		else
			System.out.println("ERROR, el desplazamiento no puede ser mayor que " + (numeros.length+1));

		for (int i = 0; i < numeros.length; ++i)
			numeros[i] = numeros2[i];
		*/
		
		int numAnt = 0;
		int aux = 0;
		int comienzo = 0;
		
		while (comienzo < pos) {
			for (int i = comienzo; i < numeros.length; i+=pos) {		// me desplazo por el array de pos en pos
				aux = numeros[i]; 										
				numeros[i] = numAnt;
				numAnt = aux;
				
			}
			comienzo++;
		}
		numeros[0] = numAnt;
	}

	@Override
	public void restar(int pos) {
		/* USANDO ARRAY AUXILIAR
		int [] numeros2 = new int[numeros.length];
		
		if (pos <= numeros.length) {
			for (int i = 0; i < numeros.length; ++i) {
				if (i - pos < 0)
					numeros2[numeros.length + (i - pos)] = numeros[i];
				else
					numeros2[i - pos] = numeros[i];
			}
		}
		else
			System.out.println("ERROR, el desplazamiento no puede ser mayor que " + (numeros.length+1));

		for (int i = 0; i < numeros.length; ++i)
			numeros[i] = numeros2[i];
		*/ 
		
		int numAnt = 0;
		int aux = 0;
		int comienzo = numeros.length - 1;
		
		while (comienzo > numeros.length - 1 - pos) {
			for (int i = comienzo; i >= 0; i-=pos) {		// me desplazo por el array de pos en pos
				aux = numeros[i]; 							
				numeros[i] = numAnt;
				numAnt = aux;
				
			}
			comienzo--;
		}
		numeros[numeros.length - 1] = numAnt;
	}

	//@Override
	public void listar() {
		for (int numero : numeros)
			System.out.print(numero + " ");
		System.out.println();
	}

	@Override
	public void introducir(int num) {
		boolean encontrado = false;
		
		for (int i = 0; i < numeros.length && !encontrado; ++i) {
			if (numeros[i] == 0) {		// espacio libre
				numeros[i] = num;
				encontrado = true;
			}
		}
		if (!encontrado)
			System.out.println("ERROR, no hay espacio para " + num);
		else
			System.out.println(num + " introducido satisfactoriamente");
		
	}

}
