
public class sucesionFibonacci {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int var1 = 0, var2 = 1, var3 = 0;
		
		System.out.print(var1 + " " + var2 + " ");
		for (int i = 0; i < 30; i++) {
			var3 = var1 + var2;
			var1 = var2;
			var2 = var3;
			System.out.print(var3 + " ");
		}
		
	}

}
