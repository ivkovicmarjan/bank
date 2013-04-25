package g18.it1a.test;

import static org.junit.Assert.fail;
import junit.framework.Assert;
import g18.it1a.exceptions.LiquidityException;
import g18.it1a.model.Girokonto;
import g18.it1a.model.Konto;
import g18.it1a.model.Überweisung;
import g18.it1a.model.KontoTyp;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class ÜberweisungTest {

	@Rule
	public ExpectedException exception = ExpectedException.none();

	@Test
	public void testÜberweiung() {
		Konto quelle = new Girokonto(1, KontoTyp.Girokonto, 0.0);
		Konto ziel = new Girokonto(1, KontoTyp.Girokonto, 0.0);
		quelle.einzahlen(100, "Einzahlung");
		Überweisung überweisung = new Überweisung(quelle, ziel, 50, null);
		try {
			überweisung.durchführenÜberweisung();
		} catch (LiquidityException e) {
			fail("Nicht genügend Geld Exception!");
		}
		int actual = (int) ziel.getKontostand();
		int expected = 50;

		Assert.assertEquals(expected, actual);

		Überweisung überweisungFehler = new Überweisung(quelle, ziel, 100, null);

		try {
			überweisungFehler.durchführenÜberweisung();
			exception.expect(LiquidityException.class);
		} catch (LiquidityException e) {
		}

	}
}
