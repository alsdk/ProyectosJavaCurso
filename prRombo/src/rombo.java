import java.util.Scanner;


public class rombo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int num=0, numizq=0, f=0, c=0, z=0;
		Scanner input = new Scanner(System.in);
		
		System.out.print("Introduce numero: ");
		num = input.nextInt();
		
		numizq=num;
		for (f=1; f<=num; f++) { 		// pintar la primera mitad del rombo
			for (c=1; c<=num; c++) { 	// pintar la mitad izquierda (arriba)
				if (c>=numizq) {
					System.out.print("*");
				}
				else {
					System.out.print(" ");
				}
			}
			for (z=num-1; z>=1; z--) { 	// pintar la mitad derecha (arriba)
				if (z>=numizq) {
					System.out.print("*");
				}
				else {
					System.out.print(" ");
				}
			}
			System.out.println();
			numizq--;
		}

		numizq=num;
		for (f=1; f<num; f++) { 			// pinta la mitad de abajo
			for (c=num; c>=1; c--) { 		// pinta la mitad izquierda (abajo)
				if (c>=numizq) {
					System.out.print(" ");
				}
				else {
					System.out.print("*");
				}
			}
			for (z=1; z<numizq-1; z++) { 	// pinta la mitad derecha (abajo)
				if (z<numizq) {
					System.out.print("*");
				}
				else {
					System.out.print(" ");
				}
			}
			numizq--;
			System.out.println();
		}
	}

}
