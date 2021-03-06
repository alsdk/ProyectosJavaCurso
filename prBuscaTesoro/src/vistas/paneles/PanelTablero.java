package vistas.paneles;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import vistas.botones.Botones;

public class PanelTablero extends JPanel implements ActionListener {
	private PanelDerecha pDerecha;
	public static boolean perdido;
	
	public PanelTablero() {
		setLayout(new GridLayout(3, 3));		// gridlayout de 3x3
		crearBotones();
	}

	public void setPanelDerecha(PanelDerecha vderecha) {		// conectar el panel central con el panel de la derecha
		this.pDerecha = vderecha; 
	}
	
	private void crearBotones() {
		Botones boton = null;
		
		for (int i = 0; i < 9; ++i) {		// creamos 9 botones 
			boton = new Botones();
			if (i == 4) {
				boton.setPremio(100000);
				boton.setNombrefich("premio1.png");
			}
			else if (i == 8) {
				boton.setPremio(10000);
				boton.setNombrefich("premio2.png");
			}
			else if (i == 2) {
				boton.setPremio(-1);
				boton.setNombrefich("muerte.png");
			}
			boton.setBackground(Color.BLACK);
			boton.addActionListener(this);
			add(boton);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
													//Botones aux = (Botones)e.getSource();
													// getSource() devuelve un Object
													// q sabemos de antemano que es un Botones, casteamos directamente
													// �al Object de getSource se le hizo un new Botones()?
		if (perdido == false) {
			if (e.getSource() instanceof Botones) {		
				Botones aux = (Botones)e.getSource();
				if (!aux.isPulsado()) {
					if (aux.getNombrefich() != null) {
						String ruta = "/imagenes/" + aux.getNombrefich();
						aux.setIcon(new ImageIcon(getClass().getResource(ruta)));
						
						if (aux.getPremio() == -1) {
							pDerecha.setPremio(0);
							perdido = true;
						}
						else {
							double valor = pDerecha.getPremio() + aux.getPremio();
							pDerecha.setPremio(valor);
						}
					}
				aux.setPulsado(true);
				}
			}
		}
		
	}
}
