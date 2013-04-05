package g18.it1a;

public class Sparkonto extends Konto
{
	public Sparkonto(int kontonummer, KontoTyp kontoTyp) {
		super(kontonummer, kontoTyp);
		// TODO Auto-generated constructor stub
	}

	private int zinssatz;
	
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
