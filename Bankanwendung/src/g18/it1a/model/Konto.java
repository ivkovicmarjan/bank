package g18.it1a.model;

import java.util.ArrayList;
import java.util.Date;

public class Konto {

	private int kontoNummer;
	private double kontostand = 0.00;
	private KontoTyp kontoTyp;
	private ArrayList<Kontobewegung> kontobewegung;

	public enum KontoTyp {
		GIROKONTO, SPARKONTO
	}

	public Konto(int kontoNummer, KontoTyp kontoTyp) {
		this.kontoNummer = kontoNummer;
		this.kontoTyp = kontoTyp;
	}

	public void auszahlen(double betrag) {

		if (this.kontostand >= betrag) {
			this.kontostand = this.kontostand - betrag;
		}
	}

	public void einzahlen(double betrag) {
		Kontobewegung kontobewegung = new Kontobewegung(betrag, new Date(), "");
		getKontobewegung().add(kontobewegung);
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
		return kontobewegung;
	}

	public void setKontobewegung(ArrayList<Kontobewegung> kontobewegung) {
		this.kontobewegung = kontobewegung;
	}

	public String toString() {
		return String.format("Kontonummer: %s, Kontostand: %s, Kontotyp: %s", this.kontoNummer, this.kontostand, this.kontoTyp.name());
	}
}
