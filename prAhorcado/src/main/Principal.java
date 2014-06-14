package main;

import java.util.Scanner;
import lib.*;

public class Principal {

	private static Scanner input = new Scanner(System.in);
	
	private static int menu() {
		System.out.println("== Ahorcado ==");
		System.out.println("1- Introducir palabra.");
		System.out.println("2- Adivinar palabra.");
		System.out.println("3- Salir");
		System.out.print("Introduce opcion: ");
		
		return Integer.parseInt(input.nextLine());
	}
	
	private static void introducir_palabra(Frases f, String palabra) {
				for (int i = 0; i < palabra.length(); ++i) {
					f.introducir(palabra.charAt(i));
				}
				
				System.out.println("[*] listo para jugar");
				System.out.println();
	}
	
	private static void adivinar(Frases frase) {
		char letra = ' ';
		int aciertos = 0, intentos = 0;
		boolean acertado = false;
		
		if (frase != null) {		// controlar que hayamos pasado por la opcion 1 antes
			// ir pidiendo letras hasta que hayamos agotado los intentos 
			// o cuando el nº de aciertos sea igual a getLongitud()
			intentos = frase.numIntentos();
			do { 
				System.out.println("[*] Te quedan " + intentos + " intentos");
				System.out.print("[*] ");
				frase.imprimir();
				
				System.out.print("[*] adivina una letra: ");
				letra = input.nextLine().charAt(0);
				if (frase.buscar(letra) != -1) { 		// la letra esta en palabras[]
					System.out.println("[+] letra '" + frase.buscar(frase.buscar(letra)) + "' encontrada");
					System.out.println();

					aciertos += frase.eliminar(letra);
					if (aciertos == frase.getLongitud()) {
						System.out.print("[+] Felicidades, has averiguado la palabra secreta!! -> ");
						frase.imprimir();
						System.out.println();
						acertado = true;
					}
				}
				else {
					System.out.println("[-] '" + letra + "' no esta");
					System.out.println();
				}
				intentos--;
			} while (intentos > 0 && !acertado);
			if (!acertado) {
				System.out.println("[-] Prueba otra vez ...");
				System.out.println();
			}
		}
		else {
			System.out.println("[-] ERROR, No has introducido ninguna palabra");
			System.out.println();
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int op = 0;
		String palabra = null;
		Frases frase = null;
		
		do {
			try {
				op = menu();
			}
			catch (NumberFormatException e) {
				System.out.println("ERROR, " + e.getMessage() + " introduce una opcion correcta");
				System.out.println();
			}
			switch (op) {
			case 1:
				System.out.print("[+] Introduce palabra a adivinar: ");
				palabra = input.nextLine();
				
				frase = new Frases(palabra.length());
				introducir_palabra(frase, palabra);
				break;
			case 2:
				adivinar(frase);
				break;
			}
		} while (op != 3);

	}

}
