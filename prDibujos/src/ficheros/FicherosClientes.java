package ficheros;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import empresa.Clientes;

public class FicherosClientes {
	
	public static void grabar (Clientes client) {
		try {
			FileWriter fw = new FileWriter("clientes.txt", true);
			PrintWriter pw = new PrintWriter(fw);
			String linea = client.getCodigo() + ";" + client.getNombre() + ";" + client.getTelefono() + ";" + client.getLocalidad();
			pw.println(linea);
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
	
	public static String[] buscar(String codigo) {
		String [] datos = null;
		boolean encontrado = false;
		
		FileReader fr;
		try {
			fr = new FileReader("clientes.txt");
			BufferedReader br = new BufferedReader(fr);
			String linea = br.readLine();
			while(linea != null && encontrado == false) {
				datos = linea.split(";");
				if (codigo.equals(datos[0])) {
					encontrado = true;
				}
				else {
					datos = null;
				}
				linea = br.readLine();
			}
			fr.close();
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		
		return datos;
	}
	
	public static void modificar(Clientes client) {
		// abrimos un fichero auxiliar fichero2 en el que volcamos el contenido de fich1 excepto
		// la linea que vamos a modificar.
		// usamos la clase File pq permite borrar, renombrar
		File fich1 = new File("clientes.txt");
		File fich2 = new File("nuevo.txt");

		try {
			BufferedReader br = new BufferedReader(new FileReader(fich1));
			PrintWriter pw = new PrintWriter(new FileWriter(fich2));
			
			String linea = br.readLine();
			
			while (linea != null) {
				String [] datos = linea.split(";");
				if (client.getCodigo().equals(datos[0])) { 		// si coincide construimos la linea nueva y la grabamos en fich1
					linea = client.getCodigo() + ";" + client.getNombre() + ";" + client.getTelefono() + ";" + client.getLocalidad();
					pw.println(linea);
				}
				else {
					pw.println(linea);
				}
				linea = br.readLine();
			}
			br.close();
			pw.close();
			fich1.delete();
			fich2.renameTo(fich1);	// el obj fich1 tiene el nombre bien puesto
		} 
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	// listar todo el contenido del fichero y guardarlo en un ArrayList de tipo String
	public static ArrayList<String> listado() {
		ArrayList<String> lineas = new ArrayList<String>();
		FileReader fr;
		
		try {
			fr = new FileReader("clientes.txt");
			BufferedReader br = new BufferedReader(fr);
			
			String line = br.readLine();
			while (line != null) {
				lineas.add(line);
				line = br.readLine();
			}
			fr.close();
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}

		return lineas;
	}
}
