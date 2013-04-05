package g18.it1a;

import java.util.Date;

public class Ueberweisung 
{
	private Date datum;
	private long betrag;
	private Konto quelle;
	private Konto ziel;
	
	public Date getDatum() {
		return this.datum;
	}
	
	public void setDatum(Date datum) {
		this.datum = datum;
	}
	
	public long getBetrag() {
		return this.betrag;
	}
	
	public void setBetrag(long betrag) {
		this.betrag = betrag;
	}
	
	public Konto getQuelle() {
		return this.quelle;
	}
	
	public void setQuelle(Konto quelle) {
		this.quelle = quelle;
	}
	
	public Konto getZiel() {
		return this.ziel;
	}
	
	public void setZiel(Konto ziel) {
		this.ziel = ziel;
	}

	public void durchfuehrenUeberweisung()
	{
		
	}
}
