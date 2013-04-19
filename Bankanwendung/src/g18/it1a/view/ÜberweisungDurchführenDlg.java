package g18.it1a.view;

import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

public class �berweisungDurchf�hrenDlg extends JDialog {

	private static final long serialVersionUID = -4868982222389995803L;
	private JButton �berweisenButton;
	private JButton datumButton;
	private JTextField vonKontoField;
	private JTextField nachKontoField;
	private JTextField betragField;
	private Container contentPane;
	private JDateChooser dateChooser;
	
	public �berweisungDurchf�hrenDlg() {
		this.setTitle("�berweisung durchf�hren");
		this.setSize(260,230);
		this.setVisible(true);
		
		contentPane = this.getContentPane();
		getContentPane().setLayout(null);
		
		JLabel vonKontoLabel = new JLabel("Von Konto");
		vonKontoLabel.setBounds(10, 15, 60, 20);
		contentPane.add(vonKontoLabel);
		vonKontoField = new JTextField();
		vonKontoField.setBounds(90, 15, 120, 20);
		contentPane.add(vonKontoField);
		
		JLabel nachKontoLabel = new JLabel("Nach Konto");
		nachKontoLabel.setBounds(10, 46, 70, 20);
		contentPane.add(nachKontoLabel);
		nachKontoField = new JTextField();
		nachKontoField.setBounds(90, 46, 120, 20);
		contentPane.add(nachKontoField);		
		
		JLabel datumLabel = new JLabel("Datum");
		datumLabel.setBounds(10, 77, 60, 20);
		contentPane.add(datumLabel);
		
		dateChooser = new JDateChooser();
		dateChooser.setBounds(90, 77, 140, 20);
		getContentPane().add(dateChooser);
		
		JLabel betragLabel = new JLabel("Betrag");
		betragLabel.setBounds(10, 110, 60, 20);
		contentPane.add(betragLabel);
		betragField = new JTextField();
		betragField.setBounds(90, 108, 120, 20);
		contentPane.add(betragField);
		
		�berweisenButton = new JButton("�berweisen");
		�berweisenButton.setBounds(90, 149, 120, 20);
		contentPane.add(�berweisenButton);			
		
	}

	public JButton get�berweisenButton() {
		return �berweisenButton;
	}

	public void set�berweisenButton(JButton �berweisenButton) {
		this.�berweisenButton = �berweisenButton;
	}

	public JButton getDatumButton() {
		return datumButton;
	}

	public void setDatumButton(JButton datumButton) {
		this.datumButton = datumButton;
	}

	public JTextField getVonKontoField() {
		return vonKontoField;
	}

	public JDateChooser getDateChooser() {
		return dateChooser;
	}
}
