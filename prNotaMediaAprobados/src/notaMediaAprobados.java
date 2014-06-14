import java.util.Scanner;


public class notaMediaAprobados {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		double nota = 0, acumulador = 0;
		int i = 1, aprobados = 0;
		Scanner input = new Scanner(System.in);
		
		while (i <= 5) {
			do {
				System.out.print("Introduce nota ("+i+"): ");
				nota = input.nextDouble();
			} while (nota < 0 || nota > 10);
			acumulador+=nota;
			if (nota >= 5) {
				aprobados++;
			}
			i++;
		}
		System.out.println("La media es "+(acumulador/i));
		System.out.println("Hay "+ aprobados + " aprobados");
	}

}
