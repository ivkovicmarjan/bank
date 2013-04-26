package g18.it1a.controller;

import g18.it1a.model.Kunde;
import g18.it1a.view.BankView;
import g18.it1a.view.KundeAnlegenPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class KundeAnlegenController {

	private KundeAnlegenPanel kundeAnlegenPanel;
	private BankHandler bankHandler;

	public KundeAnlegenController(BankHandler bankHandler, BankView bankView) {
		this.bankHandler = bankHandler;
		kundeAnlegenPanel = new KundeAnlegenPanel();
		bankView.setContentPane(kundeAnlegenPanel);
		bankView.setTitle("Bank Anwendung - Kunde anlegen");
		bankView.setVisible(true);
	}

	public void anlegenKundenActionPerformed() {
		kundeAnlegenPanel.getAnlegenButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				btAnlegenKundeActionPerformed(kundeAnlegenPanel.getKundenNummerField().getText(), kundeAnlegenPanel.getKundenNameField().getText());
			}
		});
	}

	private void btAnlegenKundeActionPerformed(String kundeNummer, String kundenName) {
		try {
			int kundenNummer = Integer.parseInt(kundeNummer);

			if (kundenName.length() < 1) {
				String result = JOptionPane.showInputDialog(kundeAnlegenPanel, "Bitte einen richtigen Namen eingeben.", "Fehler!",
						JOptionPane.ERROR_MESSAGE);
				btAnlegenKundeActionPerformed(kundeAnlegenPanel.getKundenNummerField().getText(), result);
			} else {
				if (kundenNummer == 0) {
					String result = JOptionPane.showInputDialog(kundeAnlegenPanel, "Bitte eine Zahl die nicht 0 ist als Kundennummer eingeben.",
							"Fehler!", JOptionPane.ERROR_MESSAGE);

					if (result != null) {
						btAnlegenKundeActionPerformed(result, kundeAnlegenPanel.getKundenNameField().getText());
					}
				} else {
					Kunde neuerKunde = bankHandler.anlegenKunde(kundenName, kundenNummer);
					JOptionPane.showMessageDialog(kundeAnlegenPanel, "Kunde: " + neuerKunde.getName() + " angelegt.");
				}
			}
		} catch (NumberFormatException e) {
			String result = JOptionPane.showInputDialog(kundeAnlegenPanel, "Bitte eine Zahl die nicht 0 ist als Kundennummer eingeben.", "Fehler!",
					JOptionPane.ERROR_MESSAGE);

			if (result != null) {
				btAnlegenKundeActionPerformed(result, kundeAnlegenPanel.getKundenNameField().getText());
			}
		}
	}
}
