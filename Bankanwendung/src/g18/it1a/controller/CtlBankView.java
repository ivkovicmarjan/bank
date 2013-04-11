package g18.it1a.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import g18.it1a.model.Kunde;
import g18.it1a.view.AnlegenKundeDlg;
import g18.it1a.view.BankView;

public class CtlBankView {

	private BankView bankView;
	private AnlegenKundeDlg anlegenKundeDlg;
	private BankHandler bankHandler;

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
		bankView.setVisible(true);
	}

	private void anlegenKundenActionPerformed() {
		anlegenKundeDlg = new AnlegenKundeDlg(bankView, true);
		anlegenKundeDlg.getAnlegenButton().addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						btAnlegenKundeActionPerformed();
					}
				});
		anlegenKundeDlg.getBeendenButton().addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jButtonKundeAnlegenBeendenActionPerformed();
					}
				});

	}

	private void btAnlegenKundeActionPerformed() {
		try {
			int kundenNummer = Integer.parseInt(anlegenKundeDlg
					.getKundenNummerField().getText());
			String kundenName = anlegenKundeDlg.getKundenNameField().getText();
			Kunde neuerKunde = bankHandler.anlegenKunde(kundenName,
					kundenNummer);
			new JOptionPane();
			JOptionPane.showInputDialog(anlegenKundeDlg,
					"Kunde:" + neuerKunde.getName() + " angelegt.");
			clearDlgKundeAnlegen();
		} catch (NumberFormatException e) {
			new JOptionPane();
			JOptionPane.showInputDialog(anlegenKundeDlg,
					"Bitte Zahl als Kundennummer eingeben.");
		}
	}

	private void clearDlgKundeAnlegen() {
		anlegenKundeDlg.getKundenNameField().setText("");
		anlegenKundeDlg.getKundenNummerField().setText("");
	}

	private void jButtonKundeAnlegenBeendenActionPerformed() {
		anlegenKundeDlg.dispose();
	}
}
