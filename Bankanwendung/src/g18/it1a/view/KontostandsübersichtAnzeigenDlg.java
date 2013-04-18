package g18.it1a.view;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;

public class KontostandsübersichtAnzeigenDlg extends JDialog {

	private static final long serialVersionUID = 1L;
	private JTable kontostandTable;
	private JTextField kundennummerField;
	private JButton btnKontobersicht;

	public KontostandsübersichtAnzeigenDlg() 
	{
		this.setTitle("Kontostandübersicht Anzeign");
		this.setSize(408,261);
		this.setVisible(true);
		
		getContentPane().setLayout(null);
		
		JLabel lblKundennummer = new JLabel("Kundennummer:");
		lblKundennummer.setBounds(10, 11, 133, 14);
		getContentPane().add(lblKundennummer);
		
		btnKontobersicht = new JButton("Konto\u00FCbersicht");
		btnKontobersicht.setBounds(252, 7, 126, 23);
		getContentPane().add(btnKontobersicht);
		
		kontostandTable = new JTable();
		kontostandTable.setBounds(10, 41, 368, 173);
		getContentPane().add(kontostandTable);
		
		kundennummerField = new JTextField();
		kundennummerField.setBounds(103, 8, 139, 20);
		getContentPane().add(kundennummerField);
		kundennummerField.setColumns(10);
	}
	
	public JTable btnKontobersicht() {
		return this.kontostandTable;
	}

	public JTextField getKundennummerField() {
		return this.kundennummerField;
	}
	
	public JButton getbtnKontobersicht() {
		return this.btnKontobersicht;
	}
}
