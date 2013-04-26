package g18.it1a.test;

import g18.it1a.model.Konto;
import g18.it1a.model.KontoTyp;
import g18.it1a.model.Kunde;
import g18.it1a.model.Überweisung;
import java.util.Date;
import java.util.Scanner;

public class Bank {
	public static void main(String[] args) {
		try {
			Scanner sc = new Scanner(System.in);
			System.out.print("Bitte Kundennummer eingeben: ");
			int kundenNummer = sc.nextInt();
			System.out.print("Bitte Kundenname eingeben: ");
			String kundenName = sc.next();
			System.out.print("Bitte Kundenvorname eingeben: ");
			kundenName = sc.next() + " " + kundenName;
			sc.close();
			Kunde kunde1 = new Kunde(kundenName, kundenNummer);

			Konto konto1 = kunde1.anlegenKonto(KontoTyp.Girokonto);
			Konto konto2 = kunde1.anlegenKonto(KontoTyp.Sparkonto);
			System.out.println("(1) " + kunde1.anzeigenKontostandsUebersicht());
			konto1.einzahlen(1000, "Einzahlung");
			System.out.println("(2) " + kunde1.anzeigenKontostandsUebersicht());
			konto2.einzahlen(100, "Einzahlung");
			System.out.println("(3) " + kunde1.anzeigenKontostandsUebersicht());
			konto1.auszahlen(400, "Auszahlung");
			System.out.println("(4) " + kunde1.anzeigenKontostandsUebersicht());
			konto2.auszahlen(100, "Auszahlung");
			System.out.println("(5) " + kunde1.anzeigenKontostandsUebersicht());

			Überweisung ueb = new Überweisung(konto1, konto2, 25, new Date());
			ueb.durchführenÜberweisung();
			System.out.println("(6) " + kunde1.anzeigenKontostandsUebersicht());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
