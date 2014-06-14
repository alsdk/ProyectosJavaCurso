package disenyo;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JOptionPane;
import javax.swing.JToolBar;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.Color;
import javax.swing.DefaultComboBoxModel;

import empresa.Clientes;
import ficheros.FicherosClientes;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaClientes extends JFrame {

	private JPanel contentPane;
	private JTextField tbCodigo;
	private JTextField tbNombre;
	private JTextField tbTelefono;
	private JComboBox cbLocalidad;

	/**
	 * Create the frame.
	 */
	public VentanaClientes() {
		setBounds(100, 100, 364, 251);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JToolBar toolBar = new JToolBar();
		toolBar.setBackground(Color.LIGHT_GRAY);
		GridBagConstraints gbc_toolBar = new GridBagConstraints();
		gbc_toolBar.insets = new Insets(0, 0, 5, 0);
		gbc_toolBar.fill = GridBagConstraints.HORIZONTAL;
		gbc_toolBar.gridx = 0;
		gbc_toolBar.gridy = 0;
		contentPane.add(toolBar, gbc_toolBar);
		
		JButton btnNuevo = new JButton("");
		btnNuevo.setBackground(Color.LIGHT_GRAY);
		btnNuevo.setBorder(null);
		btnNuevo.setIcon(new ImageIcon(VentanaClientes.class.getResource("/imagenes/nuevo.png")));
		toolBar.add(btnNuevo);
		
		JButton btnGrabar = new JButton("");
		btnGrabar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Clientes client = new Clientes();
				client.setCodigo(tbCodigo.getText());
				client.setNombre(tbNombre.getText());
				client.setTelefono(tbTelefono.getText());
				client.setLocalidad(cbLocalidad.getSelectedItem().toString());
				
				FicherosClientes.grabar(client);
				JOptionPane.showMessageDialog(null, "Datos Grabados");
			}
		});
		
		btnGrabar.setBackground(Color.LIGHT_GRAY);
		btnGrabar.setBorder(null);
		btnGrabar.setIcon(new ImageIcon(VentanaClientes.class.getResource("/imagenes/save.png")));
		toolBar.add(btnGrabar);
		
		JButton btnModificar = new JButton("");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Clientes client = new Clientes();
				client.setCodigo(tbCodigo.getText());
				client.setNombre(tbNombre.getText());
				client.setTelefono(tbTelefono.getText());
				client.setLocalidad(cbLocalidad.getSelectedItem().toString());
				System.out.println("localidad: " + cbLocalidad.getSelectedItem().toString());
				
				FicherosClientes.modificar(client);
			}
		});
		btnModificar.setBackground(Color.LIGHT_GRAY);
		btnModificar.setBorder(null);
		btnModificar.setIcon(new ImageIcon(VentanaClientes.class.getResource("/imagenes/modificar.png")));
		toolBar.add(btnModificar);
		
		JButton btnEliminar = new JButton("");
		btnEliminar.setBackground(Color.LIGHT_GRAY);
		btnEliminar.setBorder(null);
		btnEliminar.setIcon(new ImageIcon(VentanaClientes.class.getResource("/imagenes/eliminar.png")));
		toolBar.add(btnEliminar);
		
		JPanel pFormulario = new JPanel();
		pFormulario.setLayout(null);
		GridBagConstraints gbc_pFormulario = new GridBagConstraints();
		gbc_pFormulario.fill = GridBagConstraints.BOTH;
		gbc_pFormulario.gridx = 0;
		gbc_pFormulario.gridy = 1;
		contentPane.add(pFormulario, gbc_pFormulario);
		
		JLabel lblNewLabel = new JLabel("Codigo:");
		lblNewLabel.setBounds(30, 26, 62, 14);
		pFormulario.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre:");
		lblNewLabel_1.setBounds(30, 51, 62, 14);
		pFormulario.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Telefono:");
		lblNewLabel_2.setBounds(30, 76, 62, 14);
		pFormulario.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Localidad:");
		lblNewLabel_3.setBounds(30, 101, 62, 14);
		pFormulario.add(lblNewLabel_3);
		
		tbCodigo = new JTextField();
		tbCodigo.setBounds(115, 23, 70, 20);
		pFormulario.add(tbCodigo);
		tbCodigo.setColumns(10);
		
		tbNombre = new JTextField();
		tbNombre.setBounds(115, 48, 178, 20);
		pFormulario.add(tbNombre);
		tbNombre.setColumns(10);
		
		tbTelefono = new JTextField();
		tbTelefono.setBounds(115, 73, 95, 20);
		pFormulario.add(tbTelefono);
		tbTelefono.setColumns(10);
		
		cbLocalidad = new JComboBox();
		cbLocalidad.setModel(new DefaultComboBoxModel(new String[] {"Malaga", "Sevilla", "Jaen", "Granada", "Cadiz", "Cordoba", "Almeria"}));
		cbLocalidad.setBounds(115, 97, 178, 22);
		pFormulario.add(cbLocalidad);
		
		JButton btnBuscar = new JButton("");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String [] datos = FicherosClientes.buscar(tbCodigo.getText());
				try {
					tbNombre.setText(datos[1]);
					tbTelefono.setText(datos[2]);
					cbLocalidad.setSelectedItem(datos[3]);
				}
				catch (NullPointerException e) {
					JOptionPane.showMessageDialog(null, "El codigo no existe", "Ventana Buscar", JOptionPane.ERROR_MESSAGE); // titulo de ventana y demas
				}
			}
		});
		btnBuscar.setBorder(null);
		btnBuscar.setToolTipText("Buscar");
		btnBuscar.setIcon(new ImageIcon(VentanaClientes.class.getResource("/imagenes/buscar.png")));
		btnBuscar.setBounds(195, 17, 31, 23);
		pFormulario.add(btnBuscar);
	}
}
