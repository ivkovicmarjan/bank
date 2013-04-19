package g18.it1a.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import g18.it1a.model.Konto;
import g18.it1a.model.Konto.KontoTyp;
import g18.it1a.model.Kunde;
import g18.it1a.model.Kunden;
import g18.it1a.view.AnlegenKontoDlg;
import g18.it1a.view.AnlegenKundeDlg;
import g18.it1a.view.BankView;
import g18.it1a.view.EinAuszahlungDurchführenDlg;
import g18.it1a.view.KontobewegungDlg;
import g18.it1a.view.KontostandsübersichtAnzeigenDlg;
import g18.it1a.view.ÜberweisungDurchführenDlg;

public class CtlBankView {

	private BankView bankView;
	private AnlegenKundeDlg anlegenKundeDlg;
	private AnlegenKontoDlg anlegenKontoDlg;
	private EinAuszahlungDurchführenDlg einAuszahlungDurchführenDlg;
	private BankHandler bankHandler;
	private ÜberweisungDurchführenDlg überweisungDurchführenDlg;
	private KontostandsübersichtAnzeigenDlg kontostandsübersichtAnzeigenDlg;
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

		bankView.getDurchführenUeberweisungen().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				überweisungDurchführenActionPerformed();
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
				btKontobewegungActionPerformed();
			}
		});
	}

	protected void btKontobewegungActionPerformed() {
		
	}

	private void anzeigenKontostandActionPerformed() {
		kontostandsübersichtAnzeigenDlg = new KontostandsübersichtAnzeigenDlg();

		kontostandsübersichtAnzeigenDlg.getbtnKontoubersicht().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				btKontobersichtActionPerformed();
			}
		});

		bankView.setVisible(true);
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

		try {
			kundennummer = Integer.parseInt(kontostandsübersichtAnzeigenDlg.getKundennummerField().getText());

			JTable table = kontostandsübersichtAnzeigenDlg.getKontoubersicht();
			DefaultTableModel model = (DefaultTableModel) table.getModel();
			model.addRow(new Object[] { "Kontoart", kundennummer, "Kontostand" });
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
					JOptionPane.showMessageDialog(anlegenKontoDlg, "bitte wählen Sie einen Kontotyp aus!");
				}
			}
		});
	}

	private void einAuszahlenActionPerformed() {
		einAuszahlungDurchführenDlg = new EinAuszahlungDurchführenDlg();

		einAuszahlungDurchführenDlg.getEinzahlenButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				btEinzahlenActionPerformed(einAuszahlungDurchführenDlg.getBetragsField().getText());
			}
		});

		einAuszahlungDurchführenDlg.getAuszahlenButton().addActionListener(new ActionListener() {
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
			String result = JOptionPane.showInputDialog(einAuszahlungDurchführenDlg, "Bitte Zahl als Betrag eingeben.");
			btEinzahlenActionPerformed(result);
		}
	}

	private void überweisungDurchführenActionPerformed() {
		überweisungDurchführenDlg = new ÜberweisungDurchführenDlg();

		überweisungDurchführenDlg.getÜberweisenButton().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				int vonKonto = Integer.valueOf(überweisungDurchführenDlg.getVonKontoField().getText());
				int kundenNummerVon = getKundenNummer(vonKonto);
				checkKonto(kundenNummerVon, vonKonto);

				int nachKonto = Integer.valueOf(überweisungDurchführenDlg.getNachKontoField().getText());
				int kundenNummerNach = getKundenNummer(nachKonto);
				checkKonto(kundenNummerNach, nachKonto);
			}

		});
	}

	private boolean checkKonto(int kundenNummer, int kontoNummer) {
		return checkKonto(kundenNummer, kontoNummer, 0);
	}

	private boolean checkKonto(int kundenNummer, int kontoNummer, double betrag) {
		boolean accountFound = false;
		Kunde kunde = Kunden.getKunde(kundenNummer);
		for (Konto konto : kunde.getKonten()) {
			if (konto.getKontoNummer() == kontoNummer) {
				if (konto.getKontostand() >= betrag) {
					accountFound = true;
				}
			}
		}
		return accountFound;
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

		if (kontotyp.equals("Girokonto")) {
			dispoZins = Double.parseDouble(JOptionPane.showInputDialog(anlegenKontoDlg,
					"Bitte geben sie den gewünschten Dispo ein(Als Kommazahl Bsp.: 150.0):"));
		} else {
			dispoZins = Double.parseDouble(JOptionPane.showInputDialog(anlegenKontoDlg,
					"Bitte geben sie den gewünschten Zinssatz ein(Als kommazahl Bsp.: 15.0)"));
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
