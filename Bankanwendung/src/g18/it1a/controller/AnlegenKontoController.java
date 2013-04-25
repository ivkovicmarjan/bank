package g18.it1a.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import g18.it1a.model.Konto;
import g18.it1a.model.KontoTyp;
import g18.it1a.view.AnlegenKontoDlg;

import javax.swing.JOptionPane;

public class AnlegenKontoController {

	private AnlegenKontoDlg anlegenKontoDlg;
	private BankHandler bankHandler;

	public AnlegenKontoController(final BankHandler bankHandler) {
		this.bankHandler = bankHandler;
	}

	public void anlegenKontoActionPerformed() {
		anlegenKontoDlg = new AnlegenKontoDlg();

		anlegenKontoDlg.getAnlegenButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				try {

					btAnlegenKontoActionPerformed(KontoTyp.valueOf(anlegenKontoDlg.getButtonGroup().getSelection().getActionCommand()),
							anlegenKontoDlg.getKundenNummerFeld().getText());
				} catch (NullPointerException e) {
					JOptionPane.showMessageDialog(anlegenKontoDlg, "bitte w�hlen Sie einen Kontotyp aus!");
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
			anlegenKontoDlg.getKundenNummerFeld().setText("");
			kundennummer = JOptionPane.showInputDialog(anlegenKontoDlg, "Bitte Zahl als Kundennummer eingeben:");
		}

		if (kontotyp.equals(KontoTyp.Girokonto)) {
			dispoZins = Double.parseDouble(JOptionPane.showInputDialog(anlegenKontoDlg,
					"Bitte geben sie den gew�nschten Dispo ein(Als Kommazahl Bsp.: 150.0):"));
			if(JOptionPane.CANCEL_OPTION == 1){
				return;
			}
		} else {
			dispoZins = Double.parseDouble(JOptionPane.showInputDialog(anlegenKontoDlg,
					"Bitte geben sie den gew�nschten Zinssatz ein(Als kommazahl Bsp.: 15.0)"));
			if(JOptionPane.CANCEL_OPTION == 1){
				return;
			}
		}

		try {

			Konto konto = bankHandler.anlegenKonto(kundenNummer, kontotyp, dispoZins);
			JOptionPane.showMessageDialog(anlegenKontoDlg, "Ihr Konto wurde angelegt!\n Ihre Kontonummer lautet: " + konto.getKontoNummer());
			anlegenKontoDlg.dispose();

		} catch (NullPointerException e) {
			JOptionPane.showMessageDialog(anlegenKontoDlg, "Dieser Kunde existiert nicht!");
			anlegenKontoDlg.getKundenNummerFeld().setText("");
			if(JOptionPane.CANCEL_OPTION == 1){
				return;
			}
		}
	}
}
