package g18.it1a;

import java.util.List;

public class Kunde {
	
	private String name;
	private int kundenNummer;
	private List<Konto> konten;

	public Kunde(String kundenName, int kundenNummer) {
		setName(kundenName);
		this.setKundenNummer(kundenNummer);
	}

	public String anzeigenKontostandsUebersicht() {
		String ausgabe = null;
		for (Konto k: konten) {
			ausgabe = ausgabe + k.toString() + "\n\n";
		}
		return ausgabe;
	}

	public Konto anlegenKonto(Enum<?> gIROKONTO) {
		// TODO Auto-generated method stub
		return null;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getKundenNummer() {
		return kundenNummer;
	}

	public void setKundenNummer(int kundenNummer) {
		this.kundenNummer = kundenNummer;
	}

	public List<Konto> getKonten() {
		return konten;
	}

	public void setKonten(List<Konto> konten) {
		this.konten = konten;
	}

}
