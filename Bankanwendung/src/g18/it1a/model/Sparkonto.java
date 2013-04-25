package g18.it1a.model;

import g18.it1a.exceptions.LiquidityException;

import java.util.Date;

public class Sparkonto extends Konto {
	private double zinssatz;

	public Sparkonto(long kontonummer, KontoTyp kontoTyp, double zinssatz) {
		super(kontonummer, kontoTyp);
		setZinssatz(zinssatz);
	}

	@Override
	public void auszahlen(double betrag) throws LiquidityException {
		checkLiquidity(betrag);
		setBewegung(new Kontobewegung(betrag, new Date(), ""));
		getKontobewegung().add(getBewegung());
		setKontostand(getKontostand() - betrag);
	}

	@Override
	public void checkLiquidity(double betrag) throws LiquidityException {
		if ((getKontostand() - betrag) < 0.0) {
			throw new LiquidityException();
		}
	}

	public double getZinssatz() {
		return this.zinssatz;
	}

	public void setZinssatz(double zinssatz) {
		this.zinssatz = zinssatz;
	}
}
