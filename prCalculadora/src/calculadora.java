import java.util.InputMismatchException;
import java.util.Scanner;


public class calculadora {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner lector=new Scanner(System.in);
		double num1=0,num2=0;
		String op=null;
		do{
			System.out.println("Introduzca operacion: ");
			op=lector.next();
			
			if (op.equals("+")||op.equals("-")||op.equals("/")||op.equals("*"))
			{
				try{
					System.out.println("Introduzca numero 1: ");
					num1=lector.nextDouble();
					System.out.println("Introduzca numero 2: ");
					num2=lector.nextDouble();
			
					if(op.equals("+"))
					{
						num1=num1+num2;
						System.out.println("Suma: " +num1);
					}
					else if(op.equals("-"))
					{
						num1=num1-num2;
						System.out.println("Resta: " +num1);
					}
				}
				catch(InputMismatchException error)
				{
					System.out.println("Error de lectura de datos");
				}
				catch(Exception ex)
				{
					System.out.println("Error");
				}
			}
			else if(!op.equals("s")){
				System.out.println("Error operacion incorrecta");
			}
		}while(!op.equals("s"));
	}

}
