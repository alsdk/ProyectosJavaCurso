import java.util.Scanner;

public class cuentaDigitos {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int numero = 0, numOrigen = 0, contador = 0;
		Scanner input = new Scanner(System.in);

		System.out.print("Introduce un numero: ");
		numero = input.nextInt();
		numOrigen = numero;
		while (numero > 0) {
			numero = numero / 10;
			contador++;
		}
		System.out.println("El numero " + numOrigen + " tiene " + contador + " digitos\nFIN");
	}

}
