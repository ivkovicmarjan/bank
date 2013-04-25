package g18.it1a.test;

import static org.junit.Assert.fail;
import junit.framework.Assert;
import g18.it1a.exceptions.LiquidityException;
import g18.it1a.model.Girokonto;
import g18.it1a.model.Konto;
import g18.it1a.model.KontoTyp;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class KontoTest {

	private Konto konto;
	private int kontonummer = 12345678;
	private double betrag = 150.00;

	@Before
	public void test() {
		this.konto = new Girokonto(kontonummer, KontoTyp.Girokonto, 0);
	}
	
	@Rule
	public ExpectedException exception = ExpectedException.none();

	@Test
	public void testEinzahlen() {
		this.konto.einzahlen(this.betrag, "Einzahlung");
		Assert.assertEquals(this.betrag, this.konto.getKontostand());
	}

	@Test
	public void testAuszahlen() {
		konto.einzahlen(150.00, "Einzahlung");
		try {
			konto.auszahlen(100.00, "Auszahlung");
		} catch (LiquidityException e) {
			fail("LiquidityException");
		}
		Assert.assertEquals(50.00, this.konto.getKontostand());

		try {
			konto.auszahlen(100.00, "Auszahlung");
			exception.expect(LiquidityException.class);
		} catch (LiquidityException e) {
		}
		Assert.assertEquals(50.00, this.konto.getKontostand());
	}

}
