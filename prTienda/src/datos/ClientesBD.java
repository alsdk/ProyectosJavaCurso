package datos;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;

public class ClientesBD {
	private Connection conexion;

	public ClientesBD() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} 
		catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		}
			
	}
	
	public void grabar(String login, String pass, String mail, String tipo) {
		try {
			conexion = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/tienda", "root", "");
			// statement permite lanzar operaciones contra la base de datos
			//
			Statement comando = (Statement) conexion.createStatement();
			// para borrar, modificar y eliminar execute
			// para hacer consultas
			String cadena = "INSERT INTO clientes VALUES ('"+login+"', '"+pass+"', '"+mail+"', '"+tipo+"')";
			if ( !comando.execute(cadena) ) {
				JOptionPane.showMessageDialog(null, "Datos Grabados !!");
			}
			conexion.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void modificar(String login, String pass, String mail, String tipo) {
		try {
			conexion = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/tienda", "root", "");
			// statement permite lanzar operaciones contra la base de datos
			//
			Statement comando = (Statement) conexion.createStatement();
			// para borrar, modificar y eliminar execute
			// para hacer consultas
			String cadena = "UPDATE clientes SET email = '"+mail+"', password = '"+pass+"', tipo = '"+tipo+"' WHERE login = '"+login+"'";
			if ( !comando.execute(cadena) ) {
				JOptionPane.showMessageDialog(null, "Datos Modificados !!");
			}
			conexion.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ArrayList<String> buscar(String login) {
		ArrayList<String> res = new ArrayList<String>();
		try {
			conexion = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/tienda", "root", "");
			Statement comando = (Statement) conexion.createStatement();
			String consulta = "SELECT * FROM clientes WHERE login = '"+login+"'";
			ResultSet filas = (ResultSet) comando.executeQuery(consulta);
			if ( filas.next() ) {
				res.add(filas.getString(1)); // las columnas empiezan por 1
				res.add(filas.getString(2));
				res.add(filas.getString(3));
				res.add(filas.getString(4));
			}
			conexion.close();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}
	
	public void eliminar(String login) {
		try {
			conexion = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/tienda", "root", "");
			// statement permite lanzar operaciones contra la base de datos
			//
			Statement comando = (Statement) conexion.createStatement();
			// para borrar, modificar y eliminar execute
			// para hacer consultas
			String cadena = "DELETE FROM clientes WHERE login = '"+login+"'";
			if ( !comando.execute(cadena) ) {
				JOptionPane.showMessageDialog(null, "Datos Eliminados !!");
			}
			conexion.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
