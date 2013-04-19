package g18.it1a.model;

import java.util.Date;
import g18.it1a.model.KontoTyp;

public class Girokonto extends Konto {
	private double dispo;

	public Girokonto(int kontonummer, KontoTyp kontoTyp, double dispo) {
		super(kontonummer, kontoTyp);
		setDispo(dispo);
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
		setBewegung(new Kontobewegung(betrag, new Date(), ""));
		getKontobewegung().add(getBewegung());
		this.setKontostand(ergebnis);
	}

	public double getDispo() {
		return this.dispo;
	}

	public void setDispo(double dispo) {
		this.dispo = dispo;
	}
}
