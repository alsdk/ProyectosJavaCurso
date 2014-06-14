import java.util.Scanner;


public class triangulos {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int num1=0, num2=3, num3=1;
		Scanner lector;
		lector = new Scanner(System.in);
		System.out.print("Introduzca numero 1: ");
		num1 = lector.nextInt();
		System.out.print("Introduzca numero 2: ");
		num2 = lector.nextInt();
		System.out.print("Introduzca numero 3: ");
		num3 = lector.nextInt();
		
		if (num1 == num2 && num1 == num3) {	
			System.out.println("triangulo equilatero");
		}
		else if (num1 == num2 || num1 == num3 || num2 == num3)
		{
		//else if (((num1 == num2) && (num1 != num3)) || ((num1 == num3) && (num1 != num2)) || ((num2 == num1) || (num2 == num3))) {	
			System.out.println("triangulo isosceles");
		}
		else {	
			System.out.println("triangulo escaleno");
		}

	}

}
