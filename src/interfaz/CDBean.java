package interfaz;
public class CDBean implements Comparable<CDBean>{
	
	int ID;
	String titulo, autor, genero, prestamo;
	
	public CDBean(int id, String titulo, String autor, String genero, String prestamo) {
		this.ID = id;
		this.titulo = titulo;
		this.autor = autor;
		this.genero = genero;
		this.prestamo = prestamo;
	}
	


	public int getID() {
		return ID;
	}
	public void setID(int ID) {
		this.ID = ID;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public String getPrestamo() {
		return prestamo;
	}
	public void setPrestamo(String prestamo) {
		this.prestamo = prestamo;
	}
	public String toString() {
		return titulo;
	}
	
	// comparar con el titulo
	@Override
	public int compareTo(CDBean o) {
		// TODO Auto-generated method stub
		String otroTitulo = o.getTitulo();
		return titulo.compareToIgnoreCase(otroTitulo);
	}
}