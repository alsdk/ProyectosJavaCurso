package vistas;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import vistas.paneles.PanelDerecha;
import vistas.paneles.PanelTablero;

public class Ventana extends JFrame {
	private static PanelTablero pTablero;
	private PanelDerecha pDerecha;
	
	public Ventana() {
		setTitle("Juego de buscar tesoros");
		setBounds(100, 100, 500, 300);
		crearPaneles();
	}

	public static PanelTablero getTablero() {
		return pTablero;
	}
	
	private void crearPaneles() {
		pTablero = new PanelTablero();
		pDerecha = new PanelDerecha();
		pTablero.setPanelDerecha(pDerecha);
		
		add(pTablero, BorderLayout.CENTER);
		add(pDerecha, BorderLayout.EAST);
	}

}
