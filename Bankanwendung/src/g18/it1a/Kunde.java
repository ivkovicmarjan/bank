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
		String ausgabe = null;
		for (Konto k: konten) {
			ausgabe = ausgabe + k.toString() + "\n\n";
		}
		if (ausgabe == null) {
			ausgabe = "keine Konten vorhanden";
		}
		return ausgabe;
	}

	public Konto anlegenKonto(KontoTyp kontoTyp) {
		Konto konto = new Konto(1, 3.2, kontoTyp);
		konten.add(konto);
		return konto;
	}
	
	public void auszahlenBetrag(Konto konto) {
	 
	}
	
	public void einzahlenBetrag(Konto konto) {
		
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
