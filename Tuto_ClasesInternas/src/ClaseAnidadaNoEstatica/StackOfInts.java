//La clase StackOfInts abajo se implementa en un arreglo. Cuando usted agrega un entero (llamado "empujar" o "pushing"), este va dentro del primer elemento vacío disponible. Cuando usted quita un entero (llamado "popping"), usted quita el último entero en el arreglo.
//
//La clase StackOfInts abajo (una aplicación) consiste de:
//
//    La clase externa StackOfInts, la cual incluye métodos para agregar un entero a la pila, quitar un entero de la pila, y comprovar para ver si la pila está vacía.
//    La clase interna StepThrough, la cual es similar al iterador estándar de Java. Los iteradores se usan para recorrer una estructura de datos y típicamente tienen métodos para comprobar el último elemento, recuperar el elemento actual y moverse al siguiente elemento.
//    Un método main que instancia un arreglo StackOfInts (stackOne) y lo llena con enteros (0, 2, 4, etc.), luego instancia un objeto StepThrough (iterator) y lo usa para imprimir el contenido de stackOne.
//
//La salida es:
//
//0 2 4 6 8 10 12 14 16 18 20 22 24 26 

package ClaseAnidadaNoEstatica;

public class StackOfInts { // pila de enteros

	private int[] stack;
	private int next = 0; // índice del último artículo en stack + 1

	public StackOfInts(int size) {
		// create an array large enough to hold the stack
		stack = new int[size];
	}

	public void push(int on) {
		if (next < stack.length)
			stack[next++] = on;
	}

	public boolean isEmpty() {
		return (next == 0);
	}

	public int pop() {
		if (!isEmpty())
			return stack[--next]; // artículo al inicio de la pila
		else
			return 0;
	}

	public int getStackSize() {
		return next;
	}

	private class StepThrough {
		// iniciar el recorrido en i=0
		private int i = 0;

		// incrementar el índice
		public void increment() {
			if (i < stack.length)
				i++;
		}

		// recuperar el elemento actual
		public int current() {
			return stack[i];
		}

		// último elemento en la pila?
		public boolean isLast() {
			if (i == getStackSize() - 1)
				return true;
			else
				return false;
		}
	}

	public StepThrough stepThrough() {
		return new StepThrough();
	}

	public static void main(String[] args) {

		// instanciar la clase externa como "stackOne"
		StackOfInts stackOne = new StackOfInts(15);

		// popular stackOne
		for (int j = 0; j < 15; j++) {
			stackOne.push(2 * j);
		}

		// instanciar la clase interna como "iterator"
		// ClaseExterna.ClaseInterna objetoInterno = objetoExterno.new ClaseInterna();
		StackOfInts.StepThrough iterator = stackOne.new StepThrough();
		//StepThrough iterator = stackOne.stepThrough();
		

		// imprimir stackOne[i], uno por línea
		while (!iterator.isLast()) {
			System.out.print(iterator.current() + " ");
			iterator.increment();
		}
		System.out.println();

	}

}
