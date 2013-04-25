package g18.it1a.controller;

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
				double betrag = Double.valueOf(überweisungDurchführenDlg.getBetragField().getText());
				int vonKontoNummer = Integer.valueOf(überweisungDurchführenDlg.getVonKontoField().getText());
				Date datum = überweisungDurchführenDlg.getDateChooser().getDate();
				Konto quelle = ControllerUtils.getKonto(vonKontoNummer);

				int nachKontoNummer = Integer.valueOf(überweisungDurchführenDlg.getNachKontoField().getText());
				Konto ziel = ControllerUtils.getKonto(nachKontoNummer);

				new Überweisung(quelle, ziel, betrag, datum).durchfuehrenUeberweisung();
			}
		});
	}
}