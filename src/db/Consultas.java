package db;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;



import interfaz.CDBean;

public class Consultas {
	
	public List<CDBean> getAllCDs() {
		
		List<CDBean> cds = new ArrayList();
		
		try (Statement statement = Conexion.getConexion().createStatement()) {
			
			StringBuffer sb = new StringBuffer();
			sb.append("SELECT * FROM cds order by titulo;");
			ResultSet res = statement.executeQuery(sb.toString());
			
			while ( res.next() ) {
				int ID = res.getInt("id");;
				String titulo = res.getString("titulo");
				String autor = res.getString("autor");
				String genero = res.getString("genero");
				String prestamo = res.getString("prestamo");
				
				cds.add(new CDBean(ID, titulo, autor, genero, prestamo));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return cds;
	}
	
	public void addNewCD(String titulo, String autor, String genero, String prestamo) {	
		 String sql = "INSERT INTO cds (titulo, autor, genero, prestamo) VALUES (?, ?, ?, ?)";
		
		try (PreparedStatement ps = Conexion.getConexion().prepareStatement(sql)) {
			
			ps.setString(1, titulo);
			ps.setString(2, autor);
			ps.setString(3, genero);
            ps.setString(4, prestamo);
            
            ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void deleteCD(int ID) {
		
		 String sql = "DELETE FROM cds WHERE id = ?";
			
		try (PreparedStatement ps = Conexion.getConexion().prepareStatement(sql)) {
			
			ps.setInt(1, ID);
			
			ps.executeUpdate();	
				
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
	}
	
}
