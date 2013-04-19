package g18.it1a.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import g18.it1a.model.Konto;
import g18.it1a.model.Kontobewegung;
import g18.it1a.model.�berweisung;

import g18.it1a.model.KontoTyp;

import g18.it1a.model.Kunde;
import g18.it1a.model.Kunden;
import g18.it1a.view.AnlegenKontoDlg;
import g18.it1a.view.AnlegenKundeDlg;
import g18.it1a.view.BankView;
import g18.it1a.view.EinAuszahlungDurchf�hrenDlg;
import g18.it1a.view.KontobewegungDlg;
import g18.it1a.view.Kontostands�bersichtAnzeigenDlg;
import g18.it1a.view.�berweisungDurchf�hrenDlg;

public class CtlBankView {

	private BankView bankView;
	private AnlegenKundeDlg anlegenKundeDlg;
	private AnlegenKontoDlg anlegenKontoDlg;
	private EinAuszahlungDurchf�hrenDlg einAuszahlungDurchf�hrenDlg;
	private BankHandler bankHandler;
	private �berweisungDurchf�hrenDlg �berweisungDurchf�hrenDlg;
	private Kontostands�bersichtAnzeigenDlg kontostands�bersichtAnzeigenDlg;
	private KontobewegungDlg kontobewegungDlg;

	public CtlBankView() {
	}

	public void startBankView(BankHandler bankHandler) {
		this.bankHandler = bankHandler;
		bankView = new BankView();

		bankView.getAnlegenKunde().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				anlegenKundenActionPerformed();
			}
		});

		bankView.getAnlegenKonto().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				anlegenKontoActionPerformed();
			}
		});

		bankView.getAnzeigenKontostand().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				anzeigenKontostandActionPerformed();
			}
		});

		bankView.getDurchf�hrenUeberweisungen().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				�berweisungDurchf�hrenActionPerformed();
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

	private void btKontobewegungActionPerformed(String kontonummer) {
		int kontoNummer = 0;
		try {
			kontoNummer = Integer.parseInt(kontonummer);
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(kontobewegungDlg, "Bitte nur Zahlen eingeben!");
		}
		
		int kundennummer = Integer.parseInt(kontonummer.substring(0, kontonummer.length()-5));
		
		Konto k = Kunden.getKunde(kundennummer).getKonto(kontoNummer);
		
		ArrayList<Kontobewegung> list = k.getKontobewegung();
		
		JTable table = kontobewegungDlg.getTable();
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.setRowCount(0);
		
			for (Kontobewegung kontobewegung : list) {
				
				model.addRow(new Object [] {kontobewegung.getDatum().toString(), kontobewegung.getBetrag(), kontobewegung.getBemerkung()});
				
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

	private void anlegenKontoActionPerformed() {
		anlegenKontoDlg = new AnlegenKontoDlg();

		anlegenKontoDlg.getAnlegenButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				try {

					btAnlegenKontoActionPerformed(KontoTyp.valueOf(anlegenKontoDlg.getButtonGroup().getSelection().getActionCommand().toUpperCase()),
							anlegenKontoDlg.getKundenNummerFeld().getText());
				} catch (NullPointerException e) {
					JOptionPane.showMessageDialog(anlegenKontoDlg, "bitte w�hlen Sie einen Kontotyp aus!");
				}
			}
		});
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

	private void �berweisungDurchf�hrenActionPerformed() {
		�berweisungDurchf�hrenDlg = new �berweisungDurchf�hrenDlg();

		�berweisungDurchf�hrenDlg.get�berweisenButton().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				//TODO Try/Catch, Exceptions und Fehlerbehandlung
				double betrag = Double.valueOf(�berweisungDurchf�hrenDlg.getBetragField().getText());
				int vonKontoNummer = Integer.valueOf(�berweisungDurchf�hrenDlg.getVonKontoField().getText());
				Date datum = null;
				Konto quelle = getKonto(vonKontoNummer);
				
				int nachKontoNummer = Integer.valueOf(�berweisungDurchf�hrenDlg.getNachKontoField().getText());
				Konto ziel = getKonto(nachKontoNummer);
				
				new �berweisung(quelle, ziel, betrag, datum).durchfuehrenUeberweisung();
			}

		});
	}

	private Konto getKonto(int kontoNummer) {
		int kundenNummer = getKundenNummer(kontoNummer);
		Kunde kunde = Kunden.getKunde(kundenNummer);
		return kunde.getKonto(kontoNummer);
	}

	

	private int getKundenNummer(int vonKonto) {
		String kontoNummer = Integer.toString(vonKonto);
		int kontoNummerLength = kontoNummer.length();
		String kundenNummerStr = kontoNummer.substring(0, kontoNummerLength - 5);
		int kundenNummer = Integer.valueOf(kundenNummerStr);
		return kundenNummer;
	}

	protected void btAnlegenKontoActionPerformed(KontoTyp kontotyp, String kundennummer) {
		double dispoZins = 0;
		int kundenNummer = 0;
		try {

			kundenNummer = Integer.parseInt(kundennummer);

		} catch (NumberFormatException e) {
			String result = JOptionPane.showInputDialog(anlegenKontoDlg, "Bitte Zahl als Kundennummer eingeben:");
			btAnlegenKontoActionPerformed(kontotyp, result);
		}

		if (kontotyp.equals(KontoTyp.Girokonto)) {
			dispoZins = Double.parseDouble(JOptionPane.showInputDialog(anlegenKontoDlg,
					"Bitte geben sie den gew�nschten Dispo ein(Als Kommazahl Bsp.: 150.0):"));
		} else {
			dispoZins = Double.parseDouble(JOptionPane.showInputDialog(anlegenKontoDlg,
					"Bitte geben sie den gew�nschten Zinssatz ein(Als kommazahl Bsp.: 15.0)"));
		}

		try {

			Konto konto = bankHandler.anlegenKonto(kundenNummer, kontotyp, dispoZins);
			JOptionPane.showMessageDialog(anlegenKontoDlg, "Ihr Konto wurde angelegt!\n Ihre Kontonummer lautet: " + konto.getKontoNummer());
			anlegenKontoDlg.dispose();

		} catch (NullPointerException e) {
			JOptionPane.showMessageDialog(anlegenKontoDlg, "Dieser Kunde existiert nicht!");
			anlegenKontoDlg.getKundenNummerFeld().setText("");
		}
	}
}
