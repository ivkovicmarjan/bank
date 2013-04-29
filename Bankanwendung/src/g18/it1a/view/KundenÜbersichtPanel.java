package g18.it1a.view;

import g18.it1a.model.Kunde;

import javax.swing.JPanel;
import javax.swing.JList;

public class Kunden‹bersichtPanel extends JPanel {

	private JList<Kunde> kundenList = null;

	private static final long serialVersionUID = 8702229179897702095L;

	public Kunden‹bersichtPanel() {
		setLayout(null);

	}

	public void setKundenList(JList<Kunde> newKundenList) {
		kundenList = newKundenList;
		kundenList.setBounds(28, 23, 375, 237);
		add(kundenList);
	}
}
