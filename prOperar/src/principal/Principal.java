package principal;
import java.util.Scanner;

import operaciones.*;
import operacion.*;

public class Principal {
	private static final int SIZE = 5;
	private static Scanner lector = new Scanner(System.in);
	
	private static int menuGeneral() {
		int op = 0;
		
		System.out.println("== MENU PRINCIPAL ==");
		System.out.println("1. Entero");
		System.out.println("2. Char");
		System.out.println("3. Salir");
		System.out.print("Introduce opcion: ");
		op = Integer.parseInt(lector.nextLine());
		return op;
	}
	
	private static int submenu(int sub) {
		int op = 0;
		
		System.out.println(sub + ".1- Introducir");
		System.out.println(sub + ".2- Sumar");
		System.out.println(sub + ".3- Restar");
		System.out.println(sub + ".4- Listar");
		System.out.println(sub + ".5 Volver atras");
		System.out.print("Introduce opcion: ");
		op = Integer.parseInt(lector.nextLine());
		
		return op;
	}
	
	private static void introducir(Operacion op) {
		String cadena = null;
		
		System.out.print("Introduce: ");
		cadena = lector.nextLine();
		if (Character.isDigit(cadena.charAt(0)))
			op.introducir(Integer.parseInt(cadena));
		else
			op.introducir((int)cadena.charAt(0));
	}
	
	private static void listar(Operacion op) {
		op.listar();
	}
	
	private static void sumar(Operacion op) {
		int num = 0;
		
		System.out.print("Introduce desplazamiento (suma): ");
		num = Integer.parseInt(lector.nextLine());
		op.sumar(num);
	}
	
	private static void restar(Operacion op) {
		int num = 0;
		
		System.out.print("Introduce desplazamiento (resta): ");
		num = Integer.parseInt(lector.nextLine());
		op.restar(num);
	}
	
	public static void main(String [] args) {
		int opcion = 0;
		Operacion opent = new OperacionEntero(SIZE);
		Operacion opch = new OperacionChar(SIZE);
		
		do {		// do-while menuGeneral()
			switch (opcion = menuGeneral()) {
			case 1:
				do {		// submenu() enteros
					System.out.println("== MENU ENTERO ==");
					switch (opcion = submenu(opcion)) {
					case 1:
						introducir(opent);
						break;
					case 2:
						sumar(opent);
						break;
					case 3:
						restar(opent);
						break;
					case 4:
						listar(opent);
						break;
					}
				} while (opcion != 5);			// fin do-while submenu() enteros
				break;
			case 2:
				do {		// submenu() caracteres
					System.out.println("== MENU CARACTER ==");
					switch (opcion = submenu(opcion)) {
					case 1:	
						introducir(opch);
						break;
					case 2:
						sumar(opch);
						break;
					case 3:
						restar(opch);
						break;
					case 4:
						listar(opch);
						break;
					}
				} while (opcion != 5);			// fin do-while submenu() caracteres
				break;
			}
		} while (opcion != 3);			// fin do-while menuGeneral()
	}

}
