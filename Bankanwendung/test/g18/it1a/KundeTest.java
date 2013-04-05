package g18.it1a;

import static org.junit.Assert.*;
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
		Konto konto1 = kunde.anlegenKonto(KontoTyp.GIROKONTO);
		Konto konto2 = kunde.anlegenKonto(KontoTyp.SPARKONTO);
		kunde.auszahlenBetrag(konto1, 100);
		kunde.auszahlenBetrag(konto2, 75);
	}

	@Test
	public void testEinzahlenBetrag() {
		fail("Not yet implemented");
	}

}
