package g18.it1a.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import g18.it1a.view.BankView;

public class CtlBankView {

	private BankView bankView;

	public CtlBankView() {
	}

	public void startBankView(final BankHandler bankHandler) {
		bankView = new BankView();

		bankView.getAnlegenKunde().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				final AnlegenKundeController anlegenKundeController = new AnlegenKundeController(bankHandler);
				anlegenKundeController.anlegenKundenActionPerformed();
			}
		});

		bankView.getAnlegenKonto().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				final AnlegenKontoController anlegenKontoController = new AnlegenKontoController(bankHandler);
				anlegenKontoController.anlegenKontoActionPerformed();
			}
		});

		bankView.getAnzeigenKontostand().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				final KontostandsübersichtAnzeigenController kontostandsübersichtController = new KontostandsübersichtAnzeigenController();
				kontostandsübersichtController.anzeigenKontostandActionPerformed();
			}
		});

		bankView.getDurchführenUeberweisungen().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				final ÜberweisungDurchführenController überweisungDurchführenController = new ÜberweisungDurchführenController();
				überweisungDurchführenController.überweisungDurchführenActionPerformed();
			}
		});

		bankView.getDurchfuehrenZahlungen().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				final EinAuszahlungDurchführenController einAuszahlungDurchführenController = new EinAuszahlungDurchführenController();
				einAuszahlungDurchführenController.einAuszahlenActionPerformed();
			}
		});

		bankView.getAnzeigenKontobewegung().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				final KontobewegungController kontobewegungController = new KontobewegungController();
				kontobewegungController.kontobewegungActionPerformed();
			}
		});

		bankView.setVisible(true);
	}
}
