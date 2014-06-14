import java.util.Scanner;


public class mayorDeTresV2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int num1=0, num2=0, num3=0;
		Scanner lector;
		lector = new Scanner(System.in);
		System.out.print("Introduzca numero 1: ");
		num1 = lector.nextInt();
		System.out.print("Introduzca numero 2: ");
		num2 = lector.nextInt();
		System.out.print("Introduzca numero 3: ");
		num3 = lector.nextInt();
		
		if (num1 > num2 && num1 > num3) {
			if (num2 > num3) {
				System.out.println(num1+ " es el mayor y el menor es " + num3);
			}
			else {
				System.out.println(num1 + " es el mayor y el menor es " +num2);
			}
		}
		else if (num2 > num3) {		// sabemos que num1 no es el mayor
			if (num1 > num3) {
				System.out.println(num2 + " es el mayor y el menor es " + num3);
			}
			else {
				System.out.println(num2 + " es el mayor y el menor es " + num1);
			}
		}
		else {						// sabemos que num3 es el mayor de todos
			if (num2 > num1) {
				System.out.println(num3 + " es el mayor y el menor es " + num1);
			}
			else {
				System.out.println(num3 + " es el mayor y el menor es " + num2);
			}
		}

	}

}
