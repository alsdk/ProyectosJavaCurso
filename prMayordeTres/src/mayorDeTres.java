
public class mayorDeTres {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int num1 = 10, num2 = 24, num3 = 15;
		
		if (num1 > num2) {
			if (num1 > num3) {
				System.out.println(num1+" es el mayor");
			}
			else {
				System.out.println(num3+" es el mayor");
			}
		}
		else {
			if (num2 > num3) {
				System.out.println(num2+" es el mayor");
			}
			else {
				System.out.println(num3+" es el mayor");
			}
		}

	}

}
