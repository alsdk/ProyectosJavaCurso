package disenyo;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class VentanaConectar extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JPasswordField tbPassword;
	private JTextField tbLogin;

	/**
	 * Create the dialog.
	 */
	public VentanaConectar() {
		// desactivar los botones Operadores y llamadas si no estas logueado
		VentanaPrincipal.mnOperadores.setEnabled(false);
		VentanaPrincipal.mnLlamadas.setEnabled(false);
		
		setBounds(100, 100, 299, 170);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Login:");
		lblNewLabel.setBounds(10, 11, 55, 14);
		contentPanel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password:");
		lblNewLabel_1.setBounds(10, 58, 55, 14);
		contentPanel.add(lblNewLabel_1);
		
		tbPassword = new JPasswordField();
		tbPassword.setBounds(75, 55, 154, 20);
		contentPanel.add(tbPassword);
		
		tbLogin = new JTextField();
		tbLogin.setBounds(75, 8, 154, 20);
		contentPanel.add(tbLogin);
		tbLogin.setColumns(10);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						// al pulsar OK, comprobar si el user/pass = admin/admin
						if ( tbLogin.getText().equals("admin") && String.valueOf(tbPassword.getPassword()).equals("admin") ) {
							cerrar();
						}
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	private void cerrar() {
		this.setVisible(false);
		VentanaPrincipal.mnOperadores.setEnabled(true);
		VentanaPrincipal.mnLlamadas.setEnabled(true);
	}
}
