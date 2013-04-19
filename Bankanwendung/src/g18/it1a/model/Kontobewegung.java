package g18.it1a.model;

import java.util.Date;

public class Kontobewegung {
	private Date datum;
	private double betrag;
	private String bemerkung;
	
	public Kontobewegung(double betrag, Date datum, String bemerkung) {
		setDatum(datum);
		setBetrag(betrag);
		setBemerkung(bemerkung);
	}

	public Date getDatum() {
		return this.datum;
	}

	public void setDatum(Date datum) {
		this.datum = datum;
	}

	public double getBetrag() {
		return betrag;
	}

	public void setBetrag(double betrag) {
		this.betrag = betrag;
	}

	public String getBemerkung() {
		return this.bemerkung;
	}

	public void setBemerkung(String bemerkung) {
		this.bemerkung = bemerkung;
	}
}
