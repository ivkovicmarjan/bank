package g18.it1a.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import g18.it1a.model.Kunde;
import g18.it1a.view.AnlegenKontoDlg;
import g18.it1a.view.AnlegenKundeDlg;
import g18.it1a.view.BankView;

public class CtlBankView {

	private BankView bankView;
	private AnlegenKundeDlg anlegenKundeDlg;
	private AnlegenKontoDlg anlegenKontoDlg;
	private BankHandler bankHandler;

	public CtlBankView() {
	}

	public void startBankView(BankHandler bankHandler) {
		this.bankHandler = bankHandler;
		bankView = new BankView();
		bankView.getAnlegenKunde().addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent evt) 
			{
				anlegenKundenActionPerformed();
			}
		});
		
		bankView.getAnlegenKonto().addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				anlegenKontoActionPerformed();
			}
		});
		
		bankView.setVisible(true);
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
				btKundeAnlegenBeendenActionPerformed();
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

	private void btKundeAnlegenBeendenActionPerformed() {
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

	protected void btAnlegenKontoBeendenActionPerformed() {
	}

	protected void btAnlegenKontoActionPerformed() {
		anlegenKontoDlg.dispose();
	}
}
