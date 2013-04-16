package g18.it1a.view;

import javax.swing.JButton;
import javax.swing.JDialog;

public class ÜberweisungDurchführenDlg extends JDialog {

	private static final long serialVersionUID = -4868982222389995803L;
	private JButton überweisenButton;
	private JButton beendenButton;
	
	public ÜberweisungDurchführenDlg() {
		this.setTitle("Überweisung durchführen");
		this.setSize(337,200);
		this.setVisible(true);
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
}
