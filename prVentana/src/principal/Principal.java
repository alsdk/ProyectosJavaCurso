package principal;

import javax.swing.JFrame;
import diseño.Ventana;

public class Principal {


	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Ventana v = new Ventana();			// construyo mi ventana
		v.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		v.setVisible(true);					// la hago visible
	}

}
