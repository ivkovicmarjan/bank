package g18.it1a.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import g18.it1a.model.Konto;
import g18.it1a.model.Kunde;
import g18.it1a.model.Kunden;
import g18.it1a.view.BankView;
import g18.it1a.view.Kontostands�bersichtAnzeigenPanel;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Kontostands�bersichtAnzeigenController {

	private Kontostands�bersichtAnzeigenPanel kontostands�bersichtAnzeigenPanel;

	public Kontostands�bersichtAnzeigenController(BankView bankView) {
		kontostands�bersichtAnzeigenPanel = new Kontostands�bersichtAnzeigenPanel();
		bankView.setContentPane(kontostands�bersichtAnzeigenPanel);
		bankView.setTitle("Bank Anwendung - Kontostands�bersicht anzeigen");
		bankView.setVisible(true);
	}

	public void anzeigenKontostandActionPerformed() {

		kontostands�bersichtAnzeigenPanel.getbtnKontoubersicht().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				btKontobersichtActionPerformed(kontostands�bersichtAnzeigenPanel.getKundennummerField().getText());
			}
		});
	}

	private void btKontobersichtActionPerformed(String nummer) {
		int kundennummer = 0;
		JTable table = kontostands�bersichtAnzeigenPanel.getKontoubersicht();
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
				JOptionPane.showMessageDialog(kontostands�bersichtAnzeigenPanel, "Dieser Kunde exisitert nicht!", "", JOptionPane.ERROR_MESSAGE);
				return;
			}
		} catch (NumberFormatException e) {
			String result = JOptionPane.showInputDialog(kontostands�bersichtAnzeigenPanel, "Bitte nur Zahlen eingeben:", "",
					JOptionPane.WARNING_MESSAGE);
			if (result == null)
				return;
			btKontobersichtActionPerformed(result);
			return;

		}
	}
}
