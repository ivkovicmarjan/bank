package g18.it1a.model;

import java.util.Date;

public class �berweisung {
	private Date datum;
	private int betrag;
	private Konto quelle;
	private Konto ziel;

	public �berweisung(Konto quelle, Konto ziel, int betrag, Date date) {
		this.datum = date;
		this.betrag = betrag;
		this.quelle = quelle;
		this.ziel = ziel;
	}

	public Date getDatum() {
		return this.datum;
	}

	public int getBetrag() {
		return this.betrag;
	}

	public Konto getQuelle() {
		return this.quelle;
	}

	public Konto getZiel() {
		return this.ziel;
	}

	public void durchfuehrenUeberweisung() {
		if (this.quelle.getKontostand() > this.betrag) {
			this.quelle.auszahlen(this.betrag);
			this.ziel.einzahlen(this.betrag);
		} else {
			System.out.println("Konnte kein Geld �berweisen, dar zu wenig vorhanden ist.");
		}
	}
}
