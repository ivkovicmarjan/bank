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
import javax.swing.border.Border;
import javax.swing.border.MatteBorder;

public class ÜberweisungDurchführenController {

	private ÜberweisungDurchführenDlg überweisungDurchführenDlg;
	final Border defaultBorder;
	final Border redBorder;

	public ÜberweisungDurchführenController() {
		überweisungDurchführenDlg = new ÜberweisungDurchführenDlg();
		defaultBorder = überweisungDurchführenDlg.getVonKontoField().getBorder();
		redBorder = new MatteBorder(2, 2, 2, 2, Color.RED);
	}

	public void überweisungDurchführenActionPerformed() {

		überweisungDurchführenDlg.getÜberweisenButton().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				überweisungDurchführenDlg.getVonKontoField().setBorder(defaultBorder);
				überweisungDurchführenDlg.getNachKontoField().setBorder(defaultBorder);
				überweisungDurchführenDlg.getBetragField().setBorder(defaultBorder);

				Konto quelle = checkQuelle();
				Konto ziel = checkZiel();
				Date datum = checkDatum();

				double betrag = checkBetrag();

				try {
					new Überweisung(quelle, ziel, betrag, datum).durchführenÜberweisung();
					JOptionPane.showMessageDialog(überweisungDurchführenDlg, " Die Überweisung erfolgreich am " + datum + " durchgeführt.",
							"Überweisung erfolgreich durchgeführt.", JOptionPane.INFORMATION_MESSAGE);

				} catch (LiquidityException e) {
					JOptionPane.showMessageDialog(überweisungDurchführenDlg, "Nicht genügend Geld auf Konto: " + quelle.getKontoNummer()
							+ " vorhanden.", "Ungültiger Betrag", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
	}

	private Konto checkQuelle() {
		int kontoNummerQuelle = 0;
		Konto quelle = null;
		try {
			kontoNummerQuelle = Integer.valueOf(überweisungDurchführenDlg.getVonKontoField().getText());
			quelle = ControllerUtils.getKonto(kontoNummerQuelle);
		} catch (NumberFormatException e) {
			überweisungDurchführenDlg.getVonKontoField().setBorder(redBorder);

			JOptionPane.showMessageDialog(überweisungDurchführenDlg, "Bitte gültige Kontonummer eingeben.", "Ungültige Kontonummer",
					JOptionPane.ERROR_MESSAGE);
		} catch (AccountNotFoundException e1) {
			überweisungDurchführenDlg.getVonKontoField().setBorder(redBorder);
			JOptionPane.showMessageDialog(überweisungDurchführenDlg, "Konto mit der Nummer: " + kontoNummerQuelle + " nicht gefunden.",
					"Konto nicht gefunden", JOptionPane.ERROR_MESSAGE);
		}
		return quelle;

	}

	private Konto checkZiel() {
		int kontoNummerZiel = 0;
		Konto ziel = null;
		try {
			kontoNummerZiel = Integer.valueOf(überweisungDurchführenDlg.getNachKontoField().getText());
			ziel = ControllerUtils.getKonto(kontoNummerZiel);
		} catch (NumberFormatException e) {
			überweisungDurchführenDlg.getNachKontoField().setBorder(redBorder);
			JOptionPane.showMessageDialog(überweisungDurchführenDlg, "Bitte gültige Kontonummer eingeben.", "Ungültige Kontonummer",
					JOptionPane.ERROR_MESSAGE);
		} catch (AccountNotFoundException e1) {
			überweisungDurchführenDlg.getNachKontoField().setBorder(redBorder);
			JOptionPane.showMessageDialog(überweisungDurchführenDlg, "Konto mit der Nummer: " + kontoNummerZiel + " nicht gefunden.",
					"Konto nicht gefunden", JOptionPane.ERROR_MESSAGE);
		}
		return ziel;
	}

	private Date checkDatum() {
		Date datum = überweisungDurchführenDlg.getDateChooser().getDate();
		if (datum == null) {
			JOptionPane.showMessageDialog(überweisungDurchführenDlg, "Bitte ein gültiges Datum eingeben", "Ungültiges Datum",
					JOptionPane.ERROR_MESSAGE);
			return datum;
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
		}
		return datum;
	}

	private double checkBetrag() {
		double betrag = 0.0;
		try {
			betrag = Double.valueOf(überweisungDurchführenDlg.getBetragField().getText());

		} catch (NumberFormatException e) {
			überweisungDurchführenDlg.getBetragField().setBorder(redBorder);
			JOptionPane.showMessageDialog(überweisungDurchführenDlg, "Bitte gültigen Betrag eingeben.", "Ungültiger Betrag",
					JOptionPane.ERROR_MESSAGE);
		}
		return betrag;
	}
}