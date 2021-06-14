package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.Cliente;

public class ClienteDao {
	static final String JDBC_DRIVER = "com.mysql.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/http://localhost/phpmyadmin/index.php?route=/database/structure&server=1&db=banco_db";
	static final String DB_USER = "admin";
	static final String DB_PASS = "admin";
	
	private void registerDriver () {
		try {
			Class.forName(JDBC_DRIVER).newInstance();
		}catch (ClassNotFoundException |InstantiationException|IllegalAccessException e) {
			System.err.println ("ERROR: failed to load HSQLDB JDBC driver.");
			e.printStackTrace();
		}
	}
	
	public void  insert (Cliente cliente) {
		Connection conn = null;
		try {
			registerDriver();
			//ABRIR CONEXION
			conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
			try (Statement stmt = conn.createStatement()){
				String sentecia = "insert into cliente (nombre, apellido, cedula, telefono,email,ciudad,pais)values('"
						+ cliente.getNombre() + "' , '"
						+ cliente.getApellido() + "' , '"
						+ cliente.getCedula() + "' , '"
						+ cliente.getTelefono() + "' , '"
						+ cliente.getEmail() + "' , '"
						+ cliente.getCiudad() + "' , '"
						+ cliente.getPais() + " ')";
					stmt.executeUpdate(sentecia);
				}						
			}catch (SQLException e) {
				throw new RuntimeException(e);
			}finally {
				if (conn != null) {
					try {
						conn.close();
					}catch (SQLException e) {
				}
			}
		}

	}
	
	public Cliente read (Integer idCliente) {
		Connection conn = null;
		Cliente cliente = null;
		
		try {
			registerDriver();
			conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
			try (PreparedStatement ps = conn.prepareStatement(
					"select * from cliente where idCliente = ?")){
				ps.setInt(1, idCliente);
				try (ResultSet rs = ps.executeQuery()){
					if (rs.next()){
						cliente = new Cliente (idCliente,
								rs.getString("nombre"),
								rs.getString ("apellido"),
								rs.getInt ("cedula"),
								rs.getInt ("telefono"),
								rs.getString("email"),
								rs.getInt ("ciudad"),
								rs.getInt ("pais"));
					}
				}
			}
		}catch (SQLException e) {
			throw new RuntimeException (e);
		}finally {
			if (conn !=null) {
				try {
					conn.close();
				}catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return cliente;
	}
}

