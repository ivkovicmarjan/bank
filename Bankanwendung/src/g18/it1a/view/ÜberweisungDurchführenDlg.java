package g18.it1a.view;

import java.awt.Container;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class ÜberweisungDurchführenDlg extends JDialog {

	private static final long serialVersionUID = -4868982222389995803L;
	private JButton überweisenButton;
	private JButton beendenButton;
	private JButton datumButton;
	private Container contentPane;
	
	public ÜberweisungDurchführenDlg() {
		this.setTitle("Überweisung durchführen");
		this.setSize(354,280);
		this.setVisible(true);
		
		contentPane = this.getContentPane();
		getContentPane().setLayout(null);
		
		JLabel vonKontoLabel = new JLabel("Von Konto");
		vonKontoLabel.setBounds(10, 15, 103, 20);
		contentPane.add(vonKontoLabel);
		JTextField vonKontoField = new JTextField();
		vonKontoField.setBounds(100, 15, 103, 20);
		contentPane.add(vonKontoField);
		
		JLabel nachKontoLabel = new JLabel("Nach Konto");
		nachKontoLabel.setBounds(10, 61, 103, 20);
		contentPane.add(nachKontoLabel);
		JTextField nachKontoField = new JTextField();
		nachKontoField.setBounds(100, 61, 103, 20);
		contentPane.add(nachKontoField);
		
		JLabel datumLabel = new JLabel("Datum");
		datumLabel.setBounds(10, 110, 103, 20);
		contentPane.add(datumLabel);
		JTextField datumField = new JTextField();
		datumField.setBounds(100, 110, 103, 20);
		contentPane.add(datumField);
		
		JLabel betragLabel = new JLabel("Betrag");
		betragLabel.setBounds(10, 160, 103, 20);
		contentPane.add(betragLabel);
		JTextField betragField = new JTextField();
		betragField.setBounds(100, 160, 103, 20);
		contentPane.add(betragField);
	}

	public JButton getÜberweisenButton() {
		return überweisenButton;
	}

	public void setÜberweisenButton(JButton überweisenButton) {
		this.überweisenButton = überweisenButton;
	}

	public JButton getBeendenButton() {
		return beendenButton;
	}

	public void setBeendenButton(JButton beendenButton) {
		this.beendenButton = beendenButton;
	}

	public JButton getDatumButton() {
		return datumButton;
	}

	public void setDatumButton(JButton datumButton) {
		this.datumButton = datumButton;
	}
}
