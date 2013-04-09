package g18.it1a;

public class Sparkonto extends Konto
{
	private int zinssatz;
	
	public Sparkonto(int kontonummer, KontoTyp kontoTyp) {
		super(kontonummer, kontoTyp);

	}
	
	public int getZinssatz() {
		return this.zinssatz;
	}

	public void setZinssatz(int zinssatz) {
		this.zinssatz = zinssatz;
	}
	
	public int ausszahlen(){
		return 0;
	}
}
