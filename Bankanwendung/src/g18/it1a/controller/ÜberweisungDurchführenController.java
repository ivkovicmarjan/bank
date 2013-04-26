package g18.it1a.controller;

import g18.it1a.exceptions.AccountNotFoundException;
import g18.it1a.exceptions.LiquidityException;
import g18.it1a.model.Konto;
import g18.it1a.model.Kunde;
import g18.it1a.model.�berweisung;
import g18.it1a.view.BankView;
import g18.it1a.view.�berweisungDurchf�hrenPanel;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.border.Border;
import javax.swing.border.MatteBorder;

public class �berweisungDurchf�hrenController {

	private �berweisungDurchf�hrenPanel �berweisungDurchf�hrenPanel;
	private final Border defaultBorder;
	private final Border redBorder;

	public �berweisungDurchf�hrenController(BankView bankView) {
		�berweisungDurchf�hrenPanel = new �berweisungDurchf�hrenPanel();
		bankView.setContentPane(�berweisungDurchf�hrenPanel);
		bankView.setVisible(true);
		defaultBorder = �berweisungDurchf�hrenPanel.getSourceField().getBorder();
		redBorder = new MatteBorder(2, 2, 2, 2, Color.RED);
	}

	public void �berweisungDurchf�hrenActionPerformed() {

		�berweisungDurchf�hrenPanel.get�berweisenButton().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				�berweisungDurchf�hrenPanel.getSourceField().setBorder(defaultBorder);
				�berweisungDurchf�hrenPanel.getDestinationField().setBorder(defaultBorder);
				�berweisungDurchf�hrenPanel.getBetragField().setBorder(defaultBorder);

				long kontoNummerQuelle = 0;
				Konto quelle = null;
				try {
					kontoNummerQuelle = Long.valueOf(�berweisungDurchf�hrenPanel.getSourceField().getText());
					Kunde kunde = ControllerUtils.getKundeVonKonto(kontoNummerQuelle);
					quelle = kunde.getKonto(kontoNummerQuelle);
					�berweisungDurchf�hrenPanel.getSourceNameField().setText(kunde.getName());

				} catch (NumberFormatException e) {
					�berweisungDurchf�hrenPanel.getSourceNameField().setText("");
					�berweisungDurchf�hrenPanel.getSourceField().setBorder(redBorder);
					JOptionPane.showMessageDialog(�berweisungDurchf�hrenPanel, "Bitte g�ltige Kontonummer eingeben.", "Ung�ltige Kontonummer",
							JOptionPane.ERROR_MESSAGE);
					return;
				} catch (AccountNotFoundException e1) {
					�berweisungDurchf�hrenPanel.getSourceNameField().setText("");
					�berweisungDurchf�hrenPanel.getSourceField().setBorder(redBorder);
					JOptionPane.showMessageDialog(�berweisungDurchf�hrenPanel, "Konto mit der Nummer: " + kontoNummerQuelle + " nicht gefunden.",
							"Konto nicht gefunden", JOptionPane.ERROR_MESSAGE);
					return;
				}

				long kontoNummerZiel = 0;
				Konto ziel = null;
				try {
					kontoNummerZiel = Long.valueOf(�berweisungDurchf�hrenPanel.getDestinationField().getText());
					Kunde kunde = ControllerUtils.getKundeVonKonto(kontoNummerZiel);
					ziel = kunde.getKonto(kontoNummerZiel);
					�berweisungDurchf�hrenPanel.getDestinationNameField().setText(kunde.getName());
				} catch (NumberFormatException e) {
					�berweisungDurchf�hrenPanel.getDestinationField().setBorder(redBorder);
					JOptionPane.showMessageDialog(�berweisungDurchf�hrenPanel, "Bitte g�ltige Kontonummer eingeben.", "Ung�ltige Kontonummer",
							JOptionPane.ERROR_MESSAGE);
					return;
				} catch (AccountNotFoundException e1) {
					�berweisungDurchf�hrenPanel.getDestinationField().setBorder(redBorder);
					JOptionPane.showMessageDialog(�berweisungDurchf�hrenPanel, "Konto mit der Nummer: " + kontoNummerZiel + " nicht gefunden.",
							"Konto nicht gefunden", JOptionPane.ERROR_MESSAGE);
					return;
				}

				Date datum = �berweisungDurchf�hrenPanel.getDateChooser().getDate();
				if (datum == null) {
					JOptionPane.showMessageDialog(�berweisungDurchf�hrenPanel, "Bitte ein g�ltiges Datum eingeben", "Ung�ltiges Datum",
							JOptionPane.ERROR_MESSAGE);
					return;
				}

				Calendar cal = Calendar.getInstance();
				cal.setTime(datum);
				cal.set(Calendar.HOUR, 24);
				cal.set(Calendar.MINUTE, 60);
				cal.set(Calendar.SECOND, 60);
				if (Calendar.getInstance().after(cal)) {
					JOptionPane.showMessageDialog(�berweisungDurchf�hrenPanel, "Das Datum darf nicht in der Vergangenheit liegen.",
							"Ung�ltiges Datum", JOptionPane.ERROR_MESSAGE);
					return;
				}

				double betrag = 0.0;
				try {
					betrag = Double.valueOf(�berweisungDurchf�hrenPanel.getBetragField().getText());
					if (betrag <= 0.0)
						throw new Exception();
				} catch (Exception e) {
					�berweisungDurchf�hrenPanel.getBetragField().setBorder(redBorder);
					JOptionPane.showMessageDialog(�berweisungDurchf�hrenPanel, "Bitte g�ltigen Betrag eingeben.", "Ung�ltiger Betrag",
							JOptionPane.ERROR_MESSAGE);
					return;
				}

				try {
					new �berweisung(quelle, ziel, betrag, datum).durchf�hren�berweisung();
					JOptionPane.showMessageDialog(�berweisungDurchf�hrenPanel, " Die �berweisung erfolgreich am " + datum + " durchgef�hrt.",
							"�berweisung erfolgreich durchgef�hrt.", JOptionPane.INFORMATION_MESSAGE);

				} catch (LiquidityException e) {
					JOptionPane.showMessageDialog(�berweisungDurchf�hrenPanel, "Nicht gen�gend Geld auf Konto: " + quelle.getKontoNummer()
							+ " vorhanden.", "Ung�ltiger Betrag", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
	}
}