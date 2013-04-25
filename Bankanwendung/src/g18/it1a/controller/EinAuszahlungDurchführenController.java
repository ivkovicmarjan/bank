package g18.it1a.controller;

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
				btAuszahlenActionPerformed(einAuszahlungDurchf�hrenDlg.getBetragField().getText());
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
	}
}
