package g18.it1a.test;

import static org.junit.Assert.fail;
import g18.it1a.exceptions.LiquidityException;
import g18.it1a.model.Sparkonto;
import g18.it1a.model.KontoTyp;
import junit.framework.Assert;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class SparkontoTest {

	private int kontonummer;
	private KontoTyp kontotyp;
	private Sparkonto Sparkonto;

	@Before
	public void testInstanziierung() {
		kontonummer = 13145657;
		kontotyp = KontoTyp.Sparkonto;
		Sparkonto = new Sparkonto(kontonummer, kontotyp, 0.0);
	}
	
	@Rule
	public ExpectedException exception = ExpectedException.none();

	@Test
	public void testAuszahlen() {
		Sparkonto.setKontostand(100.0);
		try {
			Sparkonto.auszahlen(110.0, "Auszahlung");
			exception.expect(LiquidityException.class);
		} catch (LiquidityException e) {
		}
		Assert.assertEquals(100.0, Sparkonto.getKontostand());
		
		try {
			Sparkonto.auszahlen(90.0, "Auszahlung");
		} catch (LiquidityException e) {
			fail("LiquidityException");
		}
		Assert.assertEquals(10.0, Sparkonto.getKontostand());
	}
}
