package g18.it1a.model;


import g18.it1a.exceptions.LiquidityException;

import java.util.Date;

public class �berweisung {
	private Date datum;
	private double betrag;
	private Konto quelle;
	private Konto ziel;

	public �berweisung(Konto quelle, Konto ziel, double betrag, Date date) {
		this.datum = date;
		this.betrag = betrag;
		this.quelle = quelle;
		this.ziel = ziel;
	}

	public Date getDatum() {
		return this.datum;
	}

	public double getBetrag() {
		return betrag;
	}

	public Konto getQuelle() {
		return quelle;
	}

	public Konto getZiel() {
		return ziel;
	}

	public void durchf�hren�berweisung() throws LiquidityException {
		quelle.auszahlen(this.betrag, "�berweisung");
		ziel.einzahlen(this.betrag, "�berweisung");
	}
}
