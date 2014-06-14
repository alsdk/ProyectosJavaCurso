import java.util.Scanner;


public class Principal {
	static Scanner input = new Scanner(System.in);
	static Algoritmo cifrador = new Algoritmo(5);
	static char lcifrada = ' ';
	
	private static int menu() {
		int opcion = 0;
		
		System.out.println("== MENU ==");
		System.out.println("0. Introducir letra");
		System.out.println("1. Cifrar");
		System.out.println("2. Descifrar");
		System.out.println("3. Salir");
		System.out.print("Introducir opcion: ");
		opcion = input.nextInt();
		return opcion;
	}
	
	public static void main(String[] args) {
		char letra = 0;
		int op = 0;
		
		do {
			op = menu();
			if (op == 0) {
				System.out.print("[+] Introduce letra: ");
				letra = input.next().charAt(0);
				cifrador.setLetra(letra);
				System.out.println("[+] Letra '" + letra + "' guardada\n");
			}
			else if (op == 1) {
				lcifrada = cifrador.cifrar();
				System.out.println("[+] La letra '" + letra + "' se ha cifrado: '" + lcifrada + "'\n");
			}
			else if (op == 2) {
				System.out.println("[+] La letra '" + lcifrada + "' se ha descifrado: '" + cifrador.descifrar(lcifrada) + "'\n");
			}
		} while (op != 3);

	}

}
