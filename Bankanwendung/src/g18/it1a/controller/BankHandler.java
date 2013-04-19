package g18.it1a.controller;

import g18.it1a.model.Konto;
import g18.it1a.model.KontoTyp;
import g18.it1a.model.Kunde;
import g18.it1a.model.Kunden;

public class BankHandler {
	private Kunden kunden;

	public BankHandler() {
		kunden = new Kunden();
	}

	public Kunde anlegenKunde(String kundenName, int kundenNummer) {
		return kunden.anlegenKunde(kundenName, kundenNummer);
	}
	
	public Konto anlegenKonto(int kundennummer, KontoTyp kontotyp, double dispoZins) throws NullPointerException {
		return kunden.anlegenKonto(kundennummer, kontotyp, dispoZins);
	}
}
