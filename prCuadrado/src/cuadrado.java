import java.util.Scanner;


public class cuadrado {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int num=0, f=0, c=0;
		Scanner input = new Scanner(System.in);
		
		System.out.print("introduce alto x ancho del cuadrado: ");
		num = input.nextInt();
		
		for (f=num; f>=1; f--) {
			for (c=1; c<=num; c++) {
				if (f==num || f==1 || c==1 || c==num) {
					System.out.print("* ");
				}
				else {
					System.out.print("  ");
				}
			}
			System.out.println();
		}
	}

}
