package ficheros;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Hashtable;
import datos.Operadores;

public class FicherosClientes {

	// un hashtable es un diccionario de datos, que esta controlado por dos valores
	// clave,valores
	// clave es el indice, que no se repite y es unica y valor son los datos
	public static void grabar(Hashtable<String, Operadores> tablaOperadores) {
		try {
			FileOutputStream fw = new FileOutputStream("operadores.dat");
			ObjectOutputStream fich = new ObjectOutputStream(fw);
			fich.writeObject(tablaOperadores);
			fich.close();
			// para grabar objetos de una clase en un fichero hay que serializarlas, para bloquear las propiedades
			// del objeto antes de grabar.
			// las variables de instancia que son transient (private transient var1) no se graban en fichero
			//
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static Hashtable<String, Operadores> leer() {
		Hashtable<String, Operadores> tOperadores = null;
		
		try {
			FileInputStream fi = new FileInputStream("operadores.dat");
			ObjectInputStream fich = new ObjectInputStream(fi);
			tOperadores = (Hashtable<String, Operadores>) fich.readObject();
			fi.close();
		}
		catch (FileNotFoundException e) {
			//e.printStackTrace();
		} 
		catch (IOException e) {
			e.printStackTrace();
		} 
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return tOperadores;
	}
	
}
