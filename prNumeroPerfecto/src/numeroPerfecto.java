import java.util.Scanner;


public class numeroPerfecto {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int num = 0, acumula = 0;
		Scanner input = new Scanner(System.in);
		
		System.out.print("Introduce numero: ");
		num = input.nextInt();

		for (int i=num-1; i>0; i--) {
			if (num%i == 0) {
				acumula += i;
			}
		}
		if (acumula == num) {
			System.out.println(num+" es perfecto");
		}
		else {
			System.out.println(num+" es imperfecto");
		}
	}

}
