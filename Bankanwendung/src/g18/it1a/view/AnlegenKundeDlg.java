package g18.it1a.view;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class AnlegenKundeDlg extends JDialog {

	private JLabel kundenNummerLabel;
	private JTextField kundenNummerField;
	private JTextField kundenNameField;
	private JButton anlegenButton;
	private JButton beendenButton;
	private static final long serialVersionUID = 2326402193059787237L;

	public AnlegenKundeDlg(BankView bankView, boolean b) {
		this.setTitle("Kunde anlegen");
		this.setSize(229,180);
		this.setVisible(true);
		this.setModal(true);
		
		this.kundenNummerLabel = new JLabel("Kundennummer:");
		this.kundenNummerLabel.setBounds(10, 11, 124, 23);
		
		this.anlegenButton = new JButton("Anlegen");
		this.anlegenButton.setBounds(10, 105, 84, 23);
		
		this.beendenButton = new JButton("Beenden");
		this.beendenButton.setBounds(111, 105, 84, 23);
		
		this.getContentPane().setLayout(null);
		this.getContentPane().add(this.kundenNummerLabel);
		this.getContentPane().add(this.anlegenButton);
		this.getContentPane().add(this.beendenButton);
		
		JLabel lblKundenname = new JLabel("Kundenname:");
		lblKundenname.setBounds(10, 48, 89, 14);
		this.getContentPane().add(lblKundenname);
		
		this.kundenNummerField = new JTextField();
		this.kundenNummerField.setBounds(111, 12, 89, 20);
		this.getContentPane().add(this.kundenNummerField);
		this.kundenNummerField.setColumns(10);
		
		this.kundenNameField = new JTextField();
		this.kundenNameField.setBounds(111, 45, 89, 20);
		this.getContentPane().add(this.kundenNameField);
		this.kundenNameField.setColumns(10);
	}

	public JTextField getKundenNummerField() {
		return this.kundenNummerField;
	}

	public JTextField getKundenNameField() {
		return this.kundenNameField;
	}

	public JButton getAnlegenButton() {
		return this.anlegenButton;
	}

	public JButton getBeendenButton() {
		return this.beendenButton;
	}
}
