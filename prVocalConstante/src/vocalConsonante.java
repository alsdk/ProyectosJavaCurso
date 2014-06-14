import java.util.Scanner;

public class vocalConsonante {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		/*
		String cadena;
		Scanner input = new Scanner(System.in);
		
		System.out.print("Introduce letra: ");
		cadena = input.next();
		
		if (cadena.length() > 1) {
			System.out.println("ERROR, introduce una sola letra");
		}
		else {
			if (cadena.equals("a") || cadena.equals("e") || cadena.equals("i") || cadena.equals("o") || cadena.equals("u")) {
				System.out.println(cadena + " es una vocal");
			}
			else {
				System.out.println(cadena + " es una consonante");
			}
		}
		*/
		
		// mismo ejercicio pero usando char para la letra
		char letra = ' ';
		Scanner lector = new Scanner(System.in);
		 
		System.out.print("Introduzca letra: ");
		letra = lector.next().charAt(0);	// leemos de la entrada y nos quedamos 
		 									// con el caracter de la posicion 0
		 
		if (letra == 'a' || letra == 'e' || letra == 'i' || letra == 'o' || letra == 'u') {
			System.out.println(letra + " es una vocal");
		}
		else {
			System.out.println(letra + " es una consonante");
		}

	}

}
