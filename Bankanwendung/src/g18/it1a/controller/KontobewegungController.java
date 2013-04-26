package g18.it1a.controller;

import g18.it1a.exceptions.AccountNotFoundException;
import g18.it1a.model.Konto;
import g18.it1a.model.Kontobewegung;
import g18.it1a.model.Kunde;
import g18.it1a.view.KontobewegungDlg;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class KontobewegungController {

	private KontobewegungDlg kontobewegungDlg;

	public void kontobewegungActionPerformed() {
		kontobewegungDlg = new KontobewegungDlg();

		kontobewegungDlg.getAnzeigenButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btKontobewegungActionPerformed(kontobewegungDlg.getKontonummerTextField().getText());
			}
		});
	}

	private void btKontobewegungActionPerformed(String kontoNummerString) {
		Konto konto = null;
		ArrayList<Kontobewegung> kontoBewegungen = null;
		int kontoNummer = 0;
		try {
			kontoNummer = Integer.parseInt(kontoNummerString);
		} catch (NumberFormatException e) {
			String result = JOptionPane.showInputDialog(kontobewegungDlg, "Bitte Zahl als Kontonummer eingeben!");
			if(result == null) {
				return;
			}
			btKontobewegungActionPerformed(result);
			return;
			
		}

		Kunde kunde = null;
		
		try {
			kunde = ControllerUtils.getKundeVonKonto(kontoNummer);
			konto = kunde.getKonto(kontoNummer);
			kontoBewegungen = konto.getKontobewegung();

			JTable table = kontobewegungDlg.getTable();
			DefaultTableModel model = (DefaultTableModel) table.getModel();
			model.setRowCount(0);

			for (Kontobewegung kontobewegung : kontoBewegungen) {

				model.addRow(new Object[] { kontobewegung.getDatum().toString(), kontobewegung.getBetrag(), kontobewegung.getBemerkung() });

			}
		} catch (AccountNotFoundException e) {
			JOptionPane.showMessageDialog(kontobewegungDlg, "Konto ist nicht vorhanden!", "", JOptionPane.INFORMATION_MESSAGE);
			return;
		}
	}
}
