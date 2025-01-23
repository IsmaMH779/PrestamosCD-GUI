import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JList;

public class BuscarReg extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	
	private JScrollPane scPanel;
	private JList<CDBean> lstCDs;
	
	private CD ventanaPadre;
	
	/**
	 * Launch the application.
	 */
	
	/*
	public static void main(String[] args) {
		try {
			BuscarReg dialog = new BuscarReg();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	*/
	
	/**
	 * Create the dialog.
	 */
	public BuscarReg(JFrame frame) {
		ventanaPadre = (CD) frame;
		
		setTitle("Buscar Registro");
		setResizable(false);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		scPanel = new JScrollPane();
		scPanel.setBounds(17, 21, 247, 220);
		contentPanel.add(scPanel);
		{
			lstCDs = new JList<>();
			lstCDs.setAutoscrolls(true);
			
			lstCDs.setListData(new Vector<>(ventanaPadre.getCDs()));
			
			scPanel.setViewportView(lstCDs);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnAceptar = new JButton("Aceptar");
				btnAceptar.setName("btnAceptar");
				btnAceptar.setMnemonic('a');
				btnAceptar.setActionCommand("OK");
				buttonPane.add(btnAceptar);
				getRootPane().setDefaultButton(btnAceptar);
			}
			{
				JButton btnCancelar = new JButton("Cancelar");
				btnCancelar.setName("btnCancelar");
				btnCancelar.setMnemonic('c');
				btnCancelar.setActionCommand("Cancel");
				buttonPane.add(btnCancelar);
			}
			{
				JButton btnBorrar = new JButton("Borrar");
				btnBorrar.setName("btnBorrar");
				btnBorrar.setMnemonic('b');
				buttonPane.add(btnBorrar);
			}
		}
	}
}
