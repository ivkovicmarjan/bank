package g18.it1a.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import g18.it1a.model.Kunde;
import g18.it1a.view.AnlegenKundeDlg;
import g18.it1a.view.BankView;

public class CtlBankView implements ActionListener {

	private BankView bankView;
	private AnlegenKundeDlg anlegenKundeDlg;
	private BankHandler bankHandler;

	public CtlBankView() {
	}

	public void startBankView(BankHandler bankHandler) {
		this.bankHandler = bankHandler;
		bankView = new BankView();
		bankView.getAnlegenKunde().addActionListener(this);
		bankView.setVisible(true);
	}

	private void anlegenKundenActionPerformed() {
		anlegenKundeDlg = new AnlegenKundeDlg(bankView, true);
		anlegenKundeDlg.getAnlegenButton().addActionListener(this);
		anlegenKundeDlg.getBeendenButton().addActionListener(this);
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

	private void jButtonKundeAnlegenBeendenActionPerformed() {
		anlegenKundeDlg.dispose();
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getActionCommand() == "Kunde anlegen")
		{
			this.anlegenKundenActionPerformed();
		}
		
		if(e.getActionCommand() == "Anlegen")
		{
			this.btAnlegenKundeActionPerformed();
		}
		
		if(e.getActionCommand() == "Beenden")
		{
			this.jButtonKundeAnlegenBeendenActionPerformed();
		}
	}
}
