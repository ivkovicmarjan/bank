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
				btEinzahlenActionPerformed(einAuszahlungDurchf�hrenDlg.getBetragsField().getText());
			}
		});

		einAuszahlungDurchf�hrenDlg.getAuszahlenButton().addActionListener(new ActionListener() {
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
			String result = JOptionPane.showInputDialog(einAuszahlungDurchf�hrenDlg, "Bitte Zahl als Betrag eingeben.");
			btEinzahlenActionPerformed(result);
		}
	}
}
