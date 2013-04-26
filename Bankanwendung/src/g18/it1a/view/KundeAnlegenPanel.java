package g18.it1a.view;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class KundeAnlegenPanel extends JPanel {

	private JLabel kundenNummerLabel;
	private JTextField kundenNummerField;
	private JTextField kundenNameField;
	private JButton anlegenButton;
	private static final long serialVersionUID = 2326402193059787237L;

	public KundeAnlegenPanel() {
		setLayout(null);

		kundenNummerLabel = new JLabel("Kundennummer:");
		kundenNummerLabel.setBounds(10, 11, 124, 23);

		anlegenButton = new JButton("Anlegen");
		anlegenButton.setBounds(116, 76, 84, 23);

		add(kundenNummerLabel);
		add(anlegenButton);

		JLabel lblKundenname = new JLabel("Kundenname:");
		lblKundenname.setBounds(10, 48, 89, 14);
		add(lblKundenname);

		kundenNummerField = new JTextFieldWithLimit(5);
		kundenNummerField.setBounds(111, 12, 89, 20);
		add(kundenNummerField);

		kundenNameField = new JTextField();
		kundenNameField.setBounds(111, 45, 89, 20);
		add(kundenNameField);
		kundenNameField.setColumns(10);
	}

	public JTextField getKundenNummerField() {
		return kundenNummerField;
	}

	public JTextField getKundenNameField() {
		return kundenNameField;
	}

	public JButton getAnlegenButton() {
		return anlegenButton;
	}
}
