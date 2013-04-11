package g18.it1a;

public class Konto {

	private int kontonummer;
	private double kontostand = 0.00;
	private KontoTyp kontoTyp;

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

	public String toString() {
		return String.format("Kontonummer: %s, Kontostand: %s, Kontotyp: %s",
				this.kontonummer, this.kontostand, this.kontoTyp.name());
	}
}
