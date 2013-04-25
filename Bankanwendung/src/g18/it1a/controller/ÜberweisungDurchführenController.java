package g18.it1a.controller;

import g18.it1a.exceptions.AccountNotFoundException;
import g18.it1a.exceptions.LiquidityException;
import g18.it1a.model.Konto;
import g18.it1a.model.Überweisung;
import g18.it1a.view.ÜberweisungDurchführenDlg;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JOptionPane;

public class ÜberweisungDurchführenController {

	private ÜberweisungDurchführenDlg überweisungDurchführenDlg;

	public void überweisungDurchführenActionPerformed() {
		überweisungDurchführenDlg = new ÜberweisungDurchführenDlg();

		überweisungDurchführenDlg.getÜberweisenButton().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				int kontoNummerQuelle = 0;
				try {
					kontoNummerQuelle = Integer.valueOf(überweisungDurchführenDlg.getVonKontoField().getText());
				} catch (NumberFormatException e) {
					überweisungDurchführenDlg.getVonKontoField().setBackground(Color.RED);
					JOptionPane.showMessageDialog(überweisungDurchführenDlg, "Bitte gültige Kontonummer eingeben.", "Ungültige Kontonummer",
							JOptionPane.ERROR_MESSAGE);
					return;
				}
				Konto quelle = null;
				try {
					quelle = ControllerUtils.getKonto(kontoNummerQuelle);
				} catch (AccountNotFoundException e1) {
					überweisungDurchführenDlg.getVonKontoField().setBackground(Color.RED);
					JOptionPane.showMessageDialog(überweisungDurchführenDlg, "Konto mit der Nummer: " + kontoNummerQuelle + " nicht gefunden.",
							"Konto nicht gefunden", JOptionPane.ERROR_MESSAGE);
					return;
				}

				int kontoNummerZiel = 0;
				try {
					kontoNummerZiel = Integer.valueOf(überweisungDurchführenDlg.getNachKontoField().getText());
				} catch (NumberFormatException e) {
					überweisungDurchführenDlg.getNachKontoField().setBackground(Color.RED);
					JOptionPane.showMessageDialog(überweisungDurchführenDlg, "Bitte gültige Kontonummer eingeben.", "Ungültige Kontonummer",
							JOptionPane.ERROR_MESSAGE);
					return;
				}
				Konto ziel = null;
				try {
					ziel = ControllerUtils.getKonto(kontoNummerZiel);
				} catch (AccountNotFoundException e1) {
					JOptionPane.showMessageDialog(überweisungDurchführenDlg, "Konto mit der Nummer: " + kontoNummerZiel + " nicht gefunden.",
							"Konto nicht gefunden", JOptionPane.ERROR_MESSAGE);
					return;
				}

				Date datum = überweisungDurchführenDlg.getDateChooser().getDate();
				if (datum == null) {
					JOptionPane.showMessageDialog(überweisungDurchführenDlg, "Bitte ein gültiges Datum eingeben", "Ungültiges Datum",
							JOptionPane.ERROR_MESSAGE);
					return;
				}

				// Die Uhrzeit auf 00:00:00 setzen, damit überprüft werden kann,
				// ob das Datum in der Vergangenheit liegt.
				Calendar cal = Calendar.getInstance();
				cal.setTime(datum);
				cal.set(Calendar.HOUR, 0);
				cal.set(Calendar.MINUTE, 0);
				cal.set(Calendar.SECOND, 0);
				// Falls das Datum in der Vergangenheit ist, wird die
				// Überweisung nicht ausgeführt.
				if (cal.before(Calendar.getInstance().getTime())) {
					JOptionPane.showMessageDialog(überweisungDurchführenDlg, "Das Datum darf nicht in der Vergangenheit liegen.", "Ungültiges Datum",
							JOptionPane.ERROR_MESSAGE);
					return;
				}

				double betrag = 0.0;
				try {
					betrag = Double.valueOf(überweisungDurchführenDlg.getBetragField().getText());

				} catch (NumberFormatException e) {
					überweisungDurchführenDlg.getBetragField().setBackground(Color.RED);
					JOptionPane.showMessageDialog(überweisungDurchführenDlg, "Bitte gültigen Betrag eingeben.", "Ungültiger Betrag",
							JOptionPane.ERROR_MESSAGE);
					return;
				}

				try {
					new Überweisung(quelle, ziel, betrag, datum).durchführenÜberweisung();
					JOptionPane.showMessageDialog(überweisungDurchführenDlg, " Die Überweisung erfolgreich am " + datum + " durchgeführt.",
							"Überweisung erfolgreich durchgeführt.", JOptionPane.INFORMATION_MESSAGE);

				} catch (LiquidityException e) {
					JOptionPane.showMessageDialog(überweisungDurchführenDlg, "Nicht genügend Geld auf Konto: " + kontoNummerQuelle + " vorhanden.",
							"Ungültiger Betrag", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
	}
}