package g18.it1a.controller;

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
				btEinzahlenActionPerformed(einAuszahlungDurchführenDlg.getBetragsField().getText());
			}
		});

		einAuszahlungDurchführenDlg.getAuszahlenButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
			}
		});
	}

	private void btEinzahlenActionPerformed(String value) {
		// double betrag;
		// int kundennummer;

		try {
			// betrag = Double.parseDouble(value);
		} catch (NumberFormatException e) {
			String result = JOptionPane.showInputDialog(einAuszahlungDurchführenDlg, "Bitte Zahl als Betrag eingeben.");
			btEinzahlenActionPerformed(result);
		}
	}
}
