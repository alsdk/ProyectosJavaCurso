import java.util.Scanner;


public class contarVocales {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int vocales = 0;
		char letra = ' ';
		Scanner input = new Scanner(System.in);
		
		do {
			System.out.print("Introduce letra: ");
			letra = input.nextLine().charAt(0);
			
			if (letra == 'a' || letra == 'e' || letra == 'i' || letra == 'o' || letra == 'u') {
				vocales++;
			}
		} while ( letra != 'x');
		System.out.println("has introducido "+vocales+" vocales");
	}

}
