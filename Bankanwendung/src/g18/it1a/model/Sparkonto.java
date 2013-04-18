package g18.it1a.model;

public class Sparkonto extends Konto {
	private double zinssatz;

	public Sparkonto(int kontonummer, KontoTyp kontoTyp) {
		super(kontonummer, kontoTyp);
	}

	public double getZinssatz() {
		return this.zinssatz;
	}

	public void setZinssatz(double zinssatz) {
		this.zinssatz = zinssatz;
	}

	public void ausszahlen(double betrag) {
		double ergebnis = getKontostand() - betrag;
		if (ergebnis >= 0.0) {
			setKontostand(ergebnis);
		}
	}
}
