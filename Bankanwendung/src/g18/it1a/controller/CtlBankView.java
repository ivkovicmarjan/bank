package g18.it1a.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import g18.it1a.model.Konto;
import g18.it1a.model.Kunde;
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

		this.bankView.setVisible(true);
	}

	private void kontobewegungActionPerformed() {
		kontobewegungDlg = new KontobewegungDlg();
	}

	private void anzeigenKontostandActionPerformed() {
		kontostands�bersichtAnzeigenDlg = new Kontostands�bersichtAnzeigenDlg();

		kontostands�bersichtAnzeigenDlg.getbtnKontoubersicht().addActionListener(new ActionListener() {
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
		
		try
		{
			kundennummer = Integer.parseInt(kontostands�bersichtAnzeigenDlg.getKundennummerField().getText());
			
			JTable table = kontostands�bersichtAnzeigenDlg.getKontoubersicht();
			DefaultTableModel model = (DefaultTableModel) table.getModel();
			
			model.addRow(new Object[]{".getKontoart();", kundennummer, ".getKontostand();"});
		}
		catch(NumberFormatException e)
		{
			
		}
	}

	private void anlegenKontoActionPerformed() {
		anlegenKontoDlg = new AnlegenKontoDlg();

		anlegenKontoDlg.getAnlegenButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				try {
					
					btAnlegenKontoActionPerformed("" + anlegenKontoDlg.getButtonGroup().getSelection().getActionCommand(), anlegenKontoDlg
							.getKundenNummerFeld().getText());
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
				int vonKonto = Integer.valueOf(�berweisungDurchf�hrenDlg.getVonKontoField().getText());
				int kundenNummerVon = getKundenNummer(vonKonto);
				checkKonto(kundenNummerVon, vonKonto);

				int nachKonto = Integer.valueOf(�berweisungDurchf�hrenDlg.getNachKontoField().getText());
				int kundenNummerNach = getKundenNummer(nachKonto);
				checkKonto(kundenNummerNach, nachKonto);
			}

		});
	}

	private void checkKonto(int kundennummer, int kontonummer) {

	}

	private int getKundenNummer(int vonKonto) {
		String kontoNummer = Integer.toString(vonKonto);
		int kontoNummerLength = kontoNummer.length();
		String kundenNummerStr = kontoNummer.substring(0, kontoNummerLength - 5);
		int kundenNummer = Integer.valueOf(kundenNummerStr);
		return kundenNummer;
	}

	protected void btAnlegenKontoActionPerformed(String kontotyp, String kundennummer) {
		double zahl = 0;
		int kundenNummer = 0;
		try {

			kundenNummer = Integer.parseInt(kundennummer);

		} catch (NumberFormatException e) {
			String result = JOptionPane.showInputDialog(anlegenKontoDlg, "Bitte Zahl als Kundennummer eingeben:");
			btAnlegenKontoActionPerformed(kontotyp, result);
		}

		if (kontotyp.equals("Girokonto")) {
			zahl = Double.parseDouble(JOptionPane.showInputDialog(anlegenKontoDlg,
					"Bitte geben sie den gew�nschten Dispo ein(Als Kommazahl Bsp.: 150.0):"));
		} else {
			zahl = Double.parseDouble(JOptionPane.showInputDialog(anlegenKontoDlg,
					"Bitte geben sie den gew�nschten Zinssatz ein(Als kommazahl Bsp.: 15.0)"));
		}

		try {

			Konto konto = bankHandler.anlegenKonto(kundenNummer, kontotyp, zahl);
			JOptionPane.showMessageDialog(anlegenKontoDlg, "Ihr Konto wurde angelegt!\n Ihre Kontonummer lautet: " + konto.getKontonummer());
			anlegenKontoDlg.dispose();

		} catch (NullPointerException e) {
			JOptionPane.showMessageDialog(anlegenKontoDlg, "Dieser Kunde existiert nicht!");
			anlegenKontoDlg.getKundenNummerFeld().setText("");
		}
	}
}
