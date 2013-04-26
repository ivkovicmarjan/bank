package g18.it1a.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import g18.it1a.model.Konto;
import g18.it1a.model.KontoTyp;
import g18.it1a.model.Kunden;
import g18.it1a.view.KontoAnlegenPanel;
import g18.it1a.view.BankView;

import javax.swing.JOptionPane;

public class KontoAnlegenController {

	private KontoAnlegenPanel kontoAnlegenPanel;
	private BankHandler bankHandler;

	public KontoAnlegenController(final BankHandler bankHandler, BankView bankView) {
		this.bankHandler = bankHandler;
		kontoAnlegenPanel = new KontoAnlegenPanel();
		bankView.setContentPane(kontoAnlegenPanel);
		bankView.setTitle("Bank Anwendung - Konto anlegen");
		bankView.setVisible(true);
	}

	public void anlegenKontoActionPerformed() {

		kontoAnlegenPanel.getAnlegenButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				try {

					btAnlegenKontoActionPerformed(KontoTyp.valueOf(kontoAnlegenPanel.getButtonGroup().getSelection().getActionCommand()),
							kontoAnlegenPanel.getKundenNummerFeld().getText());
				} catch (NullPointerException e) {
					JOptionPane.showMessageDialog(kontoAnlegenPanel, "bitte wählen Sie einen Kontotyp aus!");
				}
			}
		});
	}

	private void btAnlegenKontoActionPerformed(KontoTyp kontotyp, String kundennummer) {
		double dispoZins = 0;
		int kundenNummer = 0;
		try {

			kundenNummer = Integer.parseInt(kundennummer);

		} catch (NumberFormatException e) {
			kontoAnlegenPanel.getKundenNummerFeld().setText("");
			String result = JOptionPane.showInputDialog(kontoAnlegenPanel, "Bitte Zahl als Kundennummer eingeben:", "Ungültiger Wert",
					JOptionPane.WARNING_MESSAGE);
			if (result == null) {
				return;
			}
			btAnlegenKontoActionPerformed(kontotyp, result);
			return;
		}

		if (Kunden.getKunde(kundenNummer) == null) {
			JOptionPane.showMessageDialog(kontoAnlegenPanel, "Dieser Kunde existiert nicht!", "Fehler", JOptionPane.ERROR_MESSAGE);
			return;
		}

		try {
			if (kontotyp.equals(KontoTyp.Girokonto)) {
				String dispoResult = JOptionPane.showInputDialog(kontoAnlegenPanel,
						"Bitte geben sie den gewünschten Dispo ein(Als Kommazahl Bsp.: 150.0):");
				if (dispoResult == null)
					return;
				dispoZins = Double.parseDouble(dispoResult);
			} else {
				String zinsResult = JOptionPane.showInputDialog(kontoAnlegenPanel,
						"Bitte geben sie den gewünschten Zinssatz ein(Als kommazahl Bsp.: 15.0)");
				if (zinsResult == null)
					return;
				dispoZins = Double.parseDouble(zinsResult);
			}
		} catch (NumberFormatException e) {
			dispoZins = Double.parseDouble(JOptionPane.showInputDialog(kontoAnlegenPanel, "Bitte nur Zahlenwerte eingeben:", "",
					JOptionPane.ERROR_MESSAGE));
		}
		Konto konto = bankHandler.anlegenKonto(kundenNummer, kontotyp, dispoZins);
		JOptionPane.showMessageDialog(kontoAnlegenPanel, "Ihr Konto wurde angelegt!\n Ihre Kontonummer lautet: " + konto.getKontoNummer());
	}
}
