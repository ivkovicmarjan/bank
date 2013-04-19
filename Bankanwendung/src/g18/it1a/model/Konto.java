package g18.it1a.model;

import java.util.ArrayList;
import java.util.Date;

public class Konto {

	private int kontonummer;
	private double kontostand = 0.00;
	private KontoTyp kontoTyp;
	private ArrayList<Kontobewegung> kontobewegung;
	private Kontobewegung bewegung = null;

	public enum KontoTyp {
		GIROKONTO, SPARKONTO
	}

	public Konto(int kontonummer, KontoTyp kontoTyp) {
		this.kontonummer = kontonummer;
		this.kontoTyp = kontoTyp;
	}

	public void auszahlen(double betrag) {

		if (this.kontostand >= betrag) {
			this.kontostand = this.kontostand - betrag;
		}
	}

	public void einzahlen(double betrag) {
		setBewegung(new Kontobewegung(betrag, new Date(), ""));
		getKontobewegung().add(getBewegung());
		this.kontostand = this.kontostand + betrag;
	}

	public int getKontonummer() {
		return kontonummer;
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

	public String toString() {
		return String.format("Kontonummer: %s, Kontostand: %s, Kontotyp: %s", this.kontonummer, this.kontostand, this.kontoTyp.name());
	}
}
