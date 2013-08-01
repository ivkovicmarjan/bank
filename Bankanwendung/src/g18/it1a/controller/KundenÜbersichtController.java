package g18.it1a.controller;

import java.util.Map.Entry;

import javax.swing.DefaultListModel;
import javax.swing.JList;

import g18.it1a.model.Kunde;
import g18.it1a.model.Kunden;
import g18.it1a.view.BankView;
import g18.it1a.view.Kunden‹bersichtPanel;

public class Kunden‹bersichtController {

	private Kunden‹bersichtPanel kunden‹bersichtPanel = null;

	public Kunden‹bersichtController(BankView bankView) {
		kunden‹bersichtPanel = new Kunden‹bersichtPanel();
		bankView.setContentPane(kunden‹bersichtPanel);
		bankView.setTitle("Bank Anwendung - Kunden ‹bersicht");
		bankView.setVisible(true);
	}

	public void kunden‹bersichtActionPerformed() {
		DefaultListModel listModel = new DefaultListModel();
		JList kundenList = new JList(listModel);
		for (Entry<Integer, Kunde> entry : Kunden.getKunden().entrySet()) {
			listModel.addElement(entry.getValue());
		}
		kunden‹bersichtPanel.setKundenList(kundenList);
	}

}
