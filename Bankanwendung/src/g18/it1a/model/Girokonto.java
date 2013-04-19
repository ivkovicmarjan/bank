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
	 * Zahlt den gew�nschten Betrag aus und berechnet den neuen Kontostand,
	 * sofern das Dispolimit nicht �berschritten wird.
	 * 
	 * @param betrag Der Betrag der abgehoben werden soll
	 * 
	 */
	@Override
	public void auszahlen(double betrag) {
		if (checkLiquidity(betrag)) {
			setBewegung(new Kontobewegung(betrag, new Date(), ""));
			getKontobewegung().add(getBewegung());
			setKontostand(getKontostand() - betrag);
		}
	}

	public boolean checkLiquidity(double betrag) {
		double ergebnis = getKontostand() - betrag;
		if (ergebnis < -dispo) {
			return false;
		}
		return true;
	}

	public double getDispo() {
		return dispo;
	}

	public void setDispo(double dispo) {
		this.dispo = dispo;
	}
}
