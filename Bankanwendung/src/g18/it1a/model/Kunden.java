package g18.it1a.model;


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
}
