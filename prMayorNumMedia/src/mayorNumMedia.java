import java.util.Scanner;

public class mayorNumMedia {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int sumatorio = 0, numero = 0, mayor = 0;
		Scanner input = new Scanner(System.in);
		
		System.out.print("Introduce el primer numero: ");
		numero = input.nextInt();
		mayor = numero;
		sumatorio += numero;
		
		System.out.print("Introduce el segundo numero: ");
		numero = input.nextInt();
		sumatorio += numero;
		if (numero > mayor) {
			mayor = numero;
		}
		
		System.out.print("Introduce el tercer numero: ");
		numero = input.nextInt();
		sumatorio += numero;
		if (numero > mayor) {
			mayor = numero;
		}
		
		System.out.print("Introduce el cuarto numero: ");
		numero = input.nextInt();
		sumatorio += numero;
		if (numero > mayor) {
			mayor = numero;
		}
		
		System.out.print("Introduce el ultimo numero: ");
		numero = input.nextInt();
		sumatorio += numero;
		if (numero > mayor) {
			mayor = numero;
		}
		
		System.out.println("\nel numero mas grande es: " + mayor);
		System.out.println("la media aritmetica de las ca1ntidades es " + ((double)sumatorio/(double)5));
	}

}
