package g18.it1a.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import g18.it1a.model.Konto;
import g18.it1a.model.Kunde;
import g18.it1a.model.Kunden;
import g18.it1a.view.Kontostands�bersichtAnzeigenDlg;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Kontostands�bersichtAnzeigenController {

	private Kontostands�bersichtAnzeigenDlg kontostands�bersichtAnzeigenDlg;

	public void anzeigenKontostandActionPerformed() {
		kontostands�bersichtAnzeigenDlg = new Kontostands�bersichtAnzeigenDlg();

		kontostands�bersichtAnzeigenDlg.getbtnKontoubersicht().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				btKontobersichtActionPerformed();
			}
		});
	}

	private void btKontobersichtActionPerformed() {
		int kundennummer = 0;
		JTable table = kontostands�bersichtAnzeigenDlg.getKontoubersicht();
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.setRowCount(0);

		try {
			kundennummer = Integer.parseInt(kontostands�bersichtAnzeigenDlg.getKundennummerField().getText());

			Kunde kunde = Kunden.getKunde(kundennummer);
			if (kunde != null) {
				for (Konto konto : kunde.getKonten().values()) {

					model.addRow(new Object[] { konto.getKontoTyp(), konto.getKontoNummer(), konto.getKontostand() });
				}
			}
		} catch (NumberFormatException e) {

		}
	}
}
