package g18.it1a.test;

import junit.framework.Assert;
import g18.it1a.model.Girokonto;
import g18.it1a.model.Konto;
import g18.it1a.model.Konto.KontoTyp;

import org.junit.Before;
import org.junit.Test;

public class KontoTest {

	private Konto konto;
	private int kontonummer = 12345678;
	private double betrag = 150.00;
	
	@Before
	public void test() {
		this.konto = new Girokonto(kontonummer, KontoTyp.GIROKONTO, 0);
	}
	
	@Test
	public void testEinzahlen() {
		this.konto.einzahlen(this.betrag);
		Assert.assertEquals(this.betrag, this.konto.getKontostand());
	}
	
	@Test
	public void testAuszahlen() {
		this.konto.einzahlen(150.00);
		this.konto.auszahlen(100.00);
		Assert.assertEquals(50.00, this.konto.getKontostand());
		
		this.konto.auszahlen(100.00);
		Assert.assertEquals(50.00, this.konto.getKontostand());
	}

}
