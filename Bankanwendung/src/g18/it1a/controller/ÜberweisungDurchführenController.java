package g18.it1a.controller;

import g18.it1a.exceptions.AccountNotFoundException;
import g18.it1a.exceptions.LiquidityException;
import g18.it1a.model.Konto;
import g18.it1a.model.�berweisung;
import g18.it1a.view.�berweisungDurchf�hrenDlg;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JOptionPane;

public class �berweisungDurchf�hrenController {

	private �berweisungDurchf�hrenDlg �berweisungDurchf�hrenDlg;

	public void �berweisungDurchf�hrenActionPerformed() {
		�berweisungDurchf�hrenDlg = new �berweisungDurchf�hrenDlg();

		�berweisungDurchf�hrenDlg.get�berweisenButton().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				int kontoNummerQuelle = 0;
				try {
					kontoNummerQuelle = Integer.valueOf(�berweisungDurchf�hrenDlg.getVonKontoField().getText());
				} catch (NumberFormatException e) {
					�berweisungDurchf�hrenDlg.getVonKontoField().setBackground(Color.RED);
					JOptionPane.showMessageDialog(�berweisungDurchf�hrenDlg, "Bitte g�ltige Kontonummer eingeben.", "Ung�ltige Kontonummer",
							JOptionPane.ERROR_MESSAGE);
					return;
				}
				Konto quelle = null;
				try {
					quelle = ControllerUtils.getKonto(kontoNummerQuelle);
				} catch (AccountNotFoundException e1) {
					�berweisungDurchf�hrenDlg.getVonKontoField().setBackground(Color.RED);
					JOptionPane.showMessageDialog(�berweisungDurchf�hrenDlg, "Konto mit der Nummer: " + kontoNummerQuelle + " nicht gefunden.",
							"Konto nicht gefunden", JOptionPane.ERROR_MESSAGE);
					return;
				}

				int kontoNummerZiel = 0;
				try {
					kontoNummerZiel = Integer.valueOf(�berweisungDurchf�hrenDlg.getNachKontoField().getText());
				} catch (NumberFormatException e) {
					�berweisungDurchf�hrenDlg.getNachKontoField().setBackground(Color.RED);
					JOptionPane.showMessageDialog(�berweisungDurchf�hrenDlg, "Bitte g�ltige Kontonummer eingeben.", "Ung�ltige Kontonummer",
							JOptionPane.ERROR_MESSAGE);
					return;
				}
				Konto ziel = null;
				try {
					ziel = ControllerUtils.getKonto(kontoNummerZiel);
				} catch (AccountNotFoundException e1) {
					JOptionPane.showMessageDialog(�berweisungDurchf�hrenDlg, "Konto mit der Nummer: " + kontoNummerZiel + " nicht gefunden.",
							"Konto nicht gefunden", JOptionPane.ERROR_MESSAGE);
					return;
				}

				Date datum = �berweisungDurchf�hrenDlg.getDateChooser().getDate();

				double betrag = 0.0;
				try {
					betrag = Double.valueOf(�berweisungDurchf�hrenDlg.getBetragField().getText());

				} catch (NumberFormatException e) {
					�berweisungDurchf�hrenDlg.getBetragField().setBackground(Color.RED);
					JOptionPane.showMessageDialog(�berweisungDurchf�hrenDlg, "Bitte g�ltigen Betrag eingeben.", "Ung�ltiger Betrag",
							JOptionPane.ERROR_MESSAGE);
					return;
				}

				try {
					new �berweisung(quelle, ziel, betrag, datum).durchf�hren�berweisung();
				} catch (LiquidityException e) {
					JOptionPane.showMessageDialog(�berweisungDurchf�hrenDlg, "Nicht gen�gend Geld auf Konto: " + kontoNummerQuelle + " vorhanden.",
							"Ung�ltiger Betrag", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
	}
}