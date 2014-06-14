package disenyo;

import java.awt.BorderLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Ventana extends JFrame implements ActionListener {
	private JPanel pCentro;
	private JPanel pBotones;
	
	private JButton btOperation;
	
	private JLabel lNumero1;
	private JTextField tbNumero1;
	private JLabel lNumero2;
	private JTextField tbNumero2;
	private JLabel lResultado;
	private JTextField tbResultado;
	
	private double num1, num2;
	
	public Ventana() {
		this.setTitle("Calculadora");
		this.setBounds((int)Toolkit.getDefaultToolkit().getScreenSize().getWidth() /2-250,
				(int)Toolkit.getDefaultToolkit().getScreenSize().getHeight() /2-250,
				500, 500);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		inicializar();
	}
	
	private void inicializar() {
		// creamos los paneles, el del centro tiene un BoxLayout
		pBotones = new JPanel();
		pCentro = new JPanel();
		pCentro.setLayout(new BoxLayout(pCentro, BoxLayout.Y_AXIS));
		
		// crear TextFields para los dos numeros y el resultado
		lNumero1 = new JLabel("Numero 1");
		tbNumero1 = new JTextField("0", 10);
		lNumero2 = new JLabel("Numero 2");
		tbNumero2 = new JTextField("0", 10);
		lResultado = new JLabel("RESULTADO");
		tbResultado = new JTextField(" ", 10);
	
		// crear botones
		addButton("Sumar", pBotones);
		addButton("Restar", pBotones);
		addButton("Multiplicar", pBotones);
		addButton("Dividir", pBotones);
		addButton("Clear", pBotones);

		// añade al panel central los label y textboxes
		pCentro.add(lNumero1);
		pCentro.add(tbNumero1);
		pCentro.add(lNumero1);
		pCentro.add(tbNumero1);
		pCentro.add(lNumero2);
		pCentro.add(tbNumero2);
		pCentro.add(lResultado);
		pCentro.add(tbResultado);

		// añade al JFrame los paneles
		this.add(pCentro, BorderLayout.CENTER);
		this.add(pBotones, BorderLayout.SOUTH);
	}
	
	/*
	 * añadir un boton con nombre text al panel p
	 */
	private void addButton(String text, JPanel p) {
		btOperation = new JButton(text);
		btOperation.addActionListener(this);
		p.add(btOperation);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (tbNumero1.getText().equals("")) 
			tbNumero1.setText("0");
		
		if (tbNumero2.getText().equals(""))
			tbNumero2.setText("0");
		
		num1 = Integer.parseInt(tbNumero1.getText());
		num2 = Integer.parseInt(tbNumero2.getText());
		
		if (e.getActionCommand().equals("Multiplicar")) {
			
			tbResultado.setText(Double.toString(num1 * num2));
		}
		else if (e.getActionCommand().equals("Sumar")) {
			tbResultado.setText(Double.toString(num1 + num2));
		}
		else if (e.getActionCommand().equals("Restar")) {
			tbResultado.setText(Double.toString(num1 - num2));
		}
		else if (e.getActionCommand().equals("Dividir")) {
			tbResultado.setText(Double.toString(num1 / num2));
		}
		else if (e.getActionCommand().equals("Clear")) {
			tbNumero1.setText("0");
			tbNumero2.setText("0");
			tbResultado.setText(" ");
		}
	}
}
