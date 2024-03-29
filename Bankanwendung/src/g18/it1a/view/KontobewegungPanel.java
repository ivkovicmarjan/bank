package g18.it1a.view;

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

public class KontobewegungPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private JTextField kontonummerTextField;
	private JTable table;
	private JButton anzeigenButton;

	/**
	 * Create the dialog.
	 */
	public KontobewegungPanel() {
		JPanel panel = new JPanel();
		add(panel, BorderLayout.NORTH);
		panel.setLayout(new GridLayout(0, 2, 0, 0));

		JLabel kontonummerLabel = new JLabel("Kontonummer:");
		panel.add(kontonummerLabel);

		kontonummerTextField = new JTextField();
		panel.add(kontonummerTextField);
		kontonummerTextField.setColumns(10);

		anzeigenButton = new JButton("Kontobewegung anzeigen");
		add(anzeigenButton, BorderLayout.SOUTH);

		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);

		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Datum", "Betrag", "Bemerkung" }) {
			private static final long serialVersionUID = -3406099133037067063L;
			Class<?>[] columnTypes = new Class[] { String.class, Double.class, String.class };

			public Class<?> getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}

			boolean[] columnEditables = new boolean[] { false, false, false };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(2).setResizable(false);
		table.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		scrollPane.setViewportView(table);

	}

	public JButton getAnzeigenButton() {
		return anzeigenButton;
	}

	public JTextField getKontonummerTextField() {
		return kontonummerTextField;
	}

	public JTable getTable() {
		return table;
	}

	public void setAnzeigenButton(JButton anzeigenButton) {
		this.anzeigenButton = anzeigenButton;
	}

}
