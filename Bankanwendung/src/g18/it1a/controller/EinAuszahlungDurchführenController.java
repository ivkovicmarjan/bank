package g18.it1a.controller;

import g18.it1a.exceptions.AccountNotFoundException;
import g18.it1a.exceptions.LiquidityException;
import g18.it1a.model.Kunden;
import g18.it1a.view.BankView;
import g18.it1a.view.EinAuszahlungDurchf�hrenPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class EinAuszahlungDurchf�hrenController {

	private EinAuszahlungDurchf�hrenPanel einAuszahlungDurchf�hrenPanel;

	public EinAuszahlungDurchf�hrenController(BankView bankView) {
		einAuszahlungDurchf�hrenPanel = new EinAuszahlungDurchf�hrenPanel();
		bankView.setContentPane(einAuszahlungDurchf�hrenPanel);
		bankView.setTitle("Bank Anwendung - Ein/Auszahlung durchf�hren");
		bankView.setVisible(true);
	}

	public void einAuszahlenActionPerformed() {

		einAuszahlungDurchf�hrenPanel.getEinzahlenButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				btEinzahlenActionPerformed(einAuszahlungDurchf�hrenPanel.getBetragField().getText(),
						einAuszahlungDurchf�hrenPanel.getKundennummerField().getText());
			}
		});

		einAuszahlungDurchf�hrenPanel.getAuszahlenButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				btAuszahlenActionPerformed(einAuszahlungDurchf�hrenPanel.getBetragField().getText(),
						einAuszahlungDurchf�hrenPanel.getKundennummerField().getText());
			}
		});
	}

	private void btAuszahlenActionPerformed(String value, String kontoNummer) {
		double betrag;
		long kontonummer;

		try {
			kontonummer = Long.valueOf(kontoNummer);
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(einAuszahlungDurchf�hrenPanel, "Bitte Zahl als Kontonummer eingeben.");
			return;
		}

		try {
			betrag = Double.valueOf(value);
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(einAuszahlungDurchf�hrenPanel, "Bitte Zahl als Betrag eingeben.");

			return;
		}

		einAuszahlungDurchf�hrenPanel.getKundennummerField().setText(kontoNummer);
		einAuszahlungDurchf�hrenPanel.getBetragField().setText(value);

		try {
			einAuszahlungDurchf�hrenPanel.getAlterKontostandField().setText(
					"" + ControllerUtils.getKonto(kontonummer).getKontostand());
			Kunden.auszahlen(betrag, kontonummer);
			einAuszahlungDurchf�hrenPanel.getNeuerKontostandField().setText(
					"" + ControllerUtils.getKonto(kontonummer).getKontostand());
		} catch (AccountNotFoundException e) {
			JOptionPane.showMessageDialog(einAuszahlungDurchf�hrenPanel, "Konto ist nicht vorhanden!");
			return;
		} catch (LiquidityException e) {
			JOptionPane.showMessageDialog(einAuszahlungDurchf�hrenPanel, "Nicht genug Geld auf dem Konto!");
			return;
		}

		JOptionPane.showMessageDialog(einAuszahlungDurchf�hrenPanel, "Auszahlung wurde durchgef�hrt!");

	}

	private void btEinzahlenActionPerformed(String value, String kontoNummer) {
		double betrag;
		long kontonummer;

		try {
			kontonummer = Long.valueOf(kontoNummer);
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(einAuszahlungDurchf�hrenPanel, "Bitte Zahl als Kontonummer eingeben.");

			return;
		}

		try {
			betrag = Double.valueOf(value);
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(einAuszahlungDurchf�hrenPanel, "Bitte Zahl als Betrag eingeben.");

			return;
		}

		einAuszahlungDurchf�hrenPanel.getKundennummerField().setText(kontoNummer);
		einAuszahlungDurchf�hrenPanel.getBetragField().setText(value);

		try {
			einAuszahlungDurchf�hrenPanel.getAlterKontostandField().setText(
					"" + ControllerUtils.getKonto(kontonummer).getKontostand());
			Kunden.einzahlen(betrag, kontonummer);
			einAuszahlungDurchf�hrenPanel.getNeuerKontostandField().setText(
					"" + ControllerUtils.getKonto(kontonummer).getKontostand());
		} catch (AccountNotFoundException e) {
			JOptionPane.showMessageDialog(einAuszahlungDurchf�hrenPanel, "Konto ist nicht vorhanden!");
			return;
		}

		JOptionPane.showMessageDialog(einAuszahlungDurchf�hrenPanel, "Einzahlung wurde durchgef�hrt!");
	}
}
