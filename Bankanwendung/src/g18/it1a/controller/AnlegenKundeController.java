package g18.it1a.controller;

import g18.it1a.model.Kunde;
import g18.it1a.view.AnlegenKundeDlg;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class AnlegenKundeController {
	
	private AnlegenKundeDlg anlegenKundeDlg;
	private BankHandler bankHandler;
	
	public AnlegenKundeController(BankHandler bankHandler) {
		this.bankHandler = bankHandler;
	}
	
	public void anlegenKundenActionPerformed() {
		anlegenKundeDlg = new AnlegenKundeDlg();
		anlegenKundeDlg.getAnlegenButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				btAnlegenKundeActionPerformed(anlegenKundeDlg.getKundenNummerField().getText(), anlegenKundeDlg.getKundenNameField().getText());
			}
		});
	}

	private void btAnlegenKundeActionPerformed(String kundeNummer, String kundenName) {
		try {
			int kundenNummer = Integer.parseInt(kundeNummer);
			
			if(kundenName.length()<1)
			{
				String result = JOptionPane.showInputDialog(anlegenKundeDlg, "Bitte einen richtigen Namen eingeben.", "Fehler!", JOptionPane.ERROR_MESSAGE);
				btAnlegenKundeActionPerformed(anlegenKundeDlg.getKundenNummerField().getText(), result);
			}
			else
			{
				if(kundenNummer == 0)
				{
					String result = JOptionPane.showInputDialog(anlegenKundeDlg, "Bitte eine Zahl die nicht 0 ist als Kundennummer eingeben.", "Fehler!", JOptionPane.ERROR_MESSAGE);
					
					if(result != null)
					{				
						btAnlegenKundeActionPerformed(result, anlegenKundeDlg.getKundenNameField().getText());	
					}
				}
				else
				{
					Kunde neuerKunde = bankHandler.anlegenKunde(kundenName, kundenNummer);
					JOptionPane.showMessageDialog(anlegenKundeDlg, "Kunde: " + neuerKunde.getName() + " angelegt.");
				}
			}			
		} catch (NumberFormatException e) {
			String result = JOptionPane.showInputDialog(anlegenKundeDlg, "Bitte eine Zahl die nicht 0 ist als Kundennummer eingeben.", "Fehler!", JOptionPane.ERROR_MESSAGE);
			
			if(result != null)
			{				
				btAnlegenKundeActionPerformed(result, anlegenKundeDlg.getKundenNameField().getText());	
			}
		}
	}
}
