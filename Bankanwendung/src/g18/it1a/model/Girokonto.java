package g18.it1a.model;

import java.util.Date;

public class Girokonto extends Konto {
	private double dispo;

	public Girokonto(int kontonummer, KontoTyp kontoTyp) {
		super(kontonummer, kontoTyp);
	}

	/**
	 * Zahlt den gewünschten Betrag aus und berechnet den neuen Kontostand,
	 * sofern das Dispolimit nicht überschritten wird.
	 * 
	 * @param betrag Der Betrag der abgehoben werden soll
	 * 
	 */
	@Override
	public void auszahlen(double betrag) {
		double ergebnis = getKontostand() - betrag;
		if (ergebnis < -dispo) {
			return;
		}
		Kontobewegung kontobewegung = new Kontobewegung(-betrag, new Date(), "");
		getKontobewegung().add(kontobewegung);
		this.setKontostand(ergebnis);
	}

	public double getDispo() {
		return this.dispo;
	}

	public void setDispo(double dispo) {
		this.dispo = dispo;
	}
}
