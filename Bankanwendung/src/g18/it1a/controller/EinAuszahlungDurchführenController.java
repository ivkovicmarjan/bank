package g18.it1a.controller;

import g18.it1a.exceptions.AccountNotFoundException;
import g18.it1a.exceptions.LiquidityException;
import g18.it1a.model.Kunden;
import g18.it1a.view.BankView;
import g18.it1a.view.EinAuszahlungDurchführenPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class EinAuszahlungDurchführenController {

	private EinAuszahlungDurchführenPanel einAuszahlungDurchführenPanel;

	public EinAuszahlungDurchführenController(BankView bankView) {
		einAuszahlungDurchführenPanel = new EinAuszahlungDurchführenPanel();
		bankView.setContentPane(einAuszahlungDurchführenPanel);
		bankView.setTitle("Bank Anwendung - Ein/Auszahlung durchführen");
		bankView.setVisible(true);
	}

	public void einAuszahlenActionPerformed() {

		einAuszahlungDurchführenPanel.getEinzahlenButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				btEinzahlenActionPerformed(einAuszahlungDurchführenPanel.getBetragField().getText(), einAuszahlungDurchführenPanel
						.getKundennummerField().getText());
			}
		});

		einAuszahlungDurchführenPanel.getAuszahlenButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				btAuszahlenActionPerformed(einAuszahlungDurchführenPanel.getBetragField().getText(), einAuszahlungDurchführenPanel
						.getKundennummerField().getText());
			}
		});
	}

	private void btAuszahlenActionPerformed(String value, String kontoNummer) {
		double betrag;
		long kontonummer;

		try {
			kontonummer = Long.valueOf(kontoNummer);
		} catch (NumberFormatException e) {
			String result = JOptionPane.showInputDialog(einAuszahlungDurchführenPanel, "Bitte Zahl als Kontonummer eingeben.");

			if (result != null) {
				btAuszahlenActionPerformed(value, result);
			}

			return;
		}

		try {
			betrag = Double.valueOf(value);
		} catch (NumberFormatException e) {
			String result = JOptionPane.showInputDialog(einAuszahlungDurchführenPanel, "Bitte Zahl als Betrag eingeben.");

			if (result != null) {
				btAuszahlenActionPerformed(result, kontoNummer);
			}

			return;
		}

		einAuszahlungDurchführenPanel.getKundennummerField().setText(kontoNummer);
		einAuszahlungDurchführenPanel.getBetragField().setText(value);

		try {
			einAuszahlungDurchführenPanel.getAlterKontostandField().setText("" + ControllerUtils.getKonto(kontonummer).getKontostand());
			Kunden.auszahlen(betrag, kontonummer);
			einAuszahlungDurchführenPanel.getNeuerKontostandField().setText("" + ControllerUtils.getKonto(kontonummer).getKontostand());
		} catch (AccountNotFoundException e) {
			JOptionPane.showMessageDialog(einAuszahlungDurchführenPanel, "Konto ist nicht vorhanden!");
			return;
		} catch (LiquidityException e) {
			JOptionPane.showMessageDialog(einAuszahlungDurchführenPanel, "Nicht genug Geld auf dem Konto!");
			return;
		}

		JOptionPane.showMessageDialog(einAuszahlungDurchführenPanel, "Auszahlung wurde durchgeführt!");

	}

	private void btEinzahlenActionPerformed(String value, String kontoNummer) {
		double betrag;
		long kontonummer;

		try {
			kontonummer = Long.valueOf(kontoNummer);
		} catch (NumberFormatException e) {
			String result = JOptionPane.showInputDialog(einAuszahlungDurchführenPanel, "Bitte Zahl als Kontonummer eingeben.");

			if (result != null) {
				btEinzahlenActionPerformed(value, result);
			}

			return;
		}

		try {
			betrag = Double.valueOf(value);
		} catch (NumberFormatException e) {
			String result = JOptionPane.showInputDialog(einAuszahlungDurchführenPanel, "Bitte Zahl als Betrag eingeben.");

			if (result != null) {
				btEinzahlenActionPerformed(result, kontoNummer);
			}
			return;
		}

		einAuszahlungDurchführenPanel.getKundennummerField().setText(kontoNummer);
		einAuszahlungDurchführenPanel.getBetragField().setText(value);

		try {
			einAuszahlungDurchführenPanel.getAlterKontostandField().setText("" + ControllerUtils.getKonto(kontonummer).getKontostand());
			Kunden.einzahlen(betrag, kontonummer);
			einAuszahlungDurchführenPanel.getNeuerKontostandField().setText("" + ControllerUtils.getKonto(kontonummer).getKontostand());
		} catch (AccountNotFoundException e) {
			JOptionPane.showMessageDialog(einAuszahlungDurchführenPanel, "Konto ist nicht vorhanden!");
			return;
		}

		JOptionPane.showMessageDialog(einAuszahlungDurchführenPanel, "Einzahlung wurde durchgeführt!");
	}
}
