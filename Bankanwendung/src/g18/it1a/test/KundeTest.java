package g18.it1a.test;

import static org.junit.Assert.*;

import java.util.HashMap;

import junit.framework.Assert;
import g18.it1a.exceptions.LiquidityException;
import g18.it1a.model.Konto;
import g18.it1a.model.Kunde;
import g18.it1a.model.KontoTyp;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class KundeTest {

	private Kunde kunde;

	@Before
	public void setUp() throws Exception {
		kunde = new Kunde("Max Mustermann", 1);
	}

	@Rule
	public ExpectedException exception = ExpectedException.none();

	@Test
	public void testKunde() {
		Kunde kunde2 = new Kunde("John Doe", 2);
		assertEquals("John Doe", kunde2.getName());
		assertEquals(2, kunde2.getKundenNummer());
		assertEquals(new HashMap<Integer, Konto>(), kunde2.getKonten());
	}

	@Test
	public void testAnzeigenKontostandsUebersicht() {
		assertEquals("keine Konten vorhanden", kunde.anzeigenKontostandsUebersicht());
		kunde.anlegenKonto(KontoTyp.Girokonto);
		kunde.anlegenKonto(KontoTyp.Sparkonto);
		String ausgabe = "Übersicht der Konten von Max Mustermann:\n" + "Kontonummer: 100002, Kontostand: 0.0, Kontotyp: Sparkonto\n"
				+ "Kontonummer: 101001, Kontostand: 0.0, Kontotyp: Girokonto\n";

		assertEquals(ausgabe, kunde.anzeigenKontostandsUebersicht());
	}

	@Test
	public void testAnlegenKonto() {
		Konto konto = kunde.anlegenKonto(KontoTyp.Sparkonto);
		konto.einzahlen(42, "Einzahlung");
		Assert.assertEquals(42.0, konto.getKontostand());
	}

	@Test
	public void testAuszahlenBetrag() {
		Konto girokonto = kunde.anlegenKonto(KontoTyp.Girokonto);
		girokonto.einzahlen(100, "Einzahlung");
		try {
			kunde.auszahlenBetrag(girokonto, 100);
		} catch (LiquidityException e) {
			fail("LiquidityException");
		}
		Assert.assertEquals(0.0, girokonto.getKontostand());

		try {
			kunde.auszahlenBetrag(girokonto, 100);
			exception.expect(LiquidityException.class);
		} catch (LiquidityException e) {
		}
		Assert.assertEquals(0.0, girokonto.getKontostand());

		Konto Sparkonto = kunde.anlegenKonto(KontoTyp.Sparkonto);
		Sparkonto.einzahlen(200, "Einzahlung");
		try {
			kunde.auszahlenBetrag(Sparkonto, 75);
		} catch (LiquidityException e) {
			fail("LiquidityException");
		}
		Assert.assertEquals(125.0, Sparkonto.getKontostand());
		try {
			kunde.auszahlenBetrag(Sparkonto, 475);
			exception.expect(LiquidityException.class);
		} catch (LiquidityException e) {
		}
		Assert.assertEquals(125.0, Sparkonto.getKontostand());

	}

	@Test
	public void testEinzahlenBetrag() {
		Konto girokonto = kunde.anlegenKonto(KontoTyp.Girokonto);
		kunde.einzahlenBetrag(girokonto, 100.0);
		Assert.assertEquals(100.0, girokonto.getKontostand());

		Konto Sparkonto = kunde.anlegenKonto(KontoTyp.Sparkonto);
		kunde.einzahlenBetrag(Sparkonto, 100.0);
		Assert.assertEquals(100.0, Sparkonto.getKontostand());
	}

}
