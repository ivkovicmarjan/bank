package g18.it1a.controller;

import g18.it1a.exceptions.AccountNotFoundException;
import g18.it1a.exceptions.LiquidityException;
import g18.it1a.model.Konto;
import g18.it1a.model.�berweisung;
import g18.it1a.view.�berweisungDurchf�hrenDlg;

import java.awt.Color;
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
					�berweisungDurchf�hrenDlg.getVonKontoField().setBackground(Color.RED);
					error = true;
					return;
				}
				Konto quelle = null;
				try {
					quelle = ControllerUtils.getKonto(kontoNummerQuelle);
				} catch (AccountNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				int kontoNummerZiel = 0;
				try {
					kontoNummerZiel = Integer.valueOf(�berweisungDurchf�hrenDlg.getNachKontoField().getText());
				} catch (NumberFormatException e) {
					e.printStackTrace();
				}
				Konto ziel = null;
				try {
					ziel = ControllerUtils.getKonto(kontoNummerZiel);
				} catch (AccountNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				Date datum = �berweisungDurchf�hrenDlg.getDateChooser().getDate();

				double betrag = Double.valueOf(�berweisungDurchf�hrenDlg.getBetragField().getText());

				if (!error) {
						try {
							new �berweisung(quelle, ziel, betrag, datum).durchf�hren�berweisung();
						} catch (LiquidityException e) {
							// TODO Auto-generated catch block
						}
				}
			}
		});
	}
}