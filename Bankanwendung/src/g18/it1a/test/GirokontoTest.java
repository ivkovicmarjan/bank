package g18.it1a.test;

import static org.junit.Assert.fail;
import junit.framework.Assert;
import g18.it1a.exceptions.LiquidityException;
import g18.it1a.model.Girokonto;
import g18.it1a.model.KontoTyp;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class GirokontoTest {

	private int kontonummer;
	private KontoTyp kontotyp;
	private Girokonto girokonto;
	
	@Before
	public void testInstanziierung() {
		kontonummer = 13145657;
		kontotyp = KontoTyp.Girokonto;
		girokonto = new Girokonto(kontonummer, kontotyp, 0.0);
	}
	
	@Rule
	public ExpectedException exception = ExpectedException.none();
	
	@Test
	public void testAuszahlen() {
		girokonto.setDispo(0);
		try {
			girokonto.auszahlen(120.00, "Auszahlung");
			exception.expect(LiquidityException.class);
		} catch (LiquidityException e) {
		}
		Assert.assertEquals(0.0, girokonto.getKontostand());
		girokonto.setDispo(100);
		try {
			girokonto.auszahlen(90, "Auszahlung");
		} catch (LiquidityException e) {
			fail("LiquidityException");
		}
		Assert.assertEquals(-90.0, girokonto.getKontostand());
	}

}
