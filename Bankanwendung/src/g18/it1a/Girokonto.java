package g18.it1a;

public class Girokonto extends Konto
{
	public Girokonto(int kontonummer, KontoTyp kontoTyp) {
		super(kontonummer, kontoTyp);
		// TODO Auto-generated constructor stub
	}

	private int dispo;
	
	public int getDispo() {
		return this.dispo;
	}

	public void setDispo(int dispo) {
		this.dispo = dispo;
	}
	
	public void operation(){
		
	}
}
