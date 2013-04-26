package g18.it1a.controller;

import g18.it1a.exceptions.AccountNotFoundException;
import g18.it1a.model.Konto;
import g18.it1a.model.Kunde;
import g18.it1a.model.Kunden;

public class ControllerUtils {

	public static Konto getKonto(long kontoNummer) throws AccountNotFoundException {
		int kundenNummer = getKundenNummer(kontoNummer);
		Kunde kunde = Kunden.getKunde(kundenNummer);
		return kunde.getKonto(kontoNummer);
	}
	
	public static int getKundenNummer(long vonKonto) throws AccountNotFoundException {
		String kontoNummer = Long.toString(vonKonto);
		int kontoNummerLength = kontoNummer.length();
		if (kontoNummerLength < 6) {
			throw new AccountNotFoundException();
		}
		String kundenNummerStr = kontoNummer.substring(0, kontoNummerLength - 5);
		int kundenNummer = Integer.valueOf(kundenNummerStr);
		return kundenNummer;
	}
}
