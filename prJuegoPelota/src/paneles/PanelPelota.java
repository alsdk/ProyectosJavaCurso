package paneles;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JPanel;

public class PanelPelota extends JPanel {
	private Image imagen;
	
	public PanelPelota() {
		imagen = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/imagenes/pelota.jpg"));
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(imagen, 0, 0, null);
	}
}
