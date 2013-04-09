package g18.it1a;

import junit.framework.Assert;
import g18.it1a.Konto.KontoTyp;

import org.junit.Before;
import org.junit.Test;

public class GirokontoTest {

	private int kontonummer;
	private KontoTyp kontotyp;
	private double dispo;
	private Girokonto girokonto;
	
	@Before
	public void testInstanziierung() {
		this.kontonummer = 13145657;
		this.kontotyp = KontoTyp.GIROKONTO;
		this.dispo = 150.00;
		this.girokonto = new Girokonto(kontonummer, kontotyp);
	}
	
	@Test
	public void testAuszahlen() {
		this.girokonto.setDispo(0);
		this.girokonto.auszahlen(120.00);
		Assert.assertEquals(-120.00, girokonto.getKontostand());
	}

}
