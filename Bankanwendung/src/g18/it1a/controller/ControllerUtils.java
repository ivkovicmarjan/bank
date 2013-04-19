package g18.it1a.controller;

import g18.it1a.model.Konto;
import g18.it1a.model.Kunde;
import g18.it1a.model.Kunden;

public class ControllerUtils {

	public static Konto getKonto(int kontoNummer) {
		int kundenNummer = getKundenNummer(kontoNummer);
		Kunde kunde = Kunden.getKunde(kundenNummer);
		return kunde.getKonto(kontoNummer);
	}
	
	// TODO Try/Catch, Exceptions und Fehlerbehandlung
	public static int getKundenNummer(int vonKonto) {
		String kontoNummer = Integer.toString(vonKonto);
		int kontoNummerLength = kontoNummer.length();
		String kundenNummerStr = kontoNummer.substring(0, kontoNummerLength - 5);
		int kundenNummer = Integer.valueOf(kundenNummerStr);
		return kundenNummer;
	}
}
