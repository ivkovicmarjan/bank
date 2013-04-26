package g18.it1a.controller;

import g18.it1a.exceptions.AccountNotFoundException;
import g18.it1a.exceptions.LiquidityException;
import g18.it1a.model.Konto;
import g18.it1a.model.Kunde;
import g18.it1a.model.Überweisung;
import g18.it1a.view.BankView;
import g18.it1a.view.ÜberweisungDurchführenPanel;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.border.Border;
import javax.swing.border.MatteBorder;

public class ÜberweisungDurchführenController {

	private ÜberweisungDurchführenPanel überweisungDurchführenPanel;
	private final Border defaultBorder;
	private final Border redBorder;

	public ÜberweisungDurchführenController(BankView bankView) {
		überweisungDurchführenPanel = new ÜberweisungDurchführenPanel();
		bankView.setContentPane(überweisungDurchführenPanel);
		bankView.setVisible(true);
		defaultBorder = überweisungDurchführenPanel.getSourceField().getBorder();
		redBorder = new MatteBorder(2, 2, 2, 2, Color.RED);
	}

	public void überweisungDurchführenActionPerformed() {

		überweisungDurchführenPanel.getÜberweisenButton().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				überweisungDurchführenPanel.getSourceField().setBorder(defaultBorder);
				überweisungDurchführenPanel.getDestinationField().setBorder(defaultBorder);
				überweisungDurchführenPanel.getBetragField().setBorder(defaultBorder);

				long kontoNummerQuelle = 0;
				Konto quelle = null;
				try {
					kontoNummerQuelle = Long.valueOf(überweisungDurchführenPanel.getSourceField().getText());
					Kunde kunde = ControllerUtils.getKundeVonKonto(kontoNummerQuelle);
					quelle = kunde.getKonto(kontoNummerQuelle);
					überweisungDurchführenPanel.getSourceNameField().setText(kunde.getName());

				} catch (NumberFormatException e) {
					überweisungDurchführenPanel.getSourceNameField().setText("");
					überweisungDurchführenPanel.getSourceField().setBorder(redBorder);
					JOptionPane.showMessageDialog(überweisungDurchführenPanel, "Bitte gültige Kontonummer eingeben.", "Ungültige Kontonummer",
							JOptionPane.ERROR_MESSAGE);
					return;
				} catch (AccountNotFoundException e1) {
					überweisungDurchführenPanel.getSourceNameField().setText("");
					überweisungDurchführenPanel.getSourceField().setBorder(redBorder);
					JOptionPane.showMessageDialog(überweisungDurchführenPanel, "Konto mit der Nummer: " + kontoNummerQuelle + " nicht gefunden.",
							"Konto nicht gefunden", JOptionPane.ERROR_MESSAGE);
					return;
				}

				long kontoNummerZiel = 0;
				Konto ziel = null;
				try {
					kontoNummerZiel = Long.valueOf(überweisungDurchführenPanel.getDestinationField().getText());
					Kunde kunde = ControllerUtils.getKundeVonKonto(kontoNummerZiel);
					ziel = kunde.getKonto(kontoNummerZiel);
					überweisungDurchführenPanel.getDestinationNameField().setText(kunde.getName());
				} catch (NumberFormatException e) {
					überweisungDurchführenPanel.getDestinationField().setBorder(redBorder);
					JOptionPane.showMessageDialog(überweisungDurchführenPanel, "Bitte gültige Kontonummer eingeben.", "Ungültige Kontonummer",
							JOptionPane.ERROR_MESSAGE);
					return;
				} catch (AccountNotFoundException e1) {
					überweisungDurchführenPanel.getDestinationField().setBorder(redBorder);
					JOptionPane.showMessageDialog(überweisungDurchführenPanel, "Konto mit der Nummer: " + kontoNummerZiel + " nicht gefunden.",
							"Konto nicht gefunden", JOptionPane.ERROR_MESSAGE);
					return;
				}

				Date datum = überweisungDurchführenPanel.getDateChooser().getDate();
				if (datum == null) {
					JOptionPane.showMessageDialog(überweisungDurchführenPanel, "Bitte ein gültiges Datum eingeben", "Ungültiges Datum",
							JOptionPane.ERROR_MESSAGE);
					return;
				}

				Calendar cal = Calendar.getInstance();
				cal.setTime(datum);
				cal.set(Calendar.HOUR, 24);
				cal.set(Calendar.MINUTE, 60);
				cal.set(Calendar.SECOND, 60);
				if (Calendar.getInstance().after(cal)) {
					JOptionPane.showMessageDialog(überweisungDurchführenPanel, "Das Datum darf nicht in der Vergangenheit liegen.",
							"Ungültiges Datum", JOptionPane.ERROR_MESSAGE);
					return;
				}

				double betrag = 0.0;
				try {
					betrag = Double.valueOf(überweisungDurchführenPanel.getBetragField().getText());
					if (betrag <= 0.0)
						throw new Exception();
				} catch (Exception e) {
					überweisungDurchführenPanel.getBetragField().setBorder(redBorder);
					JOptionPane.showMessageDialog(überweisungDurchführenPanel, "Bitte gültigen Betrag eingeben.", "Ungültiger Betrag",
							JOptionPane.ERROR_MESSAGE);
					return;
				}

				try {
					new Überweisung(quelle, ziel, betrag, datum).durchführenÜberweisung();
					JOptionPane.showMessageDialog(überweisungDurchführenPanel, " Die Überweisung erfolgreich am " + datum + " durchgeführt.",
							"Überweisung erfolgreich durchgeführt.", JOptionPane.INFORMATION_MESSAGE);

				} catch (LiquidityException e) {
					JOptionPane.showMessageDialog(überweisungDurchführenPanel, "Nicht genügend Geld auf Konto: " + quelle.getKontoNummer()
							+ " vorhanden.", "Ungültiger Betrag", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
	}
}