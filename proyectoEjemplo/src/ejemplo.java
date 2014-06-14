
public class ejemplo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int cantidad = 680;
		int restoCincuenta = 0, restoVeinte = 0;
		
		restoCincuenta = cantidad % 50;
		restoVeinte = restoCincuenta % 20;
		System.out.println(cantidad+" tiene: ");
		System.out.println((int)cantidad/50+" billetes de 50");
		System.out.println((int)restoCincuenta/20+" billetes de 20");
		System.out.println((int)restoVeinte/10+" billetes de 10");
	}

}
