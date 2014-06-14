package paneles;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.Random;

import javax.swing.JPanel;

public class Marciano extends JPanel {

	private Image dibujo;
	private int x,y;
	private final int ancho=25,alto=25;
	
	public Marciano(JPanel pTablero)
	{
		Random r=new Random();
		x=r.nextInt(pTablero.getWidth()-25);
		dibujo=Toolkit.getDefaultToolkit().getImage(getClass().getResource("/imagenes/marciano.gif"));
		setBackground(Color.WHITE);
		setBounds(x, y, ancho, alto);
		
		
	}
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.drawImage(dibujo,0,0,null);
	}
	
}
