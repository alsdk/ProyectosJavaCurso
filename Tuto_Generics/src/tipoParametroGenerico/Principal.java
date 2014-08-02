package tipoParametroGenerico;

import tipoParametroGenerico.Imprimidor;

public class Principal {

	public static void main(String[] args) {
		//cadenas
		Imprimidor<String> imp = new Imprimidor<String>("hola");
		imp.imprimir();
		imp.imprimir_reves();
		
		//enteros
		Imprimidor<Integer> imp2 = new Imprimidor<Integer>(123);
		imp2.imprimir();
		imp2.imprimir_reves();
	}

}
