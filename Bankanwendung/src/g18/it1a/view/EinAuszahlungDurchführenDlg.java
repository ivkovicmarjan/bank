package g18.it1a.view;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class EinAuszahlungDurchführenDlg extends JDialog
{
	private static final long serialVersionUID = 8589480193184816213L;
	private JTextField einzahlungField;
	private JTextField auszahlungField;
	private JButton beendenButton;
	private JButton einauszahlenButton;
	
	public EinAuszahlungDurchführenDlg(BankView bankView, boolean b) 
	{
		this.getContentPane().setLayout(null);
		
		JLabel einzahlungLabel = new JLabel("Einzahlungsbetrag:");
		einzahlungLabel.setBounds(10, 11, 105, 14);
		this.getContentPane().add(einzahlungLabel);
		
		JLabel lblAuszahlungsbetrag = new JLabel("Auszahlungsbetrag:");
		lblAuszahlungsbetrag.setBounds(10, 49, 105, 14);
		this.getContentPane().add(lblAuszahlungsbetrag);
		
		this.einzahlungField = new JTextField();
		this.einzahlungField.setBounds(114, 8, 125, 20);
		this.getContentPane().add(this.einzahlungField);
		this.einzahlungField.setColumns(10);
		
		this.auszahlungField = new JTextField();
		this.auszahlungField.setBounds(114, 46, 125, 20);
		this.getContentPane().add(this.auszahlungField);
		this.auszahlungField.setColumns(10);
		
		JButton einauszahlenButton = new JButton("Ein-/Auszahlen");
		einauszahlenButton.setBounds(10, 101, 115, 23);
		this.getContentPane().add(einauszahlenButton);
		
		JButton beendenButton = new JButton("Beenden");
		beendenButton.setBounds(135, 101, 104, 23);
		this.getContentPane().add(beendenButton);
	}	
	
	public JTextField getAuszahlungField() {
		return this.auszahlungField;
	}

	public JTextField getEinzahlungField() {
		return this.einzahlungField;
	}

	public JButton getEinauszahlenButton() {
		return this.einauszahlenButton;
	}

	public JButton getBeendenButton() {
		return this.beendenButton;
	}
}
