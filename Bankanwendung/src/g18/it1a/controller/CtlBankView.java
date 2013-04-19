package g18.it1a.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import g18.it1a.model.Konto;
import g18.it1a.model.Kontobewegung;


import g18.it1a.model.Kunde;
import g18.it1a.model.Kunden;
import g18.it1a.view.AnlegenKundeDlg;
import g18.it1a.view.BankView;
import g18.it1a.view.EinAuszahlungDurchf�hrenDlg;
import g18.it1a.view.KontobewegungDlg;
import g18.it1a.view.Kontostands�bersichtAnzeigenDlg;

public class CtlBankView {

	private BankView bankView;
	private AnlegenKundeDlg anlegenKundeDlg;
	private EinAuszahlungDurchf�hrenDlg einAuszahlungDurchf�hrenDlg;
	private BankHandler bankHandler;
	private Kontostands�bersichtAnzeigenDlg kontostands�bersichtAnzeigenDlg;
	private KontobewegungDlg kontobewegungDlg;

	public CtlBankView() {
	}

	public void startBankView(final BankHandler bankHandler) {
		this.bankHandler = bankHandler;
		bankView = new BankView();

		bankView.getAnlegenKunde().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				anlegenKundenActionPerformed();
			}
		});

		bankView.getAnlegenKonto().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				final AnlegenKontoController anlegenKontoController = new AnlegenKontoController(bankHandler);
				anlegenKontoController.anlegenKontoActionPerformed();
			}
		});

		bankView.getAnzeigenKontostand().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				anzeigenKontostandActionPerformed();
			}
		});

		bankView.getDurchf�hrenUeberweisungen().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			new �berweisungDurchf�hrenController().�berweisungDurchf�hrenActionPerformed();
			}
		});

		bankView.getDurchfuehrenZahlungen().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				einAuszahlenActionPerformed();
			}
		});

		bankView.getAnzeigenKontobewegung().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				kontobewegungActionPerformed();
			}
		});

		bankView.setVisible(true);
	}

	private void kontobewegungActionPerformed() {
		kontobewegungDlg = new KontobewegungDlg();

		kontobewegungDlg.getAnzeigenButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btKontobewegungActionPerformed(kontobewegungDlg.getKontonummerTextField().getText());
			}
		});
	}

	private void btKontobewegungActionPerformed(String kontoNummerString) {
		int kontoNummer = 0;
		try {
			kontoNummer = Integer.parseInt(kontoNummerString);
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(kontobewegungDlg, "Bitte nur Zahlen eingeben!");
		}

		int kundennummer = ControllerUtils.getKundenNummer(kontoNummer);

		Konto konto = Kunden.getKunde(kundennummer).getKonto(kontoNummer);

		ArrayList<Kontobewegung> kontoBewegungen = konto.getKontobewegung();

		JTable table = kontobewegungDlg.getTable();
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.setRowCount(0);

		for (Kontobewegung kontobewegung : kontoBewegungen) {

			model.addRow(new Object[] { kontobewegung.getDatum().toString(), kontobewegung.getBetrag(), kontobewegung.getBemerkung() });

		}

	}

	private void anzeigenKontostandActionPerformed() {
		kontostands�bersichtAnzeigenDlg = new Kontostands�bersichtAnzeigenDlg();

		kontostands�bersichtAnzeigenDlg.getbtnKontoubersicht().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				btKontobersichtActionPerformed();
			}
		});
	}

	private void anlegenKundenActionPerformed() {
		anlegenKundeDlg = new AnlegenKundeDlg();
		anlegenKundeDlg.getAnlegenButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				btAnlegenKundeActionPerformed(anlegenKundeDlg.getKundenNummerField().getText());
			}
		});
	}

	private void btAnlegenKundeActionPerformed(String value) {
		try {
			String kundenName = anlegenKundeDlg.getKundenNameField().getText();
			int kundenNummer = Integer.parseInt(value);
			Kunde neuerKunde = bankHandler.anlegenKunde(kundenName, kundenNummer);
			JOptionPane.showMessageDialog(anlegenKundeDlg, "Kunde: " + neuerKunde.getName() + " angelegt.");
			clearDlgKundeAnlegen();
		} catch (NumberFormatException e) {
			String result = JOptionPane.showInputDialog(anlegenKundeDlg, "Bitte Zahl als Kundennummer eingeben.");
			btAnlegenKundeActionPerformed(result);
		}
	}

	private void clearDlgKundeAnlegen() {
		anlegenKundeDlg.getKundenNameField().setText("");
		anlegenKundeDlg.getKundenNummerField().setText("");
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

	

	private void einAuszahlenActionPerformed() {
		einAuszahlungDurchf�hrenDlg = new EinAuszahlungDurchf�hrenDlg();

		einAuszahlungDurchf�hrenDlg.getEinzahlenButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				btEinzahlenActionPerformed(einAuszahlungDurchf�hrenDlg.getBetragsField().getText());
			}
		});

		einAuszahlungDurchf�hrenDlg.getAuszahlenButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
			}
		});
	}

	private void btEinzahlenActionPerformed(String value) {
		// double betrag;
		// int kundennummer;

		try {
			// betrag = Double.parseDouble(value);
		} catch (NumberFormatException e) {
			String result = JOptionPane.showInputDialog(einAuszahlungDurchf�hrenDlg, "Bitte Zahl als Betrag eingeben.");
			btEinzahlenActionPerformed(result);
		}
	}

	
}
