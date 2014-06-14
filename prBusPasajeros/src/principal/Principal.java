package principal;

import lib.*;
import java.util.Scanner;

public class Principal {
	private static Scanner input = new Scanner(System.in);
	private static final int CAPACIDAD = 5;									// constante con el numero de personas maxima que tiene el autobus
	
	/**
	 * @param args
	 */
	public static int menu() {
		int op = 0;
		
		System.out.println("== AUTOBUS ==");
		System.out.println("1. Subir Pasajero");
		System.out.println("2. Mover Autobus");
		System.out.println("3. Listar");
		System.out.println("4. Salir");
		System.out.print("Introduce opcion: ");
		op = Integer.parseInt(input.nextLine());
		
		return op;
	}
	
	private static void listar(Autobus bus) {
		// listar ciudades
		System.out.println("el autobus tiene una capacidad para " + CAPACIDAD + " personas");
		System.out.print("Pasara por las ciudades: ");
		for (int i = 0; bus.getCiudad(i) != null ; i++)
			System.out.print(bus.getCiudad(i) + " ");
		System.out.println();
		
		// listar pasajeros
			System.out.print("Sus pasajeros son: ");
				for (int i = 0; i < CAPACIDAD; ++i) {
					try {
						System.out.print(bus.getPasajero(i).getNombre() + " ");
					}
					catch (NullPointerException e) {
						System.out.println();
					}
				}
			System.out.println();
		}
	
	public static void subir_pasajero(Autobus bus) {
		Pasajeros pas = null;
		String nombre = null, orig = null, dest = null;
		
		System.out.print("[+] Introduce el nombre del pasajero que sube: ");
		nombre = input.nextLine();
		System.out.print("[+] Introduce su destino: ");
		dest = input.nextLine();
		
		pas = new Pasajeros(nombre);
		pas.setOrigen(bus.getCiudad());		// el origen del pasajero es la ciudad actual
		pas.setDestino(dest);
		bus.introducir(pas);
	}
	/*
	public static void bajar_pasajero() {
		String nom = null;
		
		System.out.print("Indica el nombre del pasajero que se baja: ");
		nom = input.nextLine();
		bus.bajar(nom);
	}
	*/
	public static void mover_autobus(Autobus bus) {
		if (bus != null) {
			bus.mover();			// cambiar a la siguiente ciudad
			System.out.println("[+] Estamos en " + bus.getCiudad());
			bus.bajar();			// bajar los pasajeros que tienen como destino la ciudad actual
		}
		else
			System.out.println("[-] ERROR, obj bus mal");
	}
	
	public static void main(String[] args) {
		Autobus bus = new Autobus(CAPACIDAD);				// instanciamos un autobus de 'capacidad' pasajeros
		int op = 0;
		
		do {
			try {
				op = menu();
			}
			catch (NumberFormatException e) {
				System.out.println("[-] ERROR, Introduce una opcion correcta (1-4)\n");
				op = menu();
			}
			switch (op) {
			case 1:
				subir_pasajero(bus);
				System.out.println();
				break;
			case 2:
				mover_autobus(bus);
				break;
			case 3:
				listar(bus);
				break;
			}
		} while (op != 4);		
	
	}
}
