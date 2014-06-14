package disenyo;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JToolBar;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JSeparator;
import java.awt.Dimension;
import javax.swing.SwingConstants;

import datos.Operadores;
import ficheros.FicherosClientes;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Hashtable;

public class VentanaOperadores extends JInternalFrame {
	private JTextField tbLogin;
	private JTextField tbPassword;
	private JTextField tbNombre;
	private JTextField tbEmail;
	private JComboBox cbTipo;
	private JButton btNuevo, btGrabar, btEliminar, btModificar, btBuscar;
	private Hashtable<String, Operadores> tOperadores;

	/**
	 * Create the frame.
	 */
	public VentanaOperadores() {
		//setBounds(5, 5, 450, 300);		//setBounds de un JInternalFrame tiene sus coordenadas dentro de otra ventana, no del escritorio 
		setSize(431, 268);
		//poner botones de cerrar, minimizar, etc
		setClosable(true);
		setMaximizable(true);
		setIconifiable(true);
		
		tOperadores = FicherosClientes.leer();
		if (tOperadores == null) {
			tOperadores = new Hashtable<String, Operadores>();
		}
		getContentPane().setLayout(null);
		
		JToolBar toolBar = new JToolBar();
		toolBar.setBounds(0, 0, 444, 43);
		getContentPane().add(toolBar);
		
		btNuevo = new JButton("");
		btNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				limpiar();
				btGrabar.setEnabled(true);
				btEliminar.setEnabled(false);
				btModificar.setEnabled(false);
			}
		});
		btNuevo.setBorder(null);
		btNuevo.setIcon(new ImageIcon(VentanaOperadores.class.getResource("/imagenes/nuevo.png")));
		toolBar.add(btNuevo);
		
		btGrabar = new JButton("");
		btGrabar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// coger todos los cuadros de texto y hacer un hashtable
				Operadores op= new Operadores();
				op.setLogin(tbLogin.getText());
				op.setPass(tbPassword.getText());
				op.setNombre(tbNombre.getText());
				op.setEmail(tbEmail.getText());
				op.setTipo(cbTipo.getSelectedItem().toString());
				
				// meter en la hashtable
				tOperadores.put(op.getLogin(), op);
				FicherosClientes.grabar(tOperadores);
				JOptionPane.showMessageDialog(null, "Datos Grabados");
			}
		});
		btGrabar.setBorder(null);
		btGrabar.setIcon(new ImageIcon(VentanaOperadores.class.getResource("/imagenes/save.png")));
		toolBar.add(btGrabar);
		
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setMaximumSize(new Dimension(5, 30));
		toolBar.add(separator);
		
		btModificar = new JButton("");
		btModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// sacar el operador que quiero modificar de la tabla hash
				Operadores op = tOperadores.get(tbLogin.getText());
				try {
					op.setPass(tbPassword.getText());
					op.setNombre(tbNombre.getText());
					op.setEmail(tbEmail.getText());
					op.setTipo(cbTipo.getSelectedItem().toString());
				}
				catch (NullPointerException ex) {
					FicherosClientes.grabar(tOperadores);
				}
			}
		});
		btModificar.setBorder(null);
		btModificar.setIcon(new ImageIcon(VentanaOperadores.class.getResource("/imagenes/modificar.png")));
		toolBar.add(btModificar);
		
		btEliminar = new JButton("");
		btEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//eliminar de la tabla hash y del fichero
				if ( tOperadores.remove(tbLogin.getText()) != null) {
					FicherosClientes.grabar(tOperadores);
					limpiar();
				}

			}
		});
		btEliminar.setBorder(null);
		btEliminar.setIcon(new ImageIcon(VentanaOperadores.class.getResource("/imagenes/eliminar.png")));
		toolBar.add(btEliminar);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setOrientation(SwingConstants.VERTICAL);
		separator_1.setMaximumSize(new Dimension(5, 30));
		toolBar.add(separator_1);
		
		btBuscar = new JButton("");
		btBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Operadores op = tOperadores.get(tbLogin.getText());
				try {
					tbNombre.setText(op.getNombre());
					tbPassword.setText(op.getPass());
					tbEmail.setText(op.getEmail());
					cbTipo.setSelectedItem(op.getTipo());
				}
				catch (NullPointerException e) {
					JOptionPane.showMessageDialog(null, "Login incorrecto");
				}
			}
		});
		btBuscar.setBorder(null);
		btBuscar.setIcon(new ImageIcon(VentanaOperadores.class.getResource("/imagenes/buscar.png")));
		toolBar.add(btBuscar);
		
		JLabel lblNewLabel = new JLabel("Login:");
		lblNewLabel.setBounds(61, 67, 66, 14);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password:");
		lblNewLabel_1.setBounds(61, 92, 66, 14);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Nombre:");
		lblNewLabel_2.setBounds(61, 117, 66, 14);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Email:");
		lblNewLabel_3.setBounds(61, 142, 66, 14);
		getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Tipo:");
		lblNewLabel_4.setBounds(61, 167, 66, 14);
		getContentPane().add(lblNewLabel_4);
		
		tbLogin = new JTextField();
		tbLogin.setBounds(137, 64, 217, 20);
		getContentPane().add(tbLogin);
		tbLogin.setColumns(10);
		
		tbPassword = new JTextField();
		tbPassword.setBounds(137, 89, 217, 20);
		getContentPane().add(tbPassword);
		tbPassword.setColumns(10);
		
		tbNombre = new JTextField();
		tbNombre.setBounds(137, 114, 217, 20);
		getContentPane().add(tbNombre);
		tbNombre.setColumns(10);
		
		tbEmail = new JTextField();
		tbEmail.setBounds(137, 139, 217, 20);
		getContentPane().add(tbEmail);
		tbEmail.setColumns(10);
		
		cbTipo = new JComboBox();
		cbTipo.setModel(new DefaultComboBoxModel(new String[] {"Usuarios", "Administradores"}));
		cbTipo.setBounds(137, 163, 103, 22);
		getContentPane().add(cbTipo);
	}

	// vaciar los campos
	protected void limpiar() {
		tbLogin.setText("");
		tbPassword.setText("");
		tbNombre.setText("");
		tbEmail.setText("");
		cbTipo.setSelectedIndex(0);
	}
	
	
}
