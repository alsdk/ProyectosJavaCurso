package ficheros;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import figuras.Linea;

// clase para la opcion grabar
public class FicheroDibujo {

	public void grabar(ArrayList<Linea> lineas) {		// los elementos del ArrayList son de tipo Linea
		try {
			FileWriter fw = new FileWriter("figuras.txt");
			PrintWriter pw = new PrintWriter(fw);
			for (Linea l: lineas) {	// recorro el arraylist
				String texto = l.getX1() + ";" + l.getY1() + ";" + l.getX2() + ";" + l.getY2();
				pw.println(texto);
			}
			fw.close();
		}
		catch (IOException e) {
			System.out.println("Error al escribir en el fichero");
		}
	}
	
	public ArrayList<Linea> leer() {
		String linea;
		ArrayList<Linea> lineas = new ArrayList<Linea>();
		
		try {
			FileReader fr = new FileReader("figuras.txt");
			//Scanner lector = new Scanner(fr);
			BufferedReader br = new BufferedReader(fr);
			linea = br.readLine();		// linea = 10;20;400;300
			while ( linea != null ) {
				Linea line = new Linea();
				String [] datos = linea.split(";"); 	// datos[0] = 10  datos[1] = 20  datos[2] = 400  datos[3] = 300
				line.setX1(Integer.parseInt(datos[0]));
				line.setY1(Integer.parseInt(datos[1]));
				line.setX2(Integer.parseInt(datos[2]));
				line.setY2(Integer.parseInt(datos[3]));
				lineas.add(line);
				linea = br.readLine();
			}
			fr.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lineas;
	}
}
