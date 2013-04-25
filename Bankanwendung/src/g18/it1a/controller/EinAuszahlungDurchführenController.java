package g18.it1a.controller;

import g18.it1a.exceptions.AccountNotFoundException;
import g18.it1a.exceptions.LiquidityException;
import g18.it1a.model.Kunden;
import g18.it1a.view.EinAuszahlungDurchf�hrenDlg;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class EinAuszahlungDurchf�hrenController {
	
	private EinAuszahlungDurchf�hrenDlg einAuszahlungDurchf�hrenDlg;

	public void einAuszahlenActionPerformed() {
		einAuszahlungDurchf�hrenDlg = new EinAuszahlungDurchf�hrenDlg();

		einAuszahlungDurchf�hrenDlg.getEinzahlenButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				btEinzahlenActionPerformed(einAuszahlungDurchf�hrenDlg.getBetragField().getText(), einAuszahlungDurchf�hrenDlg.getKundennummerField().getText());
			}
		});

		einAuszahlungDurchf�hrenDlg.getAuszahlenButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				btAuszahlenActionPerformed(einAuszahlungDurchf�hrenDlg.getBetragField().getText(), einAuszahlungDurchf�hrenDlg.getKundennummerField().getText());
			}
		});
	}

	private void btAuszahlenActionPerformed(String value, String kontoNummer) {
		double betrag;
		long kontonummer;

		try {
			kontonummer = Long.valueOf(kontoNummer);
		} catch (NumberFormatException e) {
			String result = JOptionPane.showInputDialog(einAuszahlungDurchf�hrenDlg, "Bitte Zahl als Kontonummer eingeben.");
			btAuszahlenActionPerformed(value, result);
			return;
		}
		
		try {
			betrag = Double.valueOf(value);
		} catch (NumberFormatException e) {
			String result = JOptionPane.showInputDialog(einAuszahlungDurchf�hrenDlg, "Bitte Zahl als Betrag eingeben.");
			btAuszahlenActionPerformed(result, kontoNummer);
			return;
		}
		
		einAuszahlungDurchf�hrenDlg.getKundennummerField().setText(kontoNummer);
		einAuszahlungDurchf�hrenDlg.getBetragField().setText(value);

		
		
		try {
			einAuszahlungDurchf�hrenDlg.getAlterKontostandField().setText(""+ControllerUtils.getKonto(kontonummer).getKontostand());
			Kunden.auszahlen(betrag, kontonummer);
			einAuszahlungDurchf�hrenDlg.getNeuerKontostandField().setText(""+ControllerUtils.getKonto(kontonummer).getKontostand());
		} catch (AccountNotFoundException e) {
			JOptionPane.showMessageDialog(einAuszahlungDurchf�hrenDlg, "Konto ist nicht vorhanden!");
			return;
		} catch (LiquidityException e) {
			JOptionPane.showMessageDialog(einAuszahlungDurchf�hrenDlg, "Nicht genug Geld auf dem Konto!");
			return;
		}
		
		JOptionPane.showMessageDialog(einAuszahlungDurchf�hrenDlg, "Auszahlung wurde durchgef�hrt!");
		
	}
	

	private void btEinzahlenActionPerformed(String value, String kontoNummer) {
		double betrag;
		long kontonummer;

		try {
			kontonummer = Long.valueOf(kontoNummer);
		} catch (NumberFormatException e) {
			String result = JOptionPane.showInputDialog(einAuszahlungDurchf�hrenDlg, "Bitte Zahl als Kontonummer eingeben.");
			btEinzahlenActionPerformed(value, result);
			return;
		}
		
		try {
			betrag = Double.valueOf(value);
		} catch (NumberFormatException e) {
			String result = JOptionPane.showInputDialog(einAuszahlungDurchf�hrenDlg, "Bitte Zahl als Betrag eingeben.");
			btEinzahlenActionPerformed(result, kontoNummer);
			return;
		}
		
		einAuszahlungDurchf�hrenDlg.getKundennummerField().setText(kontoNummer);
		einAuszahlungDurchf�hrenDlg.getBetragField().setText(value);

		
		
		try {
			einAuszahlungDurchf�hrenDlg.getAlterKontostandField().setText(""+ControllerUtils.getKonto(kontonummer).getKontostand());
			Kunden.einzahlen(betrag, kontonummer);
			einAuszahlungDurchf�hrenDlg.getNeuerKontostandField().setText(""+ControllerUtils.getKonto(kontonummer).getKontostand());
		} catch (AccountNotFoundException e) {
			JOptionPane.showMessageDialog(einAuszahlungDurchf�hrenDlg, "Konto ist nicht vorhanden!");
			return;
		}
		
		JOptionPane.showMessageDialog(einAuszahlungDurchf�hrenDlg, "Einzahlung wurde durchgef�hrt!");
		
	}
}
