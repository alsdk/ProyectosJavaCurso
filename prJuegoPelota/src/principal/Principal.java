package principal;

import javax.swing.JFrame;

import disenyo.VentanaPrincipal;

public class Principal {

	public static void main(String[] args) {
		VentanaPrincipal vp = new VentanaPrincipal();
		vp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		vp.setVisible(true);
	}

}
