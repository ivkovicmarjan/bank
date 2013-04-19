package g18.it1a.model;

import java.util.Date;

public class Überweisung {
	private Date datum;
	private double betrag;
	private Konto quelle;
	private Konto ziel;

	public Überweisung(Konto quelle, Konto ziel, double betrag, Date date) {
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

	public void durchfuehrenUeberweisung() {
		if (quelle.checkLiquidity(betrag)) {
			quelle.auszahlen(this.betrag);
			ziel.einzahlen(this.betrag);
		} else {
			//TODO Exception, Fehlerdialog
			System.out.println("Konnte kein Geld überweisen, dar zu wenig vorhanden ist.");
		}
	}
}
