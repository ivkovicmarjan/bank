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
			clearDlgAnlegenKunde();
		} catch (NumberFormatException e) {
			String result = JOptionPane.showInputDialog(anlegenKundeDlg, "Bitte Zahl als Kundennummer eingeben.");
			btAnlegenKundeActionPerformed(result);
		}
	}

	private void clearDlgAnlegenKunde() {
		anlegenKundeDlg.getKundenNameField().setText("");
		anlegenKundeDlg.getKundenNummerField().setText("");
	}
}
