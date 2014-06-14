package principal;
import operaciones.*;

import algoritmo.Algoritmo;

public class Principal {
	Algoritmo a = new AlgoritmoSuma(100); 		// objeto de tipo AlgoritmoSuma que se guarda
										// en una referencia de tipo Algoritmo
										// los metodos que tiene el objeto 'a' son los que tiene
										// el padre en comun con el hijo pq el objeto padre es Algoritmo, 
	// si quiero usar cosas del hijo instancio con AlgoritmoSuma a = new AlgoritmoSuma(120);
	AlgoritmoSuma as = new AlgoritmoSuma(10);
	
	int numeroCifrado = a.cifrar(10);
	System.out.println("hola");
	

}
