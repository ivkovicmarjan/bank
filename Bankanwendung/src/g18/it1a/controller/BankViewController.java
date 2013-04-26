package g18.it1a.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import g18.it1a.view.BankView;

public class BankViewController {

	private BankView bankView;

	public BankViewController(final BankHandler bankHandler) {
		bankView = new BankView();

		bankView.getAnlegenKunde().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				final KundeAnlegenController anlegenKundeController = new KundeAnlegenController(bankHandler, bankView);
				anlegenKundeController.anlegenKundenActionPerformed();
			}
		});

		bankView.getAnlegenKonto().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				final KontoAnlegenController anlegenKontoController = new KontoAnlegenController(bankHandler, bankView);
				anlegenKontoController.anlegenKontoActionPerformed();
			}
		});

		bankView.getAnzeigenKontostand().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				final Kontostands�bersichtAnzeigenController kontostands�bersichtController = new Kontostands�bersichtAnzeigenController(bankView);
				kontostands�bersichtController.anzeigenKontostandActionPerformed();
			}
		});

		bankView.getDurchf�hrenUeberweisungen().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				final �berweisungDurchf�hrenController �berweisungDurchf�hrenController = new �berweisungDurchf�hrenController(bankView);
				�berweisungDurchf�hrenController.�berweisungDurchf�hrenActionPerformed();
			}
		});

		bankView.getDurchfuehrenZahlungen().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				final EinAuszahlungDurchf�hrenController einAuszahlungDurchf�hrenController = new EinAuszahlungDurchf�hrenController(bankView);
				einAuszahlungDurchf�hrenController.einAuszahlenActionPerformed();
			}
		});

		bankView.getAnzeigenKontobewegung().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				final KontobewegungController kontobewegungController = new KontobewegungController(bankView);
				kontobewegungController.kontobewegungActionPerformed();
			}
		});

		bankView.getEnde().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		bankView.setVisible(true);
	}
}
