package g18.it1a;

import junit.framework.Assert;
import g18.it1a.Konto.KontoTyp;

import org.junit.Before;
import org.junit.Test;

public class GirokontoTest {

	int kontonummer;
	KontoTyp kontotyp;
	double dispo;
	Girokonto girokonto;
	
	@Before
	public void test() {
		kontonummer = 13145657;
		kontotyp = KontoTyp.GIROKONTO;
		dispo = 150.00;
		girokonto = new Girokonto(kontonummer, kontotyp);
	}
	
	@Test
	public void testAuszahlen() {
		girokonto.auszahlen(120.00);
		Assert.assertEquals(-120.00, girokonto.getKontostand());
	}

}
