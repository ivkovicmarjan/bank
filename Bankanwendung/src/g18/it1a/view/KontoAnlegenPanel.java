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
	private JTextField kundenNummerField;
	private JTextField dispoZinsField;
	private JLabel dispoZinsLabel;

	public KontoAnlegenPanel() {
		setLayout(null);

		JLabel kontoTypLabel = new JLabel("Kontotyp");
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

		JLabel kundenNummerLabel = new JLabel("Kundennummer");
		kundenNummerLabel.setBounds(10, 70, 97, 20);
		add(kundenNummerLabel);

		kundenNummerField = new JTextField();
		kundenNummerField.setBounds(110, 70, 115, 20);
		add(kundenNummerField);
		kundenNummerField.setColumns(1);
		
		dispoZinsLabel = new JLabel("Dispo");
		dispoZinsLabel.setBounds(10, 100, 97, 20);
		add(dispoZinsLabel);
		
		dispoZinsField = new JTextField();
		dispoZinsField.setBounds(110, 100, 115, 20);
		dispoZinsField.setColumns(1);
		add(dispoZinsField);

		anlegenButton = new JButton("Anlegen");
		anlegenButton.setSize(110, 20);
		anlegenButton.setLocation(110, 130);
		add(anlegenButton);

	}

	public JButton getAnlegenButton() {
		return anlegenButton;
	}

	public JTextField getKundenNummerField() {
		return kundenNummerField;
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

	public JTextField getDispoZinsField() {
		return dispoZinsField;
	}

	public JLabel getDispoZinsLabel() {
		return dispoZinsLabel;
	}
}
