package g18.it1a.controller;

import g18.it1a.model.Kunden;
import g18.it1a.view.EinAuszahlungDurchführenDlg;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.security.auth.login.AccountNotFoundException;
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
		int kontonummer;

		try {
			kontonummer = Integer.valueOf(kontoNummer);
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
			Kunden.einzahlen(betrag, kontonummer);
		} catch (AccountNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		JOptionPane.showMessageDialog(einAuszahlungDurchführenDlg, "Einzahlung wurde durchgeführt!");
	}
}
