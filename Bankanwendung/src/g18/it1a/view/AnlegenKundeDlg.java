package g18.it1a.view;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JTextField;

public class AnlegenKundeDlg extends JDialog {
	
	private JTextField kundenNummerField;
	private JTextField kundenNameField;
	private JButton anlegenButton;
	private JButton beendenButton;

	private static final long serialVersionUID = 2326402193059787237L;

	public AnlegenKundeDlg(BankView bankView, boolean b) {
		setTitle("Kunde anlegen");
		setSize(200,200);
		setVisible(true);
		setModal(true);
		anlegenButton = new JButton("Anlegen");
		beendenButton = new JButton("Beenden");
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

	public AbstractButton getBeendenButton() {
		return beendenButton;
	}
}
