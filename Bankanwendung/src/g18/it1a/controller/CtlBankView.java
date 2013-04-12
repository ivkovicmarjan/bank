package g18.it1a.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JOptionPane;

import g18.it1a.model.Kunde;
import g18.it1a.view.AnlegenKontoDlg;
import g18.it1a.view.AnlegenKundeDlg;
import g18.it1a.view.BankView;
import g18.it1a.view.EinAuszahlungDurchführenDlg;

public class CtlBankView {

	private BankView bankView;
	private AnlegenKundeDlg anlegenKundeDlg;
	private AnlegenKontoDlg anlegenKontoDlg;
	private EinAuszahlungDurchführenDlg einAuszahlungDurchführenDlg;
	private BankHandler bankHandler;

	public CtlBankView() {
	}

	public void startBankView(BankHandler bankHandler) {
		this.bankHandler = bankHandler;
		this.bankView = new BankView();

		this.bankView.getAnlegenKunde().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				anlegenKundenActionPerformed();
			}
		});

		this.bankView.getAnlegenKonto().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				anlegenKontoActionPerformed();
			}
		});

		this.bankView.getDurchfuehrenZahlungen().addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						einAuszahlenActionPerformed();
					}
				});

		this.bankView.setVisible(true);
	}

	private void anlegenKundenActionPerformed() {
		anlegenKundeDlg = new AnlegenKundeDlg(bankView, true);
		anlegenKundeDlg.getAnlegenButton().addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						btAnlegenKundeActionPerformed(anlegenKundeDlg
								.getKundenNummerField().getText());
					}
				});

		anlegenKundeDlg.getBeendenButton().addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						btAnlegenKundeBeendenActionPerformed();
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

	private void btAnlegenKundeBeendenActionPerformed() {
		anlegenKundeDlg.dispose();
	}

	private void anlegenKontoActionPerformed() {
		anlegenKontoDlg = new AnlegenKontoDlg(bankView, true);

		anlegenKontoDlg.getAnlegenButton().addActionListener(new ActionListener() 
		{	
			public void actionPerformed(ActionEvent evt) 
			{
				try 
				{
					btAnlegenKontoActionPerformed("" + anlegenKontoDlg.getList()
																	  .getModel()
																	  .getElementAt(anlegenKontoDlg.getList()
																			  					   .getSelectedIndex()),
													   anlegenKontoDlg.getTextfield().getText());
				}
				catch(IndexOutOfBoundsException e)
				{
					JOptionPane.showMessageDialog(anlegenKontoDlg, "bitte wählen Sie einen Kontotyp aus!");
				}
			}
		});

		anlegenKontoDlg.getBeendenButton().addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent evt)
			{
				btAnlegenKontoBeendenActionPerformed();
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
		
		this.einAuszahlungDurchführenDlg.getBeendenButton().addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent evt) {
				btEinAuszahlenBeendenActionPerformed();
			}	
		});
	}

	private void btEinzahlenActionPerformed(String value) {
		double betrag;
		int kundennummer;
		
		try
		{
			betrag = Integer.parseInt(value);
		}
		catch (NumberFormatException e)
		{
			String result = JOptionPane.showInputDialog(einAuszahlungDurchführenDlg, "Bitte Zahl als Betrag eingeben.");
			this.btEinzahlenActionPerformed(result);
		}
	}

	private void btAuszahlenActionPerformed() {

	}
	
	private void btEinAuszahlenBeendenActionPerformed() {
		this.einAuszahlungDurchführenDlg.dispose();
	}

	protected void btAnlegenKontoBeendenActionPerformed() {
		anlegenKontoDlg.dispose();
	}
		
	protected void btAnlegenKontoActionPerformed(String kontotyp, String kundennummer) {
		double zahl;
		try 
		{

			Integer.parseInt(kundennummer);
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
	}
}
