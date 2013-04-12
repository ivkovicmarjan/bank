package g18.it1a.view;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JTable;

public class EinAuszahlungDurchführenDlg extends JDialog
{
	private static final long serialVersionUID = 8589480193184816213L;
	private JTextField betragField;
	private JButton beendenButton;
	private JButton einzahlenButton;
	private JTextField kundennummerField;
	private JTextField kundennameField;
	
	public EinAuszahlungDurchführenDlg(BankView bankView, boolean b) 
	{
		this.setTitle("Ein-/Auszahlung Durchführen");
		this.setSize(337,200);
		this.setVisible(true);
		
		this.getContentPane().setLayout(null);
		
		JLabel betragLabel = new JLabel("Betrag:");
		betragLabel.setBounds(10, 83, 64, 14);
		this.getContentPane().add(betragLabel);
		
		this.betragField = new JTextField();
		this.betragField.setBounds(116, 80, 181, 20);
		this.getContentPane().add(this.betragField);
		this.betragField.setColumns(10);
		
		this.einzahlenButton = new JButton("Einzahlen");
		this.einzahlenButton.setBounds(10, 128, 99, 23);
		this.getContentPane().add(this.einzahlenButton);
		
		this.beendenButton = new JButton("Beenden");
		this.beendenButton.setBounds(230, 128, 87, 23);
		this.getContentPane().add(this.beendenButton);
		
		JButton auszahlenButton = new JButton("Auszahlen");
		auszahlenButton.setBounds(116, 128, 104, 23);
		getContentPane().add(auszahlenButton);
		
		kundennummerField = new JTextField();
		kundennummerField.setBounds(116, 11, 181, 20);
		getContentPane().add(kundennummerField);
		kundennummerField.setColumns(10);
		
		kundennameField = new JTextField();
		kundennameField.setEditable(false);
		kundennameField.setBounds(116, 42, 181, 20);
		getContentPane().add(kundennameField);
		kundennameField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Kundennummer:");
		lblNewLabel.setBounds(10, 14, 104, 14);
		getContentPane().add(lblNewLabel);
		
		JLabel lblKundenname = new JLabel("Kundenname:");
		lblKundenname.setBounds(10, 45, 113, 14);
		getContentPane().add(lblKundenname);
	}	
	
	public JTextField getEinzahlungField() {
		return this.betragField;
	}

	public JButton getEinauszahlenButton() {
		return this.einzahlenButton;
	}

	public JButton getBeendenButton() {
		return this.beendenButton;
	}
}
