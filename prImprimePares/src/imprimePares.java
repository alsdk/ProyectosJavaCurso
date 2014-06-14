import java.util.Scanner;

public class imprimePares {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int numero = 0, i = 0;
		Scanner input = new Scanner(System.in);

		while (i < 5) {
			System.out.print("Introduce numero " + (i+1) + ": ");
			numero = input.nextInt();
			if ((numero%2) == 0) {
				System.out.println("	El numero " + numero + " es par");
			}
			else {
				System.out.println("	El numero " + numero + " es impar");
			}
			i++;
		}
		System.out.println("FIN");

	}

}
