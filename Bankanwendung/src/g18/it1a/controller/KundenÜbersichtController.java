package g18.it1a.controller;

import java.util.Map.Entry;

import javax.swing.DefaultListModel;
import javax.swing.JList;

import g18.it1a.model.Kunde;
import g18.it1a.model.Kunden;
import g18.it1a.view.BankView;
import g18.it1a.view.KundenÜbersichtPanel;

public class KundenÜbersichtController {

	private KundenÜbersichtPanel kundenÜbersichtPanel = null;

	public KundenÜbersichtController(BankView bankView) {
		kundenÜbersichtPanel = new KundenÜbersichtPanel();
		bankView.setContentPane(kundenÜbersichtPanel);
		bankView.setTitle("Bank Anwendung - Kunden Übersicht");
		bankView.setVisible(true);
	}

	public void kundenÜbersichtActionPerformed() {
		DefaultListModel listModel = new DefaultListModel();
		JList kundenList = new JList(listModel);
		for (Entry<Integer, Kunde> entry : Kunden.getKunden().entrySet()) {
			listModel.addElement(entry.getValue());
		}
		kundenÜbersichtPanel.setKundenList(kundenList);
	}

}
