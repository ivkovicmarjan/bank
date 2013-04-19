package g18.it1a.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import g18.it1a.model.Konto;
import g18.it1a.model.Kunde;
import g18.it1a.view.AnlegenKontoDlg;
import g18.it1a.view.AnlegenKundeDlg;
import g18.it1a.view.BankView;
import g18.it1a.view.EinAuszahlungDurchführenDlg;
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
		
		this.bankView.getAnzeigenKontostand().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				anzeigenKontostandActionPerformed();
			}
		});
		
		this.bankView.getDurchführenUeberweisungen().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				überweisungDurchführenActionPerformed();
			}
		});


		bankView.getDurchfuehrenZahlungen().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				einAuszahlenActionPerformed();
			}
		});

		this.bankView.setVisible(true);
	}

	private void anzeigenKontostandActionPerformed() {
		kontostandsübersichtAnzeigenDlg = new KontostandsübersichtAnzeigenDlg();

		kontostandsübersichtAnzeigenDlg.getbtnKontoubersicht().addActionListener(new ActionListener() 
		{	
			public void actionPerformed(ActionEvent evt) 
			{
				btKontobersichtActionPerformed();
			}
		});

		bankView.setVisible(true);
	}

	private void anlegenKundenActionPerformed() {
		anlegenKundeDlg = new AnlegenKundeDlg();
		anlegenKundeDlg.getAnlegenButton().addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						btAnlegenKundeActionPerformed(anlegenKundeDlg
								.getKundenNummerField().getText());
					}
				});
	}

	private void btAnlegenKundeActionPerformed(String value) {
		try
		{
			String kundenName = anlegenKundeDlg.getKundenNameField().getText();
			int kundenNummer = Integer.parseInt(value);
			Kunde neuerKunde = bankHandler.anlegenKunde(kundenName,	kundenNummer);
			JOptionPane.showMessageDialog(anlegenKundeDlg, "Kunde: " + neuerKunde.getName() + " angelegt.");
			clearDlgKundeAnlegen();
		} 
		catch (NumberFormatException e) 
		{
			String result = JOptionPane.showInputDialog(anlegenKundeDlg, "Bitte Zahl als Kundennummer eingeben.");
			this.btAnlegenKundeActionPerformed(result);
		}
	}

	private void clearDlgKundeAnlegen() {
		anlegenKundeDlg.getKundenNameField().setText("");
		anlegenKundeDlg.getKundenNummerField().setText("");
	}

	private void btKontobersichtActionPerformed() {
	}
	
	private void anlegenKontoActionPerformed() {
		anlegenKontoDlg = new AnlegenKontoDlg();

		anlegenKontoDlg.getAnlegenButton().addActionListener(new ActionListener() 
		{	
			public void actionPerformed(ActionEvent evt) 
			{
				try 
				{
					btAnlegenKontoActionPerformed("" + anlegenKontoDlg.getButtonGroup().getSelection().getActionCommand(),
													   anlegenKontoDlg.getKundenNummerFeld().getText());
				}
				catch(NullPointerException e)
				{
					JOptionPane.showMessageDialog(anlegenKontoDlg, "bitte wählen Sie einen Kontotyp aus!");
				}
			}
		});
	}

	private void einAuszahlenActionPerformed() {
		this.einAuszahlungDurchführenDlg = new EinAuszahlungDurchführenDlg(bankView, true);
		
		this.einAuszahlungDurchführenDlg.getEinzahlenButton().addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent evt)
			{
				btEinzahlenActionPerformed(einAuszahlungDurchführenDlg.getBetragsField().getText());
			}
		});
		
		this.einAuszahlungDurchführenDlg.getAuszahlenButton().addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent evt)
			{
				btAuszahlenActionPerformed();
			}
		});
	}

	private void btEinzahlenActionPerformed(String value) {
		//double betrag;
		//int kundennummer;
		
		try
		{
			//betrag = Double.parseDouble(value);
		}
		catch (NumberFormatException e)
		{
			String result = JOptionPane.showInputDialog(einAuszahlungDurchführenDlg, "Bitte Zahl als Betrag eingeben.");
			this.btEinzahlenActionPerformed(result);
		}
	}

	private void btAuszahlenActionPerformed() {

	}
	
	private void überweisungDurchführenActionPerformed() {
		überweisungDurchführenDlg = new ÜberweisungDurchführenDlg();
		
		überweisungDurchführenDlg.getÜberweisenButton().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				überweisungDurchführenDlg.getVonKontoField();
			}
		});
	}

	protected void btAnlegenKontoActionPerformed(String kontotyp, String kundennummer) {
		double zahl = 0;
		int kundenNummer = 0;
		try 
		{

			kundenNummer = Integer.parseInt(kundennummer);
			
		}
		catch (NumberFormatException e)
		{
			String result = JOptionPane.showInputDialog(anlegenKontoDlg, "Bitte Zahl als Kundennummer eingeben:");
			this.btAnlegenKontoActionPerformed(kontotyp, result);
		}
		
		if (kontotyp.equals("Girokonto")) {
			zahl = Double.parseDouble(JOptionPane.showInputDialog(anlegenKontoDlg, "Bitte geben sie den gewünschten Dispo ein(Als Kommazahl Bsp.: 150.0):"));
		} else {
			zahl = Double.parseDouble(JOptionPane.showInputDialog(anlegenKontoDlg, "Bitte geben sie den gewünschten Zinssatz ein(Als kommazahl Bsp.: 15.0)"));
		}
		
		try {
			
		Konto konto = bankHandler.anlegenKonto(kundenNummer, kontotyp, zahl);
		JOptionPane.showMessageDialog(anlegenKontoDlg, "Ihr Konto wurde angelegt!\n Ihre Kontonummer lautet: "+konto.getKontonummer());
		anlegenKontoDlg.dispose();
		
		} catch (NullPointerException e) {
			JOptionPane.showMessageDialog(anlegenKontoDlg, "Dieser Kunde existiert nicht!");
			anlegenKontoDlg.getKundenNummerFeld().setText("");
		}
	}
}
