package db;


import java.sql.*;

public class Conexion {
	private static Connection conDB = null;
	private static String DBUrl = "jdbc:mysql://172.16.0.11:3306/prestamos?user=dam2&password=secreto";

	/** Devuelve un objeto del tipo Connection con la base de datos */
	public static Connection getConexion() {
		// Si no existe la conexion entonces se crea
		if (conDB == null) {

			try {
				// Obtenemos la conexion
				conDB = DriverManager.getConnection(DBUrl);
			} catch (SQLException sqle) {
				System.out.println("SQLException: " + sqle.getMessage());
				System.out.println("SQLState: " + sqle.getSQLState());
				System.out.println("VendorError: " + sqle.getErrorCode());
			}
		}
		// Devolvemos un objeto Connection
		return conDB;
	}

	/** Desconecta de la base de datos */

	public static void desconecta() {
		if (conDB != null) {
			try {
				conDB.close();
				conDB=null;
			} catch (SQLException sqle) {
				System.out.println("SQLException: " + sqle.getMessage());
				System.out.println("SQLState: " + sqle.getSQLState());
				System.out.println("VendorError: " + sqle.getErrorCode());

			}
		}
	}
}