
public class sumaResta {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int num1 = 4, num2 = 5;
		/*
		 * + sumar
		 * - restar
		 * / dividir
		 * * multiplicar
		 */
		char op = '/';
		
		if (op == '+') {
			System.out.println(num1+"+"+num2+": "+ (num1+num2));
		}
		else if (op == '-'){
			System.out.println(num1+"-"+num2+": "+ (num1-num2));
		}
		else if (op == '*') {
			System.out.println(num1+"*"+num2+": "+ (num1*num2));
		}
		else if (op == '/'){ 
			System.out.println(num1+"/"+num2+": "+ (double)num1/ (double)num2);
		}
		else {
			System.out.println("introduce una operacion a realizar en 'op'");
		}

	}

}
