package g18.it1a.view;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.JScrollPane;
import javax.swing.JPanel;

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
	
		kundennummerField = new JTextField();
		kundennummerField.setBounds(109, 8, 133, 20);
		getContentPane().add(kundennummerField);
		kundennummerField.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 44, 368, 168);
		getContentPane().add(scrollPane);
		
		kontostandTable = new JTable(new String[][]{{"", "", ""}}, new String[]{"Kontoart", "Kontonummer", "Kontostand"});
		kontostandTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Kontoart", "Kontonummer", "Kontostand"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(kontostandTable);
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
