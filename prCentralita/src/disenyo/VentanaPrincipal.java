package disenyo;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JDesktopPane;

public class VentanaPrincipal extends JFrame {

	private JPanel contentPane;
	public static JMenu mnOperadores;
	public static JMenu mnLlamadas;
	private JDesktopPane desktopPane;
	
	/**
	 * Create the frame.
	 */
	public VentanaPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 541, 387);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnOperadores = new JMenu("Operadores");
		mnOperadores.setEnabled(false);
		menuBar.add(mnOperadores);
		
		JMenuItem mntmGestion = new JMenuItem("Gestion");
		mntmGestion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaOperadores vo = new VentanaOperadores();
				desktopPane.add(vo);
				vo.setVisible(true);
			}
		});
		mnOperadores.add(mntmGestion);
		
		mnLlamadas = new JMenu("Llamadas");
		mnLlamadas.setEnabled(false);
		menuBar.add(mnLlamadas);
		
		JMenuItem mntmOperacion = new JMenuItem("Operacion");
		mnLlamadas.add(mntmOperacion);
		
		JMenuItem mntmListar = new JMenuItem("Listado");
		mnLlamadas.add(mntmListar);
		
		JMenu mnSesion = new JMenu("Sesion");
		menuBar.add(mnSesion);
		
		JMenuItem mntmConectar = new JMenuItem("Conectar");
		mntmConectar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cargarConectar();
			}
		});
		mnSesion.add(mntmConectar);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		desktopPane = new JDesktopPane();
		contentPane.add(desktopPane, BorderLayout.CENTER);
	}
	
	private void cargarConectar() {
		VentanaConectar vc = new VentanaConectar();
		vc.setVisible(true);
	}
}
