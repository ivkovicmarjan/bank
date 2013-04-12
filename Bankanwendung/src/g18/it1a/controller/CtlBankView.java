package g18.it1a.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
		
		this.bankView.getAnlegenKunde().addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent evt) 
			{
				anlegenKundenActionPerformed();
			}
		});
		
		this.bankView.getAnlegenKonto().addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				anlegenKontoActionPerformed();
			}
		});
		
		this.bankView.getDurchfuehrenZahlungen().addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				EinAuszahlenActionPerformed();
			}
		});
		
		this.bankView.setVisible(true);
	}

	private void anlegenKundenActionPerformed() {
		anlegenKundeDlg = new AnlegenKundeDlg(bankView, true);
		anlegenKundeDlg.getAnlegenButton().addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent evt)
			{
				btAnlegenKundeActionPerformed();
			}
		});
		
		anlegenKundeDlg.getBeendenButton().addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent evt) {
				btAnlegenKundeBeendenActionPerformed();
			}
		});
	}

	private void btAnlegenKundeActionPerformed() {
		this.btAnlegenKundeActionPerformed(anlegenKundeDlg.getKundenNummerField().getText());
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
				btAnlegenKontoActionPerformed();
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

	private void EinAuszahlenActionPerformed() {
		this.einAuszahlungDurchführenDlg = new EinAuszahlungDurchführenDlg(bankView, true);
		
		this.einAuszahlungDurchführenDlg.getEinauszahlenButton().addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent evt)
			{
				btEinAuszahlenActionPerformed();
			}
		});
		
		this.einAuszahlungDurchführenDlg.getBeendenButton().addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent evt) {
				btEinAuszahlenBeendenActionPerformed();
			}	
		});
	}

	private void btEinAuszahlenActionPerformed() {
		// TODO Auto-generated method stub
	}
	
	private void btEinAuszahlenBeendenActionPerformed() {
		this.einAuszahlungDurchführenDlg.dispose();
	}
	
	protected void btAnlegenKontoBeendenActionPerformed() {
		anlegenKontoDlg.dispose();
	}

	protected void btAnlegenKontoActionPerformed() {
		
	}
}
