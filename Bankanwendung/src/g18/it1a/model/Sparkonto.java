package g18.it1a.model;

import java.util.Date;

public class Sparkonto extends Konto {
	private double zinssatz;

	public Sparkonto(int kontonummer, KontoTyp kontoTyp, double zinssatz) {
		super(kontonummer, kontoTyp);
		setZinssatz(zinssatz);
	}

	public double getZinssatz() {
		return this.zinssatz;
	}

	public void setZinssatz(double zinssatz) {
		this.zinssatz = zinssatz;
	}

	@Override
	public void auszahlen(double betrag) {
		if (checkLiquidity(betrag)) {
			setBewegung(new Kontobewegung(betrag, new Date(), ""));
			getKontobewegung().add(getBewegung());
			setKontostand(getKontostand() - betrag);
		}
	}

	@Override
	public boolean checkLiquidity(double betrag) {
		return (getKontostand() - betrag) >= 0.0;
	}
}
