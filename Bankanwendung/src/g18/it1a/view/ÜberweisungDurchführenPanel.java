package g18.it1a.view;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

public class ÜberweisungDurchführenPanel extends JPanel {

	private static final long serialVersionUID = -4868982222389995803L;
	private JButton überweisenButton;
	private JButton datumButton;
	private JTextField sourceField;
	private JTextField destinationField;
	private JTextField betragField;
	private JDateChooser dateChooser;
	private JTextField sourceNameField;
	private JTextField destinationNameField;

	public ÜberweisungDurchführenPanel() {
		setLayout(null);

		JLabel sourceLabel = new JLabel("Von Konto");
		sourceLabel.setBounds(10, 10, 100, 20);
		add(sourceLabel);
		sourceField = new JTextField();
		sourceField.setBounds(110, 10, 120, 20);
		add(sourceField);

		JLabel destinationLabel = new JLabel("Nach Konto");
		destinationLabel.setBounds(10, 50, 100, 20);
		add(destinationLabel);
		destinationField = new JTextField();
		destinationField.setBounds(110, 50, 120, 20);
		add(destinationField);

		JLabel dateLabel = new JLabel("Datum");
		dateLabel.setBounds(10, 90, 100, 20);
		add(dateLabel);

		dateChooser = new JDateChooser();
		dateChooser.setBounds(110, 90, 120, 20);
		add(dateChooser);

		JLabel betragLabel = new JLabel("Betrag");
		betragLabel.setBounds(10, 130, 100, 20);
		add(betragLabel);
		betragField = new JTextField();
		betragField.setBounds(110, 130, 120, 20);
		add(betragField);

		überweisenButton = new JButton("Überweisen");
		überweisenButton.setBounds(300, 130, 120, 23);
		add(überweisenButton);

		JLabel sourceNameLabel = new JLabel("Name");
		sourceNameLabel.setBounds(250, 10, 46, 20);
		add(sourceNameLabel);

		sourceNameField = new JTextField();
		sourceNameField.setEditable(false);
		sourceNameField.setBounds(300, 10, 120, 20);
		add(sourceNameField);
		sourceNameField.setColumns(10);

		JLabel destinationNameLabel = new JLabel("Name");
		destinationNameLabel.setBounds(250, 50, 46, 14);
		add(destinationNameLabel);

		destinationNameField = new JTextField();
		destinationNameField.setEditable(false);
		destinationNameField.setBounds(300, 50, 120, 20);
		add(destinationNameField);
		destinationNameField.setColumns(10);

	}

	public JButton getÜberweisenButton() {
		return überweisenButton;
	}

	public void setÜberweisenButton(JButton überweisenButton) {
		this.überweisenButton = überweisenButton;
	}

	public JButton getDatumButton() {
		return datumButton;
	}

	public void setDatumButton(JButton datumButton) {
		this.datumButton = datumButton;
	}

	public JTextField getSourceField() {
		return sourceField;
	}

	public JTextField getDestinationField() {
		return destinationField;
	}

	public JTextField getBetragField() {
		return betragField;
	}

	public JDateChooser getDateChooser() {
		return dateChooser;
	}

	public JTextField getSourceNameField() {
		return sourceNameField;
	}

	public JTextField getDestinationNameField() {
		return destinationNameField;
	}
}
