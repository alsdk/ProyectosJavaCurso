package dinsenyo;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JToolBar;
import javax.swing.JButton;

import datos.ClientesBD;

import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class VentanaGestionClientes extends JInternalFrame {
	private JTextField tbLogin;
	private JTextField tbPassword;
	private JTextField tbEmail;
	private JComboBox cbTipo;
	private ClientesBD bClientes;

	/**
	 * Create the frame.
	 */
	public VentanaGestionClientes() {
		bClientes = new ClientesBD();
		
		setBounds(0, 0, 356, 288);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Login:");
		lblNewLabel.setBounds(39, 27, 46, 14);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password:");
		lblNewLabel_1.setBounds(21, 75, 64, 14);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("E-mail:");
		lblNewLabel_2.setBounds(39, 128, 46, 14);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Tipo:");
		lblNewLabel_3.setBounds(39, 180, 46, 14);
		getContentPane().add(lblNewLabel_3);
		
		tbLogin = new JTextField();
		tbLogin.setBounds(95, 27, 151, 20);
		getContentPane().add(tbLogin);
		tbLogin.setColumns(10);
		
		tbPassword = new JTextField();
		tbPassword.setBounds(95, 75, 151, 20);
		getContentPane().add(tbPassword);
		tbPassword.setColumns(10);
		
		tbEmail = new JTextField();
		tbEmail.setBounds(95, 128, 151, 20);
		getContentPane().add(tbEmail);
		tbEmail.setColumns(10);
		
		//JComboBox cbTipo = new JComboBox();
		cbTipo = new JComboBox();
		cbTipo.setModel(new DefaultComboBoxModel(new String[] {"Usuario", "Administrador"}));
		cbTipo.setBounds(95, 176, 151, 22);
		getContentPane().add(cbTipo);
		
		JToolBar toolBar = new JToolBar();
		toolBar.setBounds(0, 0, 444, 16);
		getContentPane().add(toolBar);
		
		JButton btNuevo = new JButton("Nuevo");
		btNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiar();
			}
		});
		toolBar.add(btNuevo);
		
		JButton btGrabar = new JButton("Grabar");
		btGrabar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				bClientes.grabar(tbLogin.getText(), tbPassword.getText(), tbEmail.getText(), cbTipo.getSelectedItem().toString());
			}
		});
		toolBar.add(btGrabar);
		
		JButton btModificar = new JButton("Modificar");
		btModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bClientes.modificar(tbLogin.getText(), tbPassword.getText(), tbEmail.getText(), cbTipo.getSelectedItem().toString());
			}
		});
		toolBar.add(btModificar);
		
		JButton btEliminar = new JButton("Eliminar");
		btEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bClientes.eliminar(tbLogin.getText());
				limpiar();
			}
		});
		toolBar.add(btEliminar);
		
		JButton btCerrar = new JButton("Cerrar");
		btCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cerrar();
			}
		});
		toolBar.add(btCerrar);
		
		JButton btBuscar = new JButton("Buscar");
		btBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<String> campos = bClientes.buscar(tbLogin.getText());
				if (campos.size() > 0) {
					tbPassword.setText(campos.get(1));
					tbEmail.setText(campos.get(2));
					cbTipo.setSelectedItem(campos.get(3));
				}
			}
		});
		btBuscar.setMargin(new Insets(2, 0, 2, 0));
		btBuscar.setBounds(256, 27, 56, 23);
		getContentPane().add(btBuscar);

	}

	protected void limpiar() {
		tbLogin.setText("");
		tbPassword.setText("");
		tbEmail.setText("");
		cbTipo.setSelectedIndex(0);
	}

	protected void cerrar() {
		this.setVisible(false);
		
	}
}
