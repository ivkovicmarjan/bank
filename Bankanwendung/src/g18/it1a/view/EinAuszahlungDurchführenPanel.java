package g18.it1a.view;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class EinAuszahlungDurchführenPanel extends JPanel {

	private static final long serialVersionUID = 8589480193184816213L;
	private JTextField betragField;
	private JButton einzahlenButton;
	private JTextField kundennummerField;
	private JTextField alterKontostandField;
	private JButton auszahlenButton;
	private JTextField neuerKontostandField;

	public EinAuszahlungDurchführenPanel() {
		setLayout(null);

		JLabel betragLabel = new JLabel("Betrag:");
		betragLabel.setBounds(10, 76, 64, 14);
		add(betragLabel);

		this.betragField = new JTextField();
		this.betragField.setBounds(137, 73, 117, 20);
		add(this.betragField);
		this.betragField.setColumns(10);

		this.einzahlenButton = new JButton("Einzahlen");
		this.einzahlenButton.setBounds(10, 149, 99, 23);
		add(this.einzahlenButton);

		this.auszahlenButton = new JButton("Auszahlen");
		this.auszahlenButton.setBounds(150, 149, 104, 23);
		add(this.auszahlenButton);

		this.kundennummerField = new JTextField();
		this.kundennummerField.setBounds(137, 11, 117, 20);
		add(this.kundennummerField);
		this.kundennummerField.setColumns(10);

		this.alterKontostandField = new JTextField();
		alterKontostandField.setEditable(false);
		this.alterKontostandField.setBounds(137, 42, 117, 20);
		add(this.alterKontostandField);
		this.alterKontostandField.setColumns(10);

		JLabel lblNewLabel = new JLabel("Kontonummer:");
		lblNewLabel.setBounds(10, 14, 104, 14);
		add(lblNewLabel);

		JLabel lblAlterKontostand = new JLabel("Alter Kontostand:");
		lblAlterKontostand.setBounds(10, 45, 104, 14);
		add(lblAlterKontostand);

		this.neuerKontostandField = new JTextField();
		neuerKontostandField.setEditable(false);
		this.neuerKontostandField.setColumns(10);
		this.neuerKontostandField.setBounds(137, 104, 117, 20);
		add(this.neuerKontostandField);

		JLabel lblNeuerKontostand = new JLabel("Neuer Kontostand:");
		lblNeuerKontostand.setBounds(10, 107, 117, 14);
		add(lblNeuerKontostand);
	}

	public JTextField getBetragField() {
		return this.betragField;
	}

	public JTextField getKundennummerField() {
		return this.kundennummerField;
	}

	public JButton getEinzahlenButton() {
		return this.einzahlenButton;
	}

	public JButton getAuszahlenButton() {
		return this.auszahlenButton;
	}

	public JTextField getAlterKontostandField() {
		return this.alterKontostandField;
	}

	public void setAlterKontostandField(int betrag) {
		this.alterKontostandField.setText("" + betrag);
	}

	public JTextField getNeuerKontostandField() {
		return this.neuerKontostandField;
	}

	public void setNeuerKontostandField(int betrag) {
		this.neuerKontostandField.setText("" + betrag);
	}
}
