package g18.it1a.controller;

import g18.it1a.exceptions.CustomerAlreadyExistsException;
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

	public void kundeAnlegenActionPerformed() {
		kundeAnlegenPanel.getAnlegenButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				btKundeAnlegenActionPerformed(kundeAnlegenPanel.getKundenNummerField().getText(), kundeAnlegenPanel
						.getKundenNameField().getText());
			}
		});
	}

	private void btKundeAnlegenActionPerformed(String kundeNummer, String kundenName) {
		try {
			int kundenNummer = Integer.parseInt(kundeNummer);
			if (kundenName.length() < 1) {
				JOptionPane.showMessageDialog(kundeAnlegenPanel, "Bitte einen richtigen Namen eingeben.", "Fehler!",
						JOptionPane.ERROR_MESSAGE);
			} else {
				if (kundenNummer == 0) {
					JOptionPane.showMessageDialog(kundeAnlegenPanel,
							"Bitte eine Zahl die nicht 0 ist als Kundennummer eingeben.", "Fehler!",
							JOptionPane.ERROR_MESSAGE);
				} else {
					Kunde neuerKunde = bankHandler.anlegenKunde(kundenName, kundenNummer);
					JOptionPane.showMessageDialog(kundeAnlegenPanel, "Kunde: " + neuerKunde.getName() + " angelegt.");
				}
			}
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(kundeAnlegenPanel,
					"Bitte eine Zahl die nicht 0 ist als Kundennummer eingeben.", "Fehler!", JOptionPane.ERROR_MESSAGE);

		} catch (CustomerAlreadyExistsException e) {
			JOptionPane.showMessageDialog(kundeAnlegenPanel, "Ein Kunde mit dieser Nummer existiert bereits",
					"Fehler!", JOptionPane.ERROR_MESSAGE);
		}
	}
}
