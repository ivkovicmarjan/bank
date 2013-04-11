package g18.it1a.controller;

import g18.it1a.model.Kunde;
import g18.it1a.view.Kunden;

public class BankHandler {
	private Kunden kunden;

	public BankHandler() {
		kunden = new Kunden();
	}

	public Kunde anlegenKunde(String kundenName, int kundenNummer) {
		return kunden.anlegenKunde(kundenName, kundenNummer);
	}
}
