package g18.it1a;

public class Konto {

	private int kontonummer;
	private double kontostand;
	private KontoTyp kontoTyp;
	
	public enum KontoTyp {
		GIROKONTO,
		SPARKONTO
	}

	
	public Konto(int kontonummer, double kontostand, KontoTyp kontoTyp) 
	{
		this.setKontonummer(kontonummer);
		this.setKontostand(kontostand);
		this.kontoTyp = kontoTyp;
	}
	
	public void auszahlen(int betrag) {
		if(this.kontostand > betrag)
		{
			this.kontostand = this.kontostand - betrag;
		}
	}

	public void einzahlen(int betrag) {
		this.kontostand = this.kontostand + betrag;
	}

	public int getKontonummer() {
		return kontonummer;
	}

	public void setKontonummer(int kontonummer) {
		this.kontonummer = kontonummer;
	}

	public double getKontostand() {
		return kontostand;
	}

	public void setKontostand(double kontostand) {
		this.kontostand = kontostand;
	}
	
}
