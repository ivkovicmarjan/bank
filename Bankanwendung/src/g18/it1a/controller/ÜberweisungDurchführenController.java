package g18.it1a.controller;

import g18.it1a.exceptions.ÜberweisungException;
import g18.it1a.model.Konto;
import g18.it1a.model.Überweisung;
import g18.it1a.view.ÜberweisungDurchführenDlg;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class ÜberweisungDurchführenController {

	private ÜberweisungDurchführenDlg überweisungDurchführenDlg;

	public void überweisungDurchführenActionPerformed() {
		überweisungDurchführenDlg = new ÜberweisungDurchführenDlg();

		überweisungDurchführenDlg.getÜberweisenButton().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Try/Catch, Exceptions und Fehlerbehandlung
				int kontoNummerQuelle = 0;
				boolean error = false;
				try {
					kontoNummerQuelle = Integer.valueOf(überweisungDurchführenDlg.getVonKontoField().getText());
				} catch (NumberFormatException e) {
					error = true;
				}
				Konto quelle = ControllerUtils.getKonto(kontoNummerQuelle);

				int kontoNummerZiel = 0;
				try {
					kontoNummerZiel = Integer.valueOf(überweisungDurchführenDlg.getNachKontoField().getText());
				} catch (NumberFormatException e) {
					e.printStackTrace();
				}
				Konto ziel = ControllerUtils.getKonto(kontoNummerZiel);

				Date datum = überweisungDurchführenDlg.getDateChooser().getDate();

				double betrag = Double.valueOf(überweisungDurchführenDlg.getBetragField().getText());

				if (!error) {
					try {
						new Überweisung(quelle, ziel, betrag, datum).durchführenÜberweisung();
					} catch (ÜberweisungException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});
	}
}