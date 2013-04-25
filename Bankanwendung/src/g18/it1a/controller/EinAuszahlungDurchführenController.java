package g18.it1a.controller;

import g18.it1a.exceptions.AccountNotFoundException;
import g18.it1a.model.Kunden;
import g18.it1a.view.EinAuszahlungDurchführenDlg;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class EinAuszahlungDurchführenController {
	
	private EinAuszahlungDurchführenDlg einAuszahlungDurchführenDlg;

	public void einAuszahlenActionPerformed() {
		einAuszahlungDurchführenDlg = new EinAuszahlungDurchführenDlg();

		einAuszahlungDurchführenDlg.getEinzahlenButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				btEinzahlenActionPerformed(einAuszahlungDurchführenDlg.getBetragField().getText(), einAuszahlungDurchführenDlg.getKundennummerField().getText());
			}
		});

		einAuszahlungDurchführenDlg.getAuszahlenButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				btAuszahlenActionPerformed(einAuszahlungDurchführenDlg.getBetragField().getText());
			}
		});
	}

	private void btAuszahlenActionPerformed(String text) {
		
	}

	private void btEinzahlenActionPerformed(String value, String kontoNummer) {
		double betrag;
		long kontonummer;

		try {
			kontonummer = Long.valueOf(kontoNummer);
		} catch (NumberFormatException e) {
			String result = JOptionPane.showInputDialog(einAuszahlungDurchführenDlg, "Bitte Zahl als Kontonummer eingeben.");
			btEinzahlenActionPerformed(value, result);
			return;
		}
		
		try {
			betrag = Double.valueOf(value);
		} catch (NumberFormatException e) {
			String result = JOptionPane.showInputDialog(einAuszahlungDurchführenDlg, "Bitte Zahl als Betrag eingeben.");
			btEinzahlenActionPerformed(result, kontoNummer);
			return;
		}
		
		einAuszahlungDurchführenDlg.getKundennummerField().setText(kontoNummer);
		einAuszahlungDurchführenDlg.getBetragField().setText(value);

		
		
		try {
			einAuszahlungDurchführenDlg.getAlterKontostandField().setText(""+ControllerUtils.getKonto(kontonummer).getKontostand());
			Kunden.einzahlen(betrag, kontonummer);
			einAuszahlungDurchführenDlg.getNeuerKontostandField().setText(""+ControllerUtils.getKonto(kontonummer).getKontostand());
		} catch (AccountNotFoundException e) {
			JOptionPane.showMessageDialog(einAuszahlungDurchführenDlg, "Konto ist nicht vorhanden!");
			return;
		}
		
		JOptionPane.showMessageDialog(einAuszahlungDurchführenDlg, "Einzahlung wurde durchgeführt!");
		
	}
}
