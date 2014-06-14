import java.util.Scanner;


public class Principal {
	// definicion variables de clase
	private static double base, altura;
	private static Scanner input = new Scanner(System.in);
	
	// metodos de clase
	private static int menu() {
		int opcion = 0;
		System.out.println("== MENU ==");
		System.out.println("1. Triangulo Rectangulo");
		System.out.println("2. Rectangulo");
		System.out.println("3. Salir");
		System.out.print("Introduce opcion: ");
		opcion = input.nextInt();
		System.out.println();
		
		return opcion;
	}
	
	private static void pideBaseAltura() {
		do {
			System.out.println("[+] Tienes que introducir base y altura");
			System.out.print("[+] Base: ");
			base = input.nextDouble();
			System.out.print("[+] Altura: ");
			altura = input.nextDouble();
			System.out.println();
		} while(base <= 0 || altura <= 0);			// base y altura tienen que ser positivos
		
	}
	
	// funcion principal
	public static void main(String[] args) {
		int opcion = 0;
		Rectangulo rect1 = new Rectangulo();
		Triangulo tri1 = new Triangulo();
		
		do {
			opcion = menu();
			switch (opcion) {
			case 1:		//TRIANGULOS
				pideBaseAltura();
				tri1.setBase(base);
				tri1.setAltura(altura);
				System.out.println("[+] El area del triangulo de base " + base + " y altura " + altura + " es " + tri1.calcularArea());
				System.out.println("[+] El perimetro del triangulo de base " + base + " y altura " + altura + " es " + tri1.calcularPerimetro());
				System.out.println();
				break;
			case 2:		//RECTANGULOS
				pideBaseAltura();
				rect1.setBase(base);
				rect1.setAltura(altura);
				System.out.println("[+] El area del rectangulo de base " + base + " y altura " + altura + " es " + rect1.calcularArea());
				System.out.println("[+] El perimetro del rectangulo de base " + base + " y altura " + altura + " es " + rect1.calcularPerimetro());
				System.out.println();
				break;
			}
		} while (opcion != 3);

	}

}