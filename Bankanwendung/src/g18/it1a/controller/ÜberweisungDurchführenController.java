package g18.it1a.controller;

import g18.it1a.exceptions.AccountNotFoundException;
import g18.it1a.exceptions.LiquidityException;
import g18.it1a.model.Konto;
import g18.it1a.model.Überweisung;
import g18.it1a.view.ÜberweisungDurchführenDlg;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
					return;
				}

				int kontoNummerZiel = 0;
				try {
					kontoNummerZiel = Integer.valueOf(überweisungDurchführenDlg.getNachKontoField().getText());
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

				Date datum = überweisungDurchführenDlg.getDateChooser().getDate();

				double betrag = Double.valueOf(überweisungDurchführenDlg.getBetragField().getText());

				try {
					new Überweisung(quelle, ziel, betrag, datum).durchführenÜberweisung();
				} catch (LiquidityException e) {
					// TODO Auto-generated catch block
				}
			}
		});
	}
}