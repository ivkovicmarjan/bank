package g18.it1a.view;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;

public class KontostandsübersichtAnzeigenDlg extends JDialog {

	private static final long serialVersionUID = 1L;
	private JTable kontostandTable;
	private JTextField kundennummerField;
	private JButton btnKontobersicht;

	public KontostandsübersichtAnzeigenDlg() 
	{
		this.setTitle("Kontostandübersicht Anzeigen");
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
		kontostandTable.setModel(new DefaultTableModel(new Object[][] {	},	
								 new String[] { "Kontoart", "Kontonummer", "Kontostand"})
								 {
									private static final long serialVersionUID = 1L;
									boolean[] columnEditables = new boolean[]
									{
										false,
										false, 
										false
									};
									public boolean isCellEditable(int row, int column)
									{
										return columnEditables[column];
									}
								 });
		
		kontostandTable.getColumnModel().getColumn(0).setPreferredWidth(71);
		kontostandTable.getColumnModel().getColumn(1).setPreferredWidth(89);
		kontostandTable.setBounds(10, 41, 368, 173);
		getContentPane().add(kontostandTable);
	
		kundennummerField = new JTextField();
		kundennummerField.setBounds(109, 8, 133, 20);
		getContentPane().add(kundennummerField);
		kundennummerField.setColumns(10);
	}
	
	public JTable getKontoubersicht() {
		return this.kontostandTable;
	}

	public JTextField getKundennummerField() {
		return this.kundennummerField;
	}
	
	public JButton getbtnKontoubersicht() {
		return this.btnKontobersicht;
	}
}
