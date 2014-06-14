import java.util.Scanner;


public class adivinarNumero {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int adivina = (int)(Math.random()*10)+1;
		int numero = 0, i = 0, flag = 0;
		Scanner input = new Scanner(System.in);	

		//System.out.println(adivina);
		/*
		 * no esta bien del todo, funciona pero tiene que recorrer el bucle entero
		 * aunque acertemos a la primera
		 */
		while (i < 5 && flag == 0) {
			do {
				System.out.print("Introduce numero ("+(i+1)+"): ");
				numero = input.nextInt();
			} while (numero < 1 || numero > 10);
		
			if (adivina == numero) {
				System.out.println("Has acertado!!");
				flag = 1;
			}
			else if (Math.abs(adivina-numero) >= 5) {		// valor absoluto para que la diferencia no sea negativa
				System.out.println("Frio");
			}
			else if (Math.abs(adivina-numero) < 5 && Math.abs(adivina-numero) >= 3) {
				System.out.println("Caliente");
			}
			else if (Math.abs(adivina-numero) >= 1 && Math.abs(adivina-numero) < 3) {
				System.out.println("Muy caliente");
			}
			i++;
		}
		if (flag != 1) {
			System.out.println("Has perdido");
		}
	}

}
