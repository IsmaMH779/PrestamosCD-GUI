import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Dimension;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.border.EtchedBorder;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class CD extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private List<CDBean> CDs;
	
	private JPanel contentPane;
	private JTextField txtTitulo;
	private JTextField txtAutor;
	private JTextField txtGenero;
	private JTextArea txtPrestamo;
	
	private BuscarReg dlgBuscar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CD frame = new CD();
					frame.cargarListaCDs();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public List<CDBean> getCDs() {
		return CDs;
	}
	
	protected void mostrarBusqueda() {
		dlgBuscar = new BuscarReg(this);
		dlgBuscar.setVisible(true);
	}

	public void setRegDatos(int i) {
		CDBean cd = CDs.get(i);
		txtTitulo.setText(cd.getTitulo());
		txtAutor.setText(cd.getAutor());
		txtGenero.setText(cd.getGenero());
		txtPrestamo.setText(cd.getPrestamo());
	}
	
	private void salirForm() {
		int respuesta = JOptionPane.showConfirmDialog(null,
		"Esta acción cerrará la aplicación, ¿desea continuar?",
		"Atención",
		JOptionPane.YES_NO_OPTION);
		if (respuesta != JOptionPane.YES_OPTION) {
		return;
		}
		System.exit(0);
		}
	
	/**
	 * Create the frame.
	 */
	public CD() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				salirForm();
			}
		});
		CDs = new ArrayList<>();
		
		setResizable(false);
		setSize(new Dimension(400, 300));
		setTitle("CDs - Control de préstamos");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnMenuArchivo = new JMenu("Archivo");
		mnMenuArchivo.setMnemonic(KeyEvent.VK_A);
		menuBar.add(mnMenuArchivo);
		
		JMenuItem mntmAñadirReg = new JMenuItem("Añadir registro");
		mntmAñadirReg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String titulo = null, autor = null, genero = null, descripcion = null;
				titulo = txtTitulo.getText();
				if (titulo.isBlank()) {
					JOptionPane.showMessageDialog(null,
							"El camp titulo no puede estar vacio");
					return;
				}
				
				autor = txtAutor.getText();
				genero = txtGenero.getText();
				descripcion = txtPrestamo.getText();
				
				CDs.add(new CDBean(titulo, autor, genero, descripcion));
				
				if (dlgBuscar != null && dlgBuscar.isVisible())
					dlgBuscar.actualizarLista();
				
				JOptionPane.showMessageDialog(null, "Se ha añadido el CD a la colección");
				Collections.sort(CDs);
			}
		});
		mnMenuArchivo.add(mntmAñadirReg);
		
		JMenuItem mntmBuscarRegistro = new JMenuItem("Buscar registro");
		mntmBuscarRegistro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mostrarBusqueda();
			}
		});
		mnMenuArchivo.add(mntmBuscarRegistro);
		
		JSeparator separator = new JSeparator();
		mnMenuArchivo.add(separator);
		
		JMenuItem mntmSalir = new JMenuItem("Salir");
		mntmSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				salirForm();
			}
		});
		mnMenuArchivo.add(mntmSalir);
		//setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTitulo = new JLabel("Titulo");
		lblTitulo.setBounds(20, 20, 50, 14);
		contentPane.add(lblTitulo);
		
		JLabel lblAutor = new JLabel("Autor");
		lblAutor.setBounds(20, 60, 50, 14);
		contentPane.add(lblAutor);
		
		JLabel lblGenero = new JLabel("Género");
		lblGenero.setBounds(20, 100, 50, 14);
		contentPane.add(lblGenero);
		
		JLabel lblPrestamo = new JLabel("Préstamo");
		lblPrestamo.setBounds(20, 140, 100, 14);
		contentPane.add(lblPrestamo);
		
		JLabel jlbCreditos = new JLabel("copyright 2024 - SoftPuig");
		jlbCreditos.setBounds(3, 225, 339, 14);
		contentPane.add(jlbCreditos);
		
		txtTitulo = new JTextField();
		txtTitulo.setBounds(100, 17, 275, 21);
		contentPane.add(txtTitulo);
		txtTitulo.setColumns(10);
		
		txtAutor = new JTextField();
		txtAutor.setBounds(100, 57, 275, 21);
		contentPane.add(txtAutor);
		txtAutor.setColumns(10);
		
		txtGenero = new JTextField();
		txtGenero.setBounds(100, 97, 275, 21);
		contentPane.add(txtGenero);
		txtGenero.setColumns(10);
		
		txtPrestamo = new JTextArea();
		txtPrestamo.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		txtPrestamo.setLineWrap(true);
		txtPrestamo.setBounds(100, 137, 275, 70);
		contentPane.add(txtPrestamo);
	}
	
	private void cargarListaCDs() {
		CDs.add(new CDBean("Plays Monk", "Jamie Saft Trio", "Jazz", null));
		CDs.add(new CDBean("The Bricktionary", "Boldy James & Harry Fraud", "Hip-Hop", "Prestado a Rosa el 11/09/2024"));
		CDs.add(new CDBean("Ballads of Harry Houdini", "Papa M", "Indie", "Prestado a Marc el 15/09/2024"));
		CDs.add(new CDBean("Dead Slow", "Heavy Moss", "Rock", null));
		CDs.add(new CDBean("¿Y Qué Si Todo Acaba Mal?", "Kendall Peña", "Pop", "Prestado a Tomás el 22/10/2024"));
		CDs.add(new CDBean("Merciless", "Body Count", "Indie", "Prestado a Julián el 01/11/2024"));
		CDs.add(new CDBean("Happy New Year EP", "The Staves", "Country", null));
		CDs.add(new CDBean("Real Striker Music", "Babyfxce E", "Hip-Hop", "Prestado a Esther el 17/11/2024"));
		CDs.add(new CDBean("Peace of Action", "Damu The Fudgemunk", "Jazz",null));
		CDs.add(new CDBean("Phantom Brickworks", "Bibio", "Electronic", "Prestado a Josep el 01/12/2024"));
		CDs.add(new CDBean("10 Years of Rhythm Section International", "Various Artists", "Electronic", null));
		CDs.add(new CDBean("Wicked OST", "Various Artists", "Pop", null));
		CDs.add(new CDBean("Live From Brooklyn Paramount", "Black Pumas","Rock", "Prestado a Sandra el 02/11/2024"));
	}
}
