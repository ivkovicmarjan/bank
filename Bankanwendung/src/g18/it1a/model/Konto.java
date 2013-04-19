package g18.it1a.model;

import java.util.ArrayList;
import java.util.Date;

public abstract class Konto {

	private int kontoNummer;
	private double kontostand = 0.00;
	private KontoTyp kontoTyp;
	private ArrayList<Kontobewegung> kontobewegung;
	private Kontobewegung bewegung = null;

	public Konto(int kontoNummer, KontoTyp kontoTyp) {
		this.kontoNummer = kontoNummer;
		this.kontoTyp = kontoTyp;
	}

	public abstract void auszahlen(double betrag);

	public void einzahlen(double betrag) {
		setBewegung(new Kontobewegung(betrag, new Date(), ""));
		getKontobewegung().add(getBewegung());
		this.kontostand = this.kontostand + betrag;
	}

	public int getKontoNummer() {
		return kontoNummer;
	}

	public double getKontostand() {
		return kontostand;
	}

	public double setKontostand(double kontostand) {
		this.kontostand = kontostand;
		return this.kontostand;
	}

	public ArrayList<Kontobewegung> getKontobewegung() {
		if (kontobewegung == null) {
			kontobewegung = new ArrayList<Kontobewegung>();
		}
		return kontobewegung;
	}

	public void setKontobewegung(ArrayList<Kontobewegung> kontobewegung) {
		this.kontobewegung = kontobewegung;
	}

	public Kontobewegung getBewegung() {
		return bewegung;
	}
	
	public void setBewegung(Kontobewegung bewegung) {
		this.bewegung = bewegung;
	}

	public KontoTyp getKontoTyp() {
		return kontoTyp;
	}

	public String toString() {
		return String.format("Kontonummer: %s, Kontostand: %s, Kontotyp: %s", this.kontoNummer, this.kontostand, this.kontoTyp.name());
	}
}
