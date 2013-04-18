package g18.it1a.model;


import g18.it1a.model.Konto.KontoTyp;

import java.util.HashMap;

public class Kunden {
	private HashMap<Integer, Kunde> kunden;

	public Kunden() {
		kunden = new HashMap<Integer, Kunde>();
	}

	public Kunde anlegenKunde(String kundenName, int kundenNummer) {
		Kunde kunde = new Kunde(kundenName, kundenNummer);
		kunden.put(new Integer(kundenNummer), kunde);
		return kunde;
	}
	
	public Konto anlegenKonto(int kundennummer, String kontotyp, double kontoZahl) throws NullPointerException {
		Konto konto;
		
		if (!kunden.containsKey(kundennummer)) {
			throw new NullPointerException();
		}
		
		if (kontotyp.equals("Girokonto")) {
			konto = kunden.get(kundennummer).anlegenKonto(KontoTyp.GIROKONTO, kontoZahl);
		} else {
			konto = kunden.get(kundennummer).anlegenKonto(KontoTyp.SPARKONTO, kontoZahl);
		}
		
		return konto;
	}
}