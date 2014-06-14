import java.util.Scanner;

public class Principal {

	private static Scanner input = new Scanner(System.in);
	
	private static int menu() {
		int op = 0;
		
		System.out.println("== MENU ==");
		System.out.println("1. Entrar coche");
		System.out.println("2. Reparar coche");
		System.out.println("3. Mostrar ingresos");
		System.out.println("4. Salir");
		System.out.print("Introduce opcion: ");
		op = Integer.parseInt(input.nextLine());
		
		return op;
	}
	
	private static void entrar(Taller t) {
		String modelo = null;
		String averia = null;
		
		System.out.print("¿Que modelo es el coche?: ");
		modelo = input.nextLine();
		System.out.print("¿Que averia tiene el coche?: ");
		averia = input.nextLine();
		
		/*
		Coches c = new Coches(modelo);
		c.setAveria(averia);
		*/
		
		t.entrar(new Coches(modelo, averia));
	}
	
	private static void imprimir(Taller taller) {
		/*
		System.out.println("Modelo: " + taller.getCoche().getModelo());
		System.out.println("Averia: " + taller.getCoche().getAveria());
		System.out.println("Horas: " + taller.getCoche().getHoras());
		*/
		System.out.println(taller.getCoche()); 		// esto es lo mismo que un taller.getCoche().toString (toString es de la clase 'object')
													// para reescribir toString y hacer que devuelva info interesante en lugar de algo generico como el hash
													// se hace sobreescritura de metodos (sobreescribir el metodo toString que se hereda de la clase 'object')
													// para sobreescribir un metodo se copia la cabecera de la definicion toString de object en la clase coche
													// y se le ponen las instrucciones que hagan falta para redefinir toString
	}
	
	public static void main(String[] args) {
		int opcion = 0;
		String modelo = null, averia = null;
		Taller taller = new Taller("Taller Fail");
		taller.setPrecioH(5);
		
		do {
			opcion = menu();
			switch (opcion) {
			case 1:
				entrar(taller); 		// entrar un coche en el taller
				break;
			case 2:
				try {
					System.out.print("[+] Introduce el tiempo total en reparar el coche: ");
					taller.getCoche().setHoras(Integer.parseInt(input.nextLine()));
					imprimir(taller); 		// imprimir datos del coche reparado
					System.out.println("[+] Coche reparado; coste de la reparacion " + taller.reparar() + "\n");
				}
				catch (NullPointerException ex) {
					System.out.println("ERROR, no hay coche en el taller");
				}
				catch (NumberFormatException ex) {
					System.out.println(ex.getMessage() + " ERROR, no has introducido bien las horas");
				}
				break;
			case 3:
				System.out.println("==" + taller.getNombre() + "==");
				System.out.println("[+] Ingresos acumulados del taller: " + taller.getIngresos()+ "\n");
				break;
			}
		} while (opcion != 4);
		
	}

}
