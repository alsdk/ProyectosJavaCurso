import java.util.Scanner;


public class primo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int num = 0, divisible = 0;
		Scanner input = new Scanner(System.in);
		
		System.out.print("Introduce numero: ");
		num = input.nextInt();	
		
		for (int i = 2; i <= num; i++) {
			if (num % i == 0) {
				divisible++;
			}
		}
		if (divisible == 1) {
			System.out.println(num + " es primo!!");
		}
		else {
			System.out.println(num + " no es primo...");
		}
	}

}
