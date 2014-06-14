package disenyo;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;

import paneles.PanelPelota;
import procesos.HiloBarra;
import procesos.HiloPelota;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class VentanaPrincipal extends JFrame {

	private JPanel contentPane;
	private PanelPelota pPelota, pPelota2;
	private JPanel pTablero;
	private HiloPelota hilop, hilop2;
	private HiloBarra hilob;
	private JButton btBarra;

	public VentanaPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 567, 510);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		pTablero = new JPanel();
		pTablero.setBackground(Color.WHITE);
		pTablero.setBounds(10, 11, 341, 461);
		contentPane.add(pTablero);
		pTablero.setLayout(null);
		
		JButton btStart = new JButton("START");
		btStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				hilob = new HiloBarra(btBarra, pTablero.getHeight());
				Thread hilo = new Thread(hilob);
				hilo.start();
				
				hilop = new HiloPelota(pPelota, pTablero.getWidth(), btBarra);
				hilop.setPriority(10);
				hilop.start();
				 
				hilop2 = new HiloPelota(pPelota2, pTablero.getWidth(), btBarra);
				hilop2.setPriority(1);
				hilop2.start();
				btBarra.requestFocus();
			}
		});
		btStart.setBounds(458, 11, 91, 23);
		contentPane.add(btStart);
		
		JButton btStop = new JButton("STOP");
		btStop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					hilop.setParar(true);
					hilop2.setParar(true);
					hilob.setParar(true);
				}
				catch (NullPointerException ex) {
					ex.printStackTrace();
				}
			}
		});
		btStop.setBounds(458, 46, 91, 23);
		contentPane.add(btStop);
		
		pPelota = new PanelPelota();
		pPelota.setBounds(2, 20, 40, 40);
		pTablero.add(pPelota);
		
		pPelota2 = new PanelPelota();
		pPelota2.setBounds(2, 292, 40, 40);
		pTablero.add(pPelota2);
		
		btBarra = new JButton("");
		btBarra.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				if (arg0.getKeyCode() == KeyEvent.VK_A) {
					hilob.setDireccion(0);
				}
				else if (arg0.getKeyCode() == KeyEvent.VK_Z) {
					hilob.setDireccion(1);
				}
			}
		});
		btBarra.setBackground(Color.CYAN);
		btBarra.setBounds(317, 43, 14, 142);
		pTablero.add(btBarra);
	}
}
