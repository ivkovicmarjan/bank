package g18.it1a.model;

import java.util.HashMap;

import g18.it1a.controller.ControllerUtils;
import g18.it1a.exceptions.AccountNotFoundException;
import g18.it1a.exceptions.LiquidityException;
import g18.it1a.model.KontoTyp;

public class Kunden {
	private static HashMap<Integer, Kunde> kunden;

	public Kunden() {
		kunden = new HashMap<Integer, Kunde>();
	}

	public Kunde anlegenKunde(String kundenName, int kundenNummer) {
		Kunde kunde = new Kunde(kundenName, kundenNummer);
		kunden.put(new Integer(kundenNummer), kunde);
		return kunde;
	}
	
	public static Kunde getKunde(int kundenNummer) {
		return kunden.get(kundenNummer);
	}
	
	public Konto anlegenKonto(int kundennummer, KontoTyp kontotyp, double dispoZins) throws NullPointerException {
		Konto konto;
		
		if (!kunden.containsKey(kundennummer)) {
			throw new NullPointerException();
		}
		
		konto = kunden.get(kundennummer).anlegenKonto(kontotyp, dispoZins);
		
		return konto;
	}
	
	public static void einzahlen(double betrag, long kontonummer) throws AccountNotFoundException {
		Kunde kunde = ControllerUtils.getKundeVonKonto(kontonummer);
		kunde.einzahlenBetrag(kunde.getKonto(kontonummer), betrag);
	}
	
	public static void auszahlen(double betrag, long kontonummer) throws LiquidityException, AccountNotFoundException {
		Kunde kunde = ControllerUtils.getKundeVonKonto(kontonummer);
		kunde.auszahlenBetrag(kunde.getKonto(kontonummer), betrag);
	}
}