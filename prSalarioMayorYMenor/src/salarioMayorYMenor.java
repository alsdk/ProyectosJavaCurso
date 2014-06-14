import java.util.Scanner;


public class salarioMayorYMenor {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		double salario = 0, mayor = 0, menor = 0;
		Scanner input = new Scanner(System.in);
		
		do {
			System.out.print("Introduce salario: ");
			salario = input.nextInt();
			
			if (mayor == 0) {
				mayor = salario;
			}
			else if (salario > mayor) {
				mayor = salario;
			}
			
			if ((salario < menor || menor == 0) && salario != 0) {
				menor = salario;
			}
		} while (salario != 0);

		System.out.println("Salario mayor: "+mayor);
		System.out.println("Salario menor: "+menor);
	}

}
