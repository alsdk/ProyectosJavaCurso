package principal;

import javax.swing.JFrame;

import vistas.Ventana;

public class Principal {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Ventana v = new Ventana();
		v.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		v.setVisible(true);
	}

}
