package g18.it1a.controller;

import g18.it1a.exceptions.AccountNotFoundException;
import g18.it1a.exceptions.LiquidityException;
import g18.it1a.model.Konto;
import g18.it1a.model.�berweisung;
import g18.it1a.view.�berweisungDurchf�hrenDlg;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.border.Border;
import javax.swing.border.MatteBorder;

public class �berweisungDurchf�hrenController {

	private �berweisungDurchf�hrenDlg �berweisungDurchf�hrenDlg;
	final Border defaultBorder;
	final Border redBorder;

	public �berweisungDurchf�hrenController() {
		�berweisungDurchf�hrenDlg = new �berweisungDurchf�hrenDlg();
		defaultBorder = �berweisungDurchf�hrenDlg.getVonKontoField().getBorder();
		redBorder = new MatteBorder(2, 2, 2, 2, Color.RED);
	}

	public void �berweisungDurchf�hrenActionPerformed() {

		�berweisungDurchf�hrenDlg.get�berweisenButton().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				�berweisungDurchf�hrenDlg.getVonKontoField().setBorder(defaultBorder);
				�berweisungDurchf�hrenDlg.getNachKontoField().setBorder(defaultBorder);
				�berweisungDurchf�hrenDlg.getBetragField().setBorder(defaultBorder);

				int kontoNummerQuelle = 0;
				Konto quelle = null;
				try {
					kontoNummerQuelle = Integer.valueOf(�berweisungDurchf�hrenDlg.getVonKontoField().getText());
					quelle = ControllerUtils.getKonto(kontoNummerQuelle);
				} catch (NumberFormatException e) {
					�berweisungDurchf�hrenDlg.getVonKontoField().setBorder(redBorder);
					JOptionPane.showMessageDialog(�berweisungDurchf�hrenDlg, "Bitte g�ltige Kontonummer eingeben.", "Ung�ltige Kontonummer",
							JOptionPane.ERROR_MESSAGE);
					return;
				} catch (AccountNotFoundException e1) {
					�berweisungDurchf�hrenDlg.getVonKontoField().setBorder(redBorder);
					JOptionPane.showMessageDialog(�berweisungDurchf�hrenDlg, "Konto mit der Nummer: " + kontoNummerQuelle + " nicht gefunden.",
							"Konto nicht gefunden", JOptionPane.ERROR_MESSAGE);
					return;
				}

				int kontoNummerZiel = 0;
				Konto ziel = null;
				try {
					kontoNummerZiel = Integer.valueOf(�berweisungDurchf�hrenDlg.getNachKontoField().getText());
					ziel = ControllerUtils.getKonto(kontoNummerZiel);
				} catch (NumberFormatException e) {
					�berweisungDurchf�hrenDlg.getNachKontoField().setBorder(redBorder);
					JOptionPane.showMessageDialog(�berweisungDurchf�hrenDlg, "Bitte g�ltige Kontonummer eingeben.", "Ung�ltige Kontonummer",
							JOptionPane.ERROR_MESSAGE);
					return;
				} catch (AccountNotFoundException e1) {
					�berweisungDurchf�hrenDlg.getNachKontoField().setBorder(redBorder);
					JOptionPane.showMessageDialog(�berweisungDurchf�hrenDlg, "Konto mit der Nummer: " + kontoNummerZiel + " nicht gefunden.",
							"Konto nicht gefunden", JOptionPane.ERROR_MESSAGE);
					return;
				}

				Date datum = �berweisungDurchf�hrenDlg.getDateChooser().getDate();
				if (datum == null) {
					JOptionPane.showMessageDialog(�berweisungDurchf�hrenDlg, "Bitte ein g�ltiges Datum eingeben", "Ung�ltiges Datum",
							JOptionPane.ERROR_MESSAGE);
					return;
				}

				Calendar cal = Calendar.getInstance();
				cal.setTime(datum);
				cal.set(Calendar.HOUR, 24);
				cal.set(Calendar.MINUTE, 60);
				cal.set(Calendar.SECOND, 60);
				if (Calendar.getInstance().after(cal)) {
					JOptionPane.showMessageDialog(�berweisungDurchf�hrenDlg, "Das Datum darf nicht in der Vergangenheit liegen.", "Ung�ltiges Datum",
							JOptionPane.ERROR_MESSAGE);
					return;
				}

				double betrag = 0.0;
				try {
					betrag = Double.valueOf(�berweisungDurchf�hrenDlg.getBetragField().getText());
					if (betrag <= 0.0)
						throw new Exception();
				} catch (Exception e) {
					�berweisungDurchf�hrenDlg.getBetragField().setBorder(redBorder);
					JOptionPane.showMessageDialog(�berweisungDurchf�hrenDlg, "Bitte g�ltigen Betrag eingeben.", "Ung�ltiger Betrag",
							JOptionPane.ERROR_MESSAGE);
					return;
				}

				try {
					new �berweisung(quelle, ziel, betrag, datum).durchf�hren�berweisung();
					JOptionPane.showMessageDialog(�berweisungDurchf�hrenDlg, " Die �berweisung erfolgreich am " + datum + " durchgef�hrt.",
							"�berweisung erfolgreich durchgef�hrt.", JOptionPane.INFORMATION_MESSAGE);

				} catch (LiquidityException e) {
					JOptionPane.showMessageDialog(�berweisungDurchf�hrenDlg, "Nicht gen�gend Geld auf Konto: " + quelle.getKontoNummer()
							+ " vorhanden.", "Ung�ltiger Betrag", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
	}
}