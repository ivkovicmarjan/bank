package g18.it1a;

import static org.junit.Assert.*;
import junit.framework.Assert;
import g18.it1a.Konto.KontoTyp;

import org.junit.Before;
import org.junit.Test;

public class KundeTest {
	
	private Kunde kunde;

	@Before
	public void setUp() throws Exception {
		kunde = new Kunde("Max Mustermann", 1);
	}

	@Test
	public void testKunde() {
		fail("Not yet implemented");
	}

	@Test
	public void testAnzeigenKontostandsUebersicht() {
		assertEquals("keine Konten vorhanden", kunde.anzeigenKontostandsUebersicht() );
		kunde.anlegenKonto(KontoTyp.GIROKONTO);
		kunde.anlegenKonto(KontoTyp.SPARKONTO);
		assertEquals("keine Konten vorhanden", kunde.anzeigenKontostandsUebersicht() );
	}

	@Test
	public void testAnlegenKonto() {
		
	}

	@Test
	public void testAuszahlenBetrag() {
		Konto girokonto = kunde.anlegenKonto(KontoTyp.GIROKONTO);
		girokonto.einzahlen(100);
		kunde.auszahlenBetrag(girokonto, 100);
		Assert.assertEquals(0, girokonto.getKontostand());
				
		Konto sparkonto = kunde.anlegenKonto(KontoTyp.SPARKONTO);
		kunde.auszahlenBetrag(sparkonto, 75);
	}

	@Test
	public void testEinzahlenBetrag() {
		fail("Not yet implemented");
	}

}
