package g18.it1a.view;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.border.BevelBorder;

public class KontobewegungDlg extends JDialog {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField kontonummerTextField;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					KontobewegungDlg dialog = new KontobewegungDlg();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the dialog.
	 */
	public KontobewegungDlg() {
		setBounds(100, 100, 450, 300);
		setTitle("Kontobewegung");
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.NORTH);
		panel.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel kontonummerLabel = new JLabel("Kontonummer:");
		panel.add(kontonummerLabel);
		
		kontonummerTextField = new JTextField();
		panel.add(kontonummerTextField);
		kontonummerTextField.setColumns(10);
		
		JPanel listPanel = new JPanel();
		getContentPane().add(listPanel, BorderLayout.SOUTH);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		listPanel.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Datum", "Betrag", "Bemerkung"
			}
		) {
			Class[] columnTypes = new Class[] {
				Object.class, Double.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(2).setResizable(false);
		table.setRowSelectionAllowed(false);
		scrollPane.setViewportView(table);
		
		JButton anzeigenButton = new JButton("Kontobewegung anzeigen");
		getContentPane().add(anzeigenButton, BorderLayout.CENTER);

	}

}
