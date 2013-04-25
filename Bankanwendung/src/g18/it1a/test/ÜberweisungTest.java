package g18.it1a.test;

import static org.junit.Assert.fail;
import junit.framework.Assert;
import g18.it1a.exceptions.�berweisungException;
import g18.it1a.model.Girokonto;
import g18.it1a.model.Konto;
import g18.it1a.model.�berweisung;
import g18.it1a.model.KontoTyp;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class �berweisungTest {

	@Rule
	public ExpectedException exception = ExpectedException.none();

	@Test
	public void test�berweiung() {
		Konto quelle = new Girokonto(1, KontoTyp.Girokonto, 0.0);
		Konto ziel = new Girokonto(1, KontoTyp.Girokonto, 0.0);
		quelle.einzahlen(100);
		�berweisung �berweisung = new �berweisung(quelle, ziel, 50, null);
		try {
			�berweisung.durchf�hren�berweisung();
		} catch (�berweisungException e) {
			fail("Nicht gen�gend Geld Exception!");
		}
		int actual = (int) ziel.getKontostand();
		int expected = 50;

		Assert.assertEquals(expected, actual);

		�berweisung �berweisungFehler = new �berweisung(quelle, ziel, 100, null);

		try {
			�berweisungFehler.durchf�hren�berweisung();
			exception.expect(�berweisungException.class);
		} catch (�berweisungException e) {
		}

	}
}
