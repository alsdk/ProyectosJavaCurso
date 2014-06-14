import java.util.Scanner;


public class factorial {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int numero = 1, i = 1;
		Scanner input = new Scanner(System.in);
		
		System.out.print("Introduce numero: ");
		numero = input.nextInt();
		for (i=numero-1; i>0; i--) {
			numero *= i;
		}
		System.out.println(numero);
	}

}
