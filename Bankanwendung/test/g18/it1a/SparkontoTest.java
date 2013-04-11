package g18.it1a;

import g18.it1a.Konto.KontoTyp;
import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

public class SparkontoTest {

	private int kontonummer;
	private KontoTyp kontotyp;
	private Sparkonto sparkonto;
	
	@Before
	public void testInstanziierung() {
		kontonummer = 13145657;
		kontotyp = KontoTyp.SPARKONTO;
		sparkonto = new Sparkonto(kontonummer, kontotyp);
	}
	
	@Test
	public void testAuszahlen() {
		sparkonto.setKontostand(100.0);
		sparkonto.ausszahlen(110.0);
		Assert.assertEquals(100.0, sparkonto.getKontostand());
		sparkonto.auszahlen(90.0);
		Assert.assertEquals(10.0, sparkonto.getKontostand());
	}
}
