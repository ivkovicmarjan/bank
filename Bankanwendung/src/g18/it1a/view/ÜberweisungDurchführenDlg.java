package g18.it1a.view;

import javax.swing.JButton;
import javax.swing.JDialog;

public class �berweisungDurchf�hrenDlg extends JDialog {

	private static final long serialVersionUID = -4868982222389995803L;
	private JButton �berweisenButton;
	private JButton beendenButton;
	
	public �berweisungDurchf�hrenDlg() {
		this.setTitle("�berweisung durchf�hren");
		this.setSize(337,200);
		this.setVisible(true);
	}

	public JButton get�berweisenButton() {
		return �berweisenButton;
	}

	public void set�berweisenButton(JButton �berweisenButton) {
		this.�berweisenButton = �berweisenButton;
	}

	public JButton getBeendenButton() {
		return beendenButton;
	}

	public void setBeendenButton(JButton beendenButton) {
		this.beendenButton = beendenButton;
	}
}
