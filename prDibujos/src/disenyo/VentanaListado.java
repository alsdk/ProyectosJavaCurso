package disenyo;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import ficheros.FicherosClientes;

public class VentanaListado extends JFrame {
	private JTable table;

	/**
	 * Create the frame.
	 */
	public VentanaListado() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 422, 251);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		DefaultTableModel dtm = new DefaultTableModel(		
				new Object[][] {
				},
				new String[] {
					"Codigo", "Nombre", "Telefono", "Localidad"
				}
		);
		
		table.setModel(dtm);
		scrollPane.setViewportView(table);
		ArrayList<String> lineas = FicherosClientes.listado();
		for (String line: lineas) {
			dtm.addRow(line.split(";"));		// anyadir a la tabla en una fila el arraylist
		}
	}
}
