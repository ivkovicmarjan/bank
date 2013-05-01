package g18.it1a.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import g18.it1a.exceptions.CustomerNotFoundException;
import g18.it1a.model.Konto;
import g18.it1a.model.Kunde;
import g18.it1a.model.Kunden;
import g18.it1a.view.BankView;
import g18.it1a.view.KontostandsübersichtAnzeigenPanel;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class KontostandsübersichtAnzeigenController {

	private KontostandsübersichtAnzeigenPanel kontostandsübersichtAnzeigenPanel;

	public KontostandsübersichtAnzeigenController(BankView bankView) {
		kontostandsübersichtAnzeigenPanel = new KontostandsübersichtAnzeigenPanel();
		bankView.setContentPane(kontostandsübersichtAnzeigenPanel);
		bankView.setTitle("Bank Anwendung - Kontostandsübersicht anzeigen");
		bankView.setVisible(true);
	}

	public void anzeigenKontostandActionPerformed() {

		kontostandsübersichtAnzeigenPanel.getbtnKontoubersicht().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				btKontobersichtActionPerformed(kontostandsübersichtAnzeigenPanel.getKundennummerField().getText());
			}
		});
	}

	private void btKontobersichtActionPerformed(String nummer) {
		int kundennummer = 0;
		JTable table = kontostandsübersichtAnzeigenPanel.getKontoubersicht();
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.setRowCount(0);

		try {
			kundennummer = Integer.parseInt(nummer);

			Kunde kunde = Kunden.getKunde(kundennummer);

			for (Konto konto : kunde.getKonten().values()) {

				model.addRow(new Object[] { konto.getKontoTyp(), konto.getKontoNummer(), konto.getKontostand() });
			}

		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(kontostandsübersichtAnzeigenPanel,
					"Bitte nur Zahlen eingeben:", "", JOptionPane.WARNING_MESSAGE);
				return;
		} catch (CustomerNotFoundException e) {
			JOptionPane.showMessageDialog(kontostandsübersichtAnzeigenPanel, "Dieser Kunde exisitert nicht!", "",
					JOptionPane.ERROR_MESSAGE);
			return;
		}
	}
}
