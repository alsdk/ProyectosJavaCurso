package diseño;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Ventana extends JFrame implements ActionListener {
	Toolkit utilidad = Toolkit.getDefaultToolkit();					// objeto Toolkit para averiguar el ancho y el alto de la pantalla
	int ancho = (int)utilidad.getScreenSize().getWidth();
	int alto = (int)utilidad.getScreenSize().getHeight();
	//this.setResizable(false); 				no hace posible maximizar ni mover la ventana
	
	private JLabel lNumero1;
	private JTextField tbNumero1;
	private JPanel pCentro;
	private JPanel pBotones;				// un panel para meter el boton
	private JButton btIntroducir, btColores;
	
	public Ventana() {
		this.setTitle("Ventana Principal");							// titulo
																	// setBounds(y, x, ancho, alto)
		this.setBounds(ancho/2-250, alto/2-250, 500, 500);		// centrar ventana en el escritorio 
		//this.setBounds(0, 0, ancho, alto);							// abre la ventana con el tamaño del escritorio
		inicializar();
	}
	
	private void inicializar() {
		pCentro = new JPanel(); 				 
		pBotones = new JPanel();
		
		lNumero1 = new JLabel("Numero 1: ");
		tbNumero1 = new JTextField("0", 5);
		
		pCentro.add(lNumero1); 				// JPanel usa FlowLayout, va insertando cosas desde el centro y empezando
		pCentro.add(tbNumero1);				// por la primera linea
		
		btIntroducir = new JButton("Introducir");		// creo boton con texto Introducir
		btIntroducir.addActionListener(this); 			// asocio a un boton (btIntroducir) el escuchador (addActionListener). 
														// El escuchador esta en esta clase (this)
														// implementado en el ActionEvent
		btColores = new JButton("Color");				// creo boton
		btColores.addActionListener(this);				// asocio escuchador
		
		pBotones.add(btIntroducir);						// añadimos al panel
		pBotones.add(btColores);						
		
		add(pCentro, BorderLayout.CENTER);
		add(pBotones,BorderLayout.SOUTH); 				// mostraria el boton pero no hace nada, habria que ponerle su escuchador
	}

	@Override
	public void actionPerformed(ActionEvent e) {			// es el pulsamiento sobre un objeto (boton en este caso)
															// el argumento e trae info del evento que ocurre; si has pulsado, boton izq,boton derecho
															// 2 maneras de comprobar que boton he pusaldo:
		if (e.getActionCommand().equals("Introducir")) {	// mira la etiqueta del boton que he pulsado (por si dos botones tienen el mismo evento)
			//JOptionPane.showMessageDialog(this, "Has pulsado introducir");			// JOptionPane saca ventanas emergentes, confirmaciones, etc
																					// this porque es una subventana de ella
																					// ahora hay que asociarlo al boton
			tbNumero1.setText("0");				// texto por defecto
		}
		else if (e.getActionCommand().equals("Color")) {							// cambiar el color del panel pCentro
			String color = tbNumero1.getText();										// sacar el texto
			pCentro.setBackground(Color.decode(color));
		}
		
	}
}
