package g18.it1a.model;

import g18.it1a.model.Konto.KontoTyp;

import java.util.HashMap;

public class Kunde {

	private String name;
	private int kundenNummer;
	private HashMap<Integer, Konto> konten = null;

	public Kunde(String kundenName, int kundenNummer) {
		setName(kundenName);
		this.setKundenNummer(kundenNummer);
		konten = new HashMap<Integer, Konto>();

	}

	public String anzeigenKontostandsUebersicht() {
		if (konten.isEmpty()) {
			return "keine Konten vorhanden";
		}

		String ausgabe = "Übersicht der Konten von " + getName() + ":\n";
		for (Konto konto : konten.values()) {
			ausgabe = ausgabe + konto.toString() + "\n\n";
		}

		return ausgabe;
	}

	public Konto anlegenKonto(KontoTyp kontoTyp, double dispoZins) {
		Konto konto = null;

		if (kontoTyp == KontoTyp.GIROKONTO) {
			konto = new Girokonto(generiereKontonummer(kontoTyp), kontoTyp, dispoZins);
		} else {
			konto = new Sparkonto(generiereKontonummer(kontoTyp), kontoTyp, dispoZins);
		}

		konten.put(konto.getKontoNummer(), konto);
		return konto;
	}

	public void auszahlenBetrag(Konto konto, double betrag) {
		konto.auszahlen(betrag);
	}

	public void einzahlenBetrag(Konto konto, double betrag) {
		konto.einzahlen(betrag);
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

	public Konto getKonto(int kontoNummer) {
		return konten.get(kontoNummer);
	}

	public HashMap<Integer, Konto> getKonten() {
		return konten;
	}

	public void setKonten(HashMap<Integer, Konto> konten) {
		this.konten = konten;
	}

	private int generiereKontonummer(KontoTyp kontoTyp) {
		int typ = 0;
		int index = konten.size() + 1;

		if (kontoTyp == KontoTyp.GIROKONTO) {
			typ = 1;
		} else {
			typ = 0;
		}
		return (getKundenNummer() * 100 + typ) * 1000 + index;
	}

	public Konto anlegenKonto(KontoTyp kontoTyp) {
		return anlegenKonto(kontoTyp, 0.0);
	}
}
