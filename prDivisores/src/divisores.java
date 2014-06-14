import java.util.Scanner;


public class divisores {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int numero = 0;
		Scanner input = new Scanner(System.in);
		
		System.out.print("Introduce un numero: ");
		numero = input.nextInt();
		for (int i=1; i<numero; i++) {
			if (numero%i == 0) {
				System.out.println(i+" es divisor de "+numero);
			}
		}

	}

}
