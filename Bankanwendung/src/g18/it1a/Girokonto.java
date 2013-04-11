package g18.it1a;

public class Girokonto extends Konto
{
	private double dispo;

	public Girokonto(int kontonummer, KontoTyp kontoTyp) {
		super(kontonummer, kontoTyp);
	}
	
	public double getDispo() {
		return this.dispo;
	}

	public void setDispo(double dispo) {
		this.dispo = dispo;
	}
	
	@Override
	public void auszahlen(double betrag) {
		double ergebnis = getKontostand() - betrag;
		if (ergebnis < -dispo) {
			return;
		}
		this.setKontostand(ergebnis);
	}
}
