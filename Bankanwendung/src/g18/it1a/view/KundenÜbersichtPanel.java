package g18.it1a.view;

import javax.swing.JPanel;
import javax.swing.JList;

public class KundenÜbersichtPanel extends JPanel {

	private JList kundenList = null;

	private static final long serialVersionUID = 8702229179897702095L;

	public KundenÜbersichtPanel() {
		setLayout(null);

	}

	public void setKundenList(JList newKundenList) {
		kundenList = newKundenList;
		kundenList.setBounds(28, 23, 375, 237);
		add(kundenList);
	}
}
