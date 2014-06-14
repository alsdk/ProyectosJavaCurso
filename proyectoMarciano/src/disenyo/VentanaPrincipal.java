package disenyo;

import hilos.ProcesoLanzar;
import hilos.ProcesoMisil;
import hilos.ProcesoNave;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class VentanaPrincipal extends JFrame {

	private JPanel contentPane;
	private JTextField tbPuntos;
	private ProcesoLanzar lanzador;
	private ProcesoNave pNave;
	private JButton btMisil,btNave;
	private JPanel pTablero;
	/**
	 * Create the frame.
	 */
	public VentanaPrincipal() {
		setTitle("Batalla Espacial");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 502, 450);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.desktop);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		pTablero = new JPanel();
		pTablero.setBackground(Color.WHITE);
		pTablero.setBounds(10, 11, 359, 394);
		contentPane.add(pTablero);
		pTablero.setLayout(null);
		
		btNave = new JButton("");
		btNave.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				if (arg0.getKeyCode()==KeyEvent.VK_A)
				{
					pNave.cambiarDir(0);
				}
				else if (arg0.getKeyCode()==KeyEvent.VK_D)
				{
					pNave.cambiarDir(1);
				}
				else if (arg0.getKeyCode()==KeyEvent.VK_K)
				{
					ProcesoMisil pMisil=new ProcesoMisil(btMisil, pTablero);
					pMisil.start();
				}
			}
		});
		btNave.setBorder(null);
		btNave.setBackground(SystemColor.activeCaptionText);
		btNave.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/imagenes/ovni.png")));
		btNave.setBounds(133, 348, 40, 40);
		pTablero.add(btNave);
		
		btMisil = new JButton("");
		btMisil.setBounds(148, 348, 10, 10);
		pTablero.add(btMisil);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.inactiveCaptionText);
		panel_1.setBounds(379, 11, 105, 394);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btJugar = new JButton("JUGAR");
		btJugar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lanzador=new ProcesoLanzar(pTablero);
				lanzador.start();
				pNave=new ProcesoNave(btNave, btMisil, pTablero.getWidth());
				pNave.start();
				btNave.requestFocus();
			}
		});
		btJugar.setMargin(new Insets(2, 0, 2, 0));
		btJugar.setBounds(23, 26, 59, 23);
		panel_1.add(btJugar);
		
		JButton btParar = new JButton("PARAR");
		btParar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lanzador.parada();
				pNave.parada();
			}
		});
		btParar.setMargin(new Insets(2, 0, 2, 0));
		btParar.setBounds(23, 62, 59, 23);
		panel_1.add(btParar);
		
		JLabel lblPuntos = new JLabel("PUNTOS:");
		lblPuntos.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPuntos.setBounds(23, 146, 72, 23);
		panel_1.add(lblPuntos);
		
		tbPuntos = new JTextField();
		tbPuntos.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tbPuntos.setHorizontalAlignment(SwingConstants.RIGHT);
		tbPuntos.setText("0");
		tbPuntos.setBounds(23, 171, 59, 20);
		panel_1.add(tbPuntos);
		tbPuntos.setColumns(10);
	}
}
