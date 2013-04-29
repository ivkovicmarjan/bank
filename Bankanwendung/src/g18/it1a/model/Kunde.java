package g18.it1a.model;

import g18.it1a.exceptions.AccountNotFoundException;
import g18.it1a.exceptions.LiquidityException;
import g18.it1a.model.KontoTyp;

import java.util.HashMap;

public class Kunde {

	private String name;
	private int kundenNummer;
	private HashMap<Long, Konto> konten = null;

	public Kunde(String kundenName, int kundenNummer) {
		setName(kundenName);
		this.setKundenNummer(kundenNummer);
		konten = new HashMap<Long, Konto>();

	}

	public String anzeigenKontostandsUebersicht() {
		if (konten.isEmpty()) {
			return "keine Konten vorhanden";
		}

		String ausgabe = "Übersicht der Konten von " + getName() + ":\n";
		for (Konto konto : konten.values()) {
			ausgabe = ausgabe + konto.toString() + "\n";
		}

		return ausgabe;
	}

	public Konto anlegenKonto(KontoTyp kontoTyp, double dispoZins) {
		Konto konto = null;

		if (kontoTyp == KontoTyp.Girokonto) {
			konto = new Girokonto(generiereKontonummer(kontoTyp), kontoTyp, dispoZins);
		} else {
			konto = new Sparkonto(generiereKontonummer(kontoTyp), kontoTyp, dispoZins);
		}

		konten.put(konto.getKontoNummer(), konto);
		return konto;
	}

	public void auszahlenBetrag(Konto konto, double betrag) throws LiquidityException {
		konto.auszahlen(betrag, "Auszahlung");
	}

	public void einzahlenBetrag(Konto konto, double betrag) {
		konto.einzahlen(betrag, "Einzahlung");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getKundenNummer() {
		return kundenNummer;
	}

	public void setKundenNummer(int kundenNummer) {
		this.kundenNummer = kundenNummer;
	}

	public Konto getKonto(long kontoNummer) throws AccountNotFoundException {
		Konto konto = konten.get(kontoNummer);
		if (konto == null) {
			throw new AccountNotFoundException();
		}
		return konto;
	}

	public HashMap<Long, Konto> getKonten() {
		return konten;
	}

	public void setKonten(HashMap<Long, Konto> konten) {
		this.konten = konten;
	}

	private long generiereKontonummer(KontoTyp kontoTyp) {
		int typ = 0;
		int index = konten.size() + 1;

		if (kontoTyp == KontoTyp.Girokonto) {
			typ = 1;
		} else {
			typ = 0;
		}
		return (getKundenNummer() * 100 + typ) * 1000 + index;
	}

	public Konto anlegenKonto(KontoTyp kontoTyp) {
		return anlegenKonto(kontoTyp, 0.0);
	}
	
	public String toString() {
		return getName() + " " + getKundenNummer();
	}
}
