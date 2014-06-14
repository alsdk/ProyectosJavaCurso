package vistas.paneles;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import vistas.Ventana;
import vistas.botones.Botones;

public class PanelDerecha extends JPanel{
	private JLabel lPremios;
	private JTextField tbPremios;
	private JButton btReiniciar, btCerrar;
	
	public PanelDerecha() {
		setLayout(new GridLayout(4, 1));
		cargarComponentes();
	}
	
	public void setPremio(double valor) {		// en lugar de acceder al cuadro de texto entero tbPremios
												// nos quedamos solo con lo que nos interesa
		tbPremios.setText(Double.toString(valor));
	}
	
	public double getPremio() {
		return Double.parseDouble(tbPremios.getText());
	}

	private void cargarComponentes() {
		lPremios = new JLabel("Premios:");
		tbPremios = new JTextField("0");
		btReiniciar = new JButton("Reiniciar");
		btReiniciar.addActionListener(new ActionListener() { 			// para botones simples y con cosas concretas
																		// creamos la clase anonima ActionListener() q implementa ActionPerformed
			@Override
			public void actionPerformed(ActionEvent e) {
				PanelTablero aux = Ventana.getTablero();				// necesitamos conectar con el panel del tablero
				tbPremios.setText("0");
				PanelTablero.perdido = false;
				for (int i = 0; i < aux.getComponentCount(); i++) {		// a cada elemento del panel central, le quitamos:
					Botones b = (Botones)aux.getComponent(i);			// 
					b.setPulsado(false);								// que ha sido pulsado
					b.setIcon(null);									// le quitamos el icono
				}
			}
		});
		
		btCerrar = new JButton("Cerrar");
		btCerrar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		add(lPremios);
		add(tbPremios);
		add(new JLabel());
		add(new JLabel());
		add(btReiniciar);
		add(new JLabel());
		add(btCerrar);
	}

}
