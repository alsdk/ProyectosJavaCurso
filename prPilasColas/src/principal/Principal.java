package principal;
import pila.*;

public class Principal {
	private static final int SIZE = 5;
	
	public static void main(String[] args) {
		ArrayDatos a = new ArrayDatos(SIZE);

		
		a.insertar("valor1");
		a.insertar("valor2");
		a.insertar("valor3");
		a.insertar("valor4");

		a.listar();
		a.eliminar();
		a.listar();
		if (a.buscar("valor11") != -1)
			System.out.println("encontrado");
		
		/*
		Pila p = new Pila(SIZE);
		p.insertar("pila1");
		p.insertar("pila2");
		p.listar();
		
		Cola c = new Cola(SIZE);
		c.insertar("cola1");
		c.insertar("cola2");
		c.eliminar();
		c.listar();
		*/
	}


}
