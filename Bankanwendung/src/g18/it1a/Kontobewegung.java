package g18.it1a;

import java.util.Date;

public class Kontobewegung {
	private Date datum;
	private long betrag;
	private String bemerkung;

	public Date getDatum() {
		return this.datum;
	}

	public void setDatum(Date datum) {
		this.datum = datum;
	}

	public long getBetrag() {
		return betrag;
	}

	public void setBetrag(long betrag) {
		this.betrag = betrag;
	}

	public String getBemerkung() {
		return this.bemerkung;
	}

	public void setBemerkung(String bemerkung) {
		this.bemerkung = bemerkung;
	}
}
