package g18.it1a.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import g18.it1a.model.Konto;
import g18.it1a.model.Kunde;
import g18.it1a.model.Kunden;
import g18.it1a.view.KontostandsübersichtAnzeigenDlg;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class KontostandsübersichtAnzeigenController {

	private KontostandsübersichtAnzeigenDlg kontostandsübersichtAnzeigenDlg;

	public void anzeigenKontostandActionPerformed() {
		kontostandsübersichtAnzeigenDlg = new KontostandsübersichtAnzeigenDlg();

		kontostandsübersichtAnzeigenDlg.getbtnKontoubersicht().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				btKontobersichtActionPerformed(kontostandsübersichtAnzeigenDlg.getKundennummerField().getText());
			}
		});
	}

	private void btKontobersichtActionPerformed(String nummer) {
		int kundennummer = 0;
		JTable table = kontostandsübersichtAnzeigenDlg.getKontoubersicht();
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.setRowCount(0);

		try {
			kundennummer = Integer.parseInt(nummer);

			Kunde kunde = Kunden.getKunde(kundennummer);
			if (kunde != null) {
				for (Konto konto : kunde.getKonten().values()) {

					model.addRow(new Object[] { konto.getKontoTyp(), konto.getKontoNummer(), konto.getKontostand() });
				}
			} else {
				JOptionPane.showMessageDialog(kontostandsübersichtAnzeigenDlg, "Dieser Kunde exisitert nicht!", "", JOptionPane.ERROR_MESSAGE);
				return;
			}
		} catch (NumberFormatException e) {
			String result = JOptionPane.showInputDialog(kontostandsübersichtAnzeigenDlg, "Bitte nur Zahlen eingeben:", "", JOptionPane.WARNING_MESSAGE);
			btKontobersichtActionPerformed(result);
			return;
			
		}
	}
}
