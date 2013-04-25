package g18.it1a.controller;

import g18.it1a.exceptions.�berweisungException;
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
				int kontoNummerQuelle = 0;
				boolean error = false;
				try {
					kontoNummerQuelle = Integer.valueOf(�berweisungDurchf�hrenDlg.getVonKontoField().getText());
				} catch (NumberFormatException e) {
					error = true;
				}
				Konto quelle = ControllerUtils.getKonto(kontoNummerQuelle);

				int kontoNummerZiel = 0;
				try {
					kontoNummerZiel = Integer.valueOf(�berweisungDurchf�hrenDlg.getNachKontoField().getText());
				} catch (NumberFormatException e) {
					e.printStackTrace();
				}
				Konto ziel = ControllerUtils.getKonto(kontoNummerZiel);

				Date datum = �berweisungDurchf�hrenDlg.getDateChooser().getDate();

				double betrag = Double.valueOf(�berweisungDurchf�hrenDlg.getBetragField().getText());

				if (!error) {
					try {
						new �berweisung(quelle, ziel, betrag, datum).durchf�hren�berweisung();
					} catch (�berweisungException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});
	}
}