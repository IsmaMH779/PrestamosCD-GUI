package interfaz;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;

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
	ActionListener listenerDiaologo = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			gestionarBotones(e);
		}
	};
	
	private void gestionarBotones(ActionEvent e) {
		switch(e.getActionCommand()) {
			case "aceptar":
				int i = lstCDs.getSelectedIndex();
				if (i >= 0) ventanaPadre.setRegDatos(i);
				break;
			case "cancelar":
				setVisible(false);
				dispose();
				break;
			case "borrar":
				int j = lstCDs.getSelectedIndex();
				if (j >=0) {
					int respuesta = JOptionPane.showConfirmDialog(null,
					"Esta acción eliminará el CD ¿desea continuar?",
					"Atención", JOptionPane.YES_NO_OPTION);
					
					if (respuesta == JOptionPane.YES_OPTION) {
						
						CDBean cd = ventanaPadre.getCDs().get(j);
						ventanaPadre.consultas.deleteCD(cd.ID);
						
						this.actualizarLista();
					}
				}
		}
	}

	public void actualizarLista() {
		ventanaPadre.cargarListaCDs();
		lstCDs.setListData(new Vector<>(ventanaPadre.getCDs()));
	}

	
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
				btnAceptar.addActionListener(listenerDiaologo);
				btnAceptar.setActionCommand("aceptar");
				btnAceptar.setName("btnAceptar");
				btnAceptar.setMnemonic('a');
				buttonPane.add(btnAceptar);
				getRootPane().setDefaultButton(btnAceptar);
			}
			{
				JButton btnCancelar = new JButton("Cancelar");
				btnCancelar.addActionListener(listenerDiaologo);
				btnCancelar.setActionCommand("cancelar");
				btnCancelar.setName("btnCancelar");
				btnCancelar.setMnemonic('c');
				buttonPane.add(btnCancelar);
			}
			{
				JButton btnBorrar = new JButton("Borrar");
				btnBorrar.addActionListener(listenerDiaologo);
				btnBorrar.setActionCommand("borrar");
				btnBorrar.setName("btnBorrar");
				btnBorrar.setMnemonic('b');
				buttonPane.add(btnBorrar);
			}
		}
	}
}
