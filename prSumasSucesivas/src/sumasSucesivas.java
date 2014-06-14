import java.util.Scanner;


public class sumasSucesivas {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int num1 = 0, num2 = 0, resultado = 0;
		Scanner input = new Scanner(System.in);
		
		System.out.println("Hay que introducir dos numeros");
		System.out.print("Numero 1: ");
		num1 = input.nextInt();
		System.out.print("Numero 2: ");
		num2 = input.nextInt();
		
		for (; num2>0; num2--) {
			resultado += num1;
		}
		System.out.println(resultado);
	}

}
