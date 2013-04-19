package g18.it1a.test;

import junit.framework.Assert;
import g18.it1a.model.Girokonto;
import g18.it1a.model.Konto;
import g18.it1a.model.Überweisung;
import g18.it1a.model.KontoTyp;

import org.junit.Test;

public class ÜberweisungTest {

	@Test
	public void KannÜberweiungDurchführen() 
	{
		Konto quelle = new Girokonto(1, KontoTyp.Girokonto, 0.0);
		Konto ziel = new Girokonto(1, KontoTyp.Girokonto, 0.0);
		quelle.einzahlen(100);
		ziel.einzahlen(50);
		Überweisung ueberweisung = new Überweisung(quelle, ziel, 50, null);
		ueberweisung.durchfuehrenUeberweisung();
		int actual = (int) ziel.getKontostand();
		int expected = 100;
	
		Assert.assertEquals(expected, actual);
	}
}
