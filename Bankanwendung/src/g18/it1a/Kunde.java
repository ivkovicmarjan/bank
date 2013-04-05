package g18.it1a;

import g18.it1a.Konto.KontoTyp;

import java.util.ArrayList;
import java.util.List;

public class Kunde {
	
	private String name;
	private int kundenNummer;
	private List<Konto> konten = null;

	public Kunde(String kundenName, int kundenNummer) {
		setName(kundenName);
		this.setKundenNummer(kundenNummer);
		konten = new ArrayList<Konto>();
	}

	public String anzeigenKontostandsUebersicht() {
		if (konten.isEmpty()) {
			return "keine Konten vorhanden";
		}
		
		String ausgabe = "Übersicht der Konten von " + getName() + ":\n";
		for (Konto k: konten) {
			ausgabe = ausgabe + k.toString() + "\n\n";
		}
	
		return ausgabe;
	}

	public Konto anlegenKonto(KontoTyp kontoTyp) {
		int typ = 0;
		if (kontoTyp == KontoTyp.GIROKONTO) {
			typ = 1;
		} else {
			typ = 0;
		}
		
		int index = konten.size()+1;
		
		int kontoNummer = getKundenNummer() * (100 + typ) * 1000 + index;
		Konto konto = new Konto(kontoNummer, kontoTyp);
		konten.add(konto);
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

	public List<Konto> getKonten() {
		return konten;
	}

	public void setKonten(List<Konto> konten) {
		this.konten = konten;
	}

}
