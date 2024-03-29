package g18.it1a.model;

import g18.it1a.exceptions.LiquidityException;

import java.util.ArrayList;
import java.util.Date;

public abstract class Konto {

	private long kontoNummer;
	private double kontostand = 0.00;
	private KontoTyp kontoTyp;
	private ArrayList<Kontobewegung> kontobewegung;
	private Kontobewegung bewegung = null;

	public Konto(long kontoNummer, KontoTyp kontoTyp) {
		this.kontoNummer = kontoNummer;
		this.kontoTyp = kontoTyp;
	}

	public abstract void auszahlen(double betrag, String bemerkung) throws LiquidityException;
	
	protected abstract void checkLiquidity(double betrag) throws LiquidityException;

	public void einzahlen(double betrag, String bemerkung) {
		setBewegung(new Kontobewegung(betrag, new Date(), bemerkung));
		getKontobewegung().add(getBewegung());
		this.kontostand = this.kontostand + betrag;
	}

	public long getKontoNummer() {
		return kontoNummer;
	}

	public double getKontostand() {
		return kontostand;
	}

	public double setKontostand(double kontostand) {
		this.kontostand = kontostand;
		return this.kontostand;
	}

	public ArrayList<Kontobewegung> getKontobewegung() {
		if (kontobewegung == null) {
			kontobewegung = new ArrayList<Kontobewegung>();
		}
		return kontobewegung;
	}

	public void setKontobewegung(ArrayList<Kontobewegung> kontobewegung) {
		this.kontobewegung = kontobewegung;
	}

	public Kontobewegung getBewegung() {
		return bewegung;
	}
	
	public void setBewegung(Kontobewegung bewegung) {
		this.bewegung = bewegung;
	}

	public KontoTyp getKontoTyp() {
		return kontoTyp;
	}

	public String toString() {
		return String.format("Kontonummer: %s, Kontostand: %s, Kontotyp: %s", this.kontoNummer, this.kontostand, this.kontoTyp.name());
	}
}
