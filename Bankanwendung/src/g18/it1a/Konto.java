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
	
	public void auszahlen(int i) {
		// TODO Auto-generated method stub
		
	}

	public void einzahlen(int i) {
		// TODO Auto-generated method stub
		
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
