package disenyo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import ficheros.FicheroDibujo;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;

public class VentanaPrincipal extends JFrame {
	
	private VentanaDibujo vd;
	
	public VentanaPrincipal() {
		setTitle("Ventana Dibujos");
		setBounds(100, 100, 600, 500);
		crearMenu();
	}
	
	private void crearMenu() {
		// creamos el menu
		JMenuBar menuPrincipal = new JMenuBar();
		
		JMenu menuDibujo = new JMenu("Dibujos");
		JMenu menuClientes = new JMenu("Clientes");
		
		JMenuItem menuNuevo = new JMenuItem("Nuevo");
		menuNuevo.setMnemonic('N');
		JMenuItem menuGrabar = new JMenuItem("Grabar");
		menuGrabar.setMnemonic('G');
		JMenuItem menuAbrir = new JMenuItem("Abrir");
		menuAbrir.setMnemonic('A');
		
		// anyadir los elementos para que se vean
		menuDibujo.add(menuNuevo);
		menuDibujo.add(menuGrabar);
		menuDibujo.add(menuAbrir);
		
		menuPrincipal.add(menuDibujo);
		menuPrincipal.add(menuClientes);
		
		JMenuItem mntmNuevo = new JMenuItem("Nuevo");
		mntmNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				VentanaClientes vc = new VentanaClientes();
				vc.setVisible(true);
			}
		});
		mntmNuevo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_MASK));
		menuClientes.add(mntmNuevo);
		
		JMenuItem mntmListar = new JMenuItem("Listar");
		mntmListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaListado vl = new VentanaListado();
				vl.setVisible(true);
			}
		});
		menuClientes.add(mntmListar);
		
		this.setJMenuBar(menuPrincipal);
		
		// definimos la accion al pulsar sobre 'Nuevo'
		menuNuevo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				vd = new VentanaDibujo();
				vd.setVisible(true);
			}
		});
		
		// definir accion al pulsar 'Grabar'
		menuGrabar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				FicheroDibujo fd = new FicheroDibujo();
				fd.grabar(vd.getLineas());
				JOptionPane.showMessageDialog(null, "Datos grabados");
			}
		});
		
		// manejador evento abrir
		menuAbrir.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {		// tenemos que tener la ventana de dibujo abierta para que funcione
					vd.pintarTodo();
				}
				catch (NullPointerException ex) {
				}
			}
		});
	}
}
