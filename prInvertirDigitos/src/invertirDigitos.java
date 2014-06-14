import java.util.Scanner;


public class invertirDigitos {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String digitos = "";
		int numero = 0;
		Scanner input = new Scanner(System.in); 
		
		System.out.print("introduce numero: ");
		numero = input.nextInt();
		
		while (numero/10 != 0) {
			digitos = digitos.concat(String.valueOf(numero%10));
			numero = numero/10;
		}
		digitos = digitos.concat(String.valueOf(numero));
		System.out.println(digitos);
		System.out.println(0.765*5);
	}

}
