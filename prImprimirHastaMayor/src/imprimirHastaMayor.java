import java.util.Scanner;

public class imprimirHastaMayor {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int numero = 1, mayor = 0;
		Scanner input = new Scanner(System.in);
		
		System.out.print("Introduce un numero (0 para salir): ");
		numero = input.nextInt();
		while (numero != 0) {
			if (numero > mayor) {
				mayor = numero;
			}
			System.out.print("Introduce un numero (0 para salir): ");
			numero = input.nextInt();
		}
		System.out.println("El mayor es " + mayor + "\nFIN");
	}
	

}
