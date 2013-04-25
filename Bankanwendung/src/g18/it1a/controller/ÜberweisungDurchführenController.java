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
				if (datum == null) {
					JOptionPane.showMessageDialog(�berweisungDurchf�hrenDlg, "Bitte ein g�ltiges Datum eingeben", "Ung�ltiges Datum",
							JOptionPane.ERROR_MESSAGE);
					return;
				}

				// Die Uhrzeit auf 00:00:00 setzen, damit �berpr�ft werden kann,
				// ob das Datum in der Vergangenheit liegt.
				Calendar cal = Calendar.getInstance();
				cal.setTime(datum);
				cal.set(Calendar.HOUR, 0);
				cal.set(Calendar.MINUTE, 0);
				cal.set(Calendar.SECOND, 0);
				// Falls das Datum in der Vergangenheit ist, wird die
				// �berweisung nicht ausgef�hrt.
				if (cal.before(Calendar.getInstance().getTime())) {
					JOptionPane.showMessageDialog(�berweisungDurchf�hrenDlg, "Das Datum darf nicht in der Vergangenheit liegen.", "Ung�ltiges Datum",
							JOptionPane.ERROR_MESSAGE);
					return;
				}

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
					JOptionPane.showMessageDialog(�berweisungDurchf�hrenDlg, " Die �berweisung erfolgreich am " + datum + " durchgef�hrt.",
							"�berweisung erfolgreich durchgef�hrt.", JOptionPane.INFORMATION_MESSAGE);

				} catch (LiquidityException e) {
					JOptionPane.showMessageDialog(�berweisungDurchf�hrenDlg, "Nicht gen�gend Geld auf Konto: " + kontoNummerQuelle + " vorhanden.",
							"Ung�ltiger Betrag", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
	}
}