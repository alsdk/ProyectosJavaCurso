import java.util.Scanner;

public class operarNumeros {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String operacion;
		int num1 = 0, num2 = 0;
		Scanner input = new Scanner(System.in);
		
		System.out.print("Introduce el tipo de operacion: ");
		operacion = input.next();
		
		if (operacion.equals("+") || operacion.equals("-") || operacion.equals("*") || operacion.equals("/") || operacion.equals("%")) {
			System.out.print("	Has seleccionado '" + operacion + "' ahora introduce el primer numero: ");
			num1 = input.nextInt();
			System.out.print("	Introduce el segundo: ");
			num2 = input.nextInt();
			
			if (operacion.equals("+")) {
				System.out.println("	El resultado de '" + num1 + operacion + num2 + "' es: "+ (num1+num2));
			}
			else if (operacion.equals("-")) {
				System.out.println("	El resultado de '" + num1 + operacion + num2 + "' es: "+ (num1-num2));
			}
			else if (operacion.equals("*")) {
				System.out.println("	El resultado de '" + num1 + operacion + num2 + "' es: "+ (num1*num2));
			}
			else if (operacion.equals("/")) {
				System.out.println("	El resultado de '" + num1 + operacion + num2 + "' es: "+ ((double)num1/(double)num2));
			}
			else if (operacion.equals("%")) {
				System.out.println("	El resultado de '" + num1 + operacion + num2 + "' es: "+ ((double)num1%(double)num2));
			}
			
		}
		else {
			System.out.println("ERROR, introduce una operacion valida ( '+', '-', '*', '/', '%') ");
		}


	}

}
