package g18.it1a.model;

import java.util.Date;

import g18.it1a.exceptions.LiquidityException;
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
	 * @param betrag
	 *            Der Betrag der abgehoben werden soll
	 * @throws LiquidityException
	 * 
	 */
	@Override
	public void auszahlen(double betrag) throws LiquidityException {
		checkLiquidity(betrag);
		setBewegung(new Kontobewegung(betrag, new Date(), ""));
		getKontobewegung().add(getBewegung());
		setKontostand(getKontostand() - betrag);

	}

	public void checkLiquidity(double betrag) throws LiquidityException {
		double ergebnis = getKontostand() - betrag;
		if (ergebnis < -dispo) {
			throw new LiquidityException();
		}
	}

	public double getDispo() {
		return dispo;
	}

	public void setDispo(double dispo) {
		this.dispo = dispo;
	}
}
