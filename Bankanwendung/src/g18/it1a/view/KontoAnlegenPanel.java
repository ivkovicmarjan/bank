package g18.it1a.view;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class KontoAnlegenPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	private JButton anlegenButton;
	private ButtonGroup buttonGroup;
	private JRadioButton giroButton;
	private JRadioButton sparButton;
	private JTextField kundenNummerFeld;

	public KontoAnlegenPanel() {
		// setTitle("Konto anlegen");
		setLayout(null);

		JLabel kontoTypLabel = new JLabel("Kontotyp:");
		kontoTypLabel.setBounds(10, 16, 79, 14);
		add(kontoTypLabel);

		buttonGroup = new ButtonGroup();

		giroButton = new JRadioButton();
		giroButton.setText("Girokonto");
		giroButton.setBounds(105, 10, 110, 20);
		giroButton.setActionCommand("Girokonto");
		buttonGroup.add(giroButton);

		sparButton = new JRadioButton();
		sparButton.setText("Sparkonto");
		sparButton.setBounds(105, 35, 110, 20);
		sparButton.setActionCommand("Sparkonto");
		buttonGroup.add(sparButton);

		add(giroButton);
		add(sparButton);

		JLabel lblNewLabel = new JLabel("Kundennummer:");
		lblNewLabel.setBounds(10, 70, 97, 20);
		add(lblNewLabel);

		kundenNummerFeld = new JTextField();
		kundenNummerFeld.setBounds(109, 70, 115, 20);
		add(kundenNummerFeld);
		kundenNummerFeld.setColumns(1);

		anlegenButton = new JButton("Anlegen");
		anlegenButton.setSize(110, 20);
		anlegenButton.setLocation(105, 116);
		add(anlegenButton);

	}

	public JButton getAnlegenButton() {
		return anlegenButton;
	}

	public JTextField getKundenNummerFeld() {
		return kundenNummerFeld;
	}

	public ButtonGroup getButtonGroup() {
		return buttonGroup;
	}

	public JRadioButton getGiroButton() {
		return giroButton;
	}

	public JRadioButton getSparButton() {
		return sparButton;
	}
}
