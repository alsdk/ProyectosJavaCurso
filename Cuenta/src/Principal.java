import java.util.Scanner;


public class Principal {

	/**
	 * @param args
	 */
	// estas funciones van a ser usadas dentro de otra static
	private static Scanner lector = new Scanner(System.in);
	private static int menu() {
		int op = 0;
		System.out.println("1. Ingresar");
		System.out.println("2. Sacar");
		System.out.println("3. Imprimir");
		System.out.println("4. Salir");
		System.out.print("Introduce opcion: ");
		op = lector.nextInt();
		return op;
	}
	public static void main (String[] args) {
		Cuenta cuenta = new Cuenta();
		cuenta.setClave(1234);
		int opcion = 0, clave = 0;
		double cantidad = 0;
		
		do {
			opcion = menu();
			if (opcion == 1) {
				System.out.print("Introduzca clave: ");
				clave = lector.nextInt();
				
				if (clave == cuenta.getClave()) {
					System.out.print("Introduce dinero a ingresar: ");
					cantidad = lector.nextDouble();
					cuenta.ingresar(cantidad);
				}
				else {
					System.out.println("ERROR, clave incorrecta");
				}
			}
			else if (opcion == 2) {
				System.out.print("Introduzca clave: ");
				clave = lector.nextInt();
				
				if (clave == cuenta.getClave()) {
					System.out.print("Introduce dinero a sacar: ");
					cantidad = lector.nextDouble();
					cuenta.sacar(cantidad);
				}
				else {
					System.out.println("ERROR, clave incorrecta");
				}
			}
			else if (opcion == 3) {
				System.out.println("Saldo: " + cuenta.getSaldo());
			}
		} while (opcion != 4);

	}

}
