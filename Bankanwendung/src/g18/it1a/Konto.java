package g18.it1a;

public class Konto {

	private int kontonummer;
	private double kontostand;
	private KontoTyp kontoTyp;
	
	public enum KontoTyp {
		GIROKONTO,
		SPARKONTO
	}

	
	public Konto(int kontonummer, KontoTyp kontoTyp) 
	{
		this.kontonummer = kontonummer;
		this.kontoTyp = kontoTyp;
	}
	
	public void auszahlen(double i) {
		// TODO Auto-generated method stub
		
	}

	public void einzahlen(double i) {
		// TODO Auto-generated method stub
		
	}

	public int getKontonummer() {
		return kontonummer;
	}

	public double getKontostand() {
		return kontostand;
	}
	
	public String toString() {
		return "Kontonummer: "+kontonummer+", Kontostand: "+kontostand+", Kontotyp: "+KontoTyp.values();
	}
}
