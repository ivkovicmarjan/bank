package g18.it1a;

import junit.framework.Assert;
import g18.it1a.Konto.KontoTyp;

import org.junit.Before;
import org.junit.Test;

public class KontoTest {

	Konto konto;
	int kontonummer = 12345678;
	double betrag = 150.00;
	KontoTyp kontotyp;
	
	@Before
	public void test() {
		konto = new Konto(kontonummer, KontoTyp.GIROKONTO);
	}
	
	@Test
	public void testEinzahlen() {
		konto.einzahlen(betrag);
		Assert.assertEquals(betrag, konto.getKontostand());
	}
	
	@Test
	public void testAuszahlen() {
		konto.einzahlen(150.00);
		konto.auszahlen(100.00);
		Assert.assertEquals(50.00, konto.getKontostand());
		
		konto.auszahlen(100.00);
		Assert.assertEquals(50.00, konto.getKontostand());
	}

}
