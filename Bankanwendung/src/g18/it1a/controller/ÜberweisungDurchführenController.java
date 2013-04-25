package g18.it1a.controller;

import g18.it1a.model.Konto;
import g18.it1a.model.�berweisung;
import g18.it1a.view.�berweisungDurchf�hrenDlg;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class �berweisungDurchf�hrenController {
	
	private �berweisungDurchf�hrenDlg �berweisungDurchf�hrenDlg;

	public void �berweisungDurchf�hrenActionPerformed() {
		�berweisungDurchf�hrenDlg = new �berweisungDurchf�hrenDlg();

		�berweisungDurchf�hrenDlg.get�berweisenButton().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Try/Catch, Exceptions und Fehlerbehandlung
				double betrag = Double.valueOf(�berweisungDurchf�hrenDlg.getBetragField().getText());
				int vonKontoNummer = Integer.valueOf(�berweisungDurchf�hrenDlg.getVonKontoField().getText());
				Date datum = �berweisungDurchf�hrenDlg.getDateChooser().getDate();
				Konto quelle = ControllerUtils.getKonto(vonKontoNummer);

				int nachKontoNummer = Integer.valueOf(�berweisungDurchf�hrenDlg.getNachKontoField().getText());
				Konto ziel = ControllerUtils.getKonto(nachKontoNummer);

				new �berweisung(quelle, ziel, betrag, datum).durchfuehrenUeberweisung();
			}
		});
	}
}