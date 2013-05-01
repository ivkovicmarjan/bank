package g18.it1a.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import g18.it1a.exceptions.CustomerNotFoundException;
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

		kontoAnlegenPanel.getGiroButton().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent newE) {
				kontoAnlegenPanel.getDispoZinsLabel().setText("Dispo");

			}
		});
		kontoAnlegenPanel.getSparButton().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent newE) {
				kontoAnlegenPanel.getDispoZinsLabel().setText("Zinssatz");
			}
		});

		kontoAnlegenPanel.getAnlegenButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				try {
					kontoAnlegenPanel.getDispoZinsField().setVisible(true);
					if (KontoTyp.valueOf(kontoAnlegenPanel.getButtonGroup().getSelection().getActionCommand()).equals(
							KontoTyp.Girokonto)) {

					}
					btAnlegenKontoActionPerformed(
							KontoTyp.valueOf(kontoAnlegenPanel.getButtonGroup().getSelection().getActionCommand()),
							kontoAnlegenPanel.getKundenNummerField().getText());
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
			kontoAnlegenPanel.getKundenNummerField().setText("");
			JOptionPane.showMessageDialog(kontoAnlegenPanel, "Bitte Zahl als Kundennummer eingeben.",
					"Ungültiger Wert", JOptionPane.WARNING_MESSAGE);

			return;
		}

		try {
			Kunden.getKunde(kundenNummer);

		} catch (CustomerNotFoundException e) {
			JOptionPane.showMessageDialog(kontoAnlegenPanel, "Dieser Kunde existiert nicht!", "Fehler",
					JOptionPane.ERROR_MESSAGE);
			return;
		}

		try {

			String dispoResult = kontoAnlegenPanel.getDispoZinsField().getText();
			dispoZins = Double.parseDouble(dispoResult);

		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(kontoAnlegenPanel, "Bitte nur Zahlenwerte eingeben.", "",
					JOptionPane.ERROR_MESSAGE);
			return;
		}

		Konto konto = bankHandler.anlegenKonto(kundenNummer, kontotyp, dispoZins);
		JOptionPane.showMessageDialog(kontoAnlegenPanel, "Ihr Konto wurde angelegt!\n Ihre Kontonummer lautet: "
				+ konto.getKontoNummer());
	}
}
