package g18.it1a.test;

import junit.framework.Assert;
import g18.it1a.model.Girokonto;
import g18.it1a.model.Konto.KontoTyp;

import org.junit.Before;
import org.junit.Test;

public class GirokontoTest {

	private int kontonummer;
	private KontoTyp kontotyp;
	private Girokonto girokonto;
	
	@Before
	public void testInstanziierung() {
		kontonummer = 13145657;
		kontotyp = KontoTyp.GIROKONTO;
		girokonto = new Girokonto(kontonummer, kontotyp, 0.0);
	}
	
	@Test
	public void testAuszahlen() {
		girokonto.setDispo(0);
		girokonto.auszahlen(120.00);
		Assert.assertEquals(0.0, girokonto.getKontostand());
		girokonto.setDispo(100);
		girokonto.auszahlen(90);
		Assert.assertEquals(-90.0, girokonto.getKontostand());
	}

}
