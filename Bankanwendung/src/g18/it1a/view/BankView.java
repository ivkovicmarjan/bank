package g18.it1a.view;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class BankView extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JMenuBar bankMenuBar = null;
	private JMenu Anwendungen = null;
	private JMenuItem anlegenKunde = null;
	private JMenuItem anlegenKonto = null;
	private JMenuItem durchfuehrenZahlungen = null;
	private JMenuItem durchf�hrenUeberweisungen = null;
	private JMenuItem anzeigenKontostand = null;
	private JMenuItem ende = null;
	private JMenuItem �berweisungDurchf�hren = null;

	public BankView() {
		super();
		initialize();
	}

	private void initialize() {
		this.setSize(587, 456);
		this.setJMenuBar(getBankMenuBar());
		this.setContentPane(getJContentPane());
		this.setTitle("Bank-Anwendung");
	}

	private JMenuBar getBankMenuBar() {
		if (bankMenuBar == null) {
			bankMenuBar = new JMenuBar();
			bankMenuBar.add(getAnwendungen());
		}
		return bankMenuBar;
	}

	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jContentPane = new JPanel();
			jContentPane.setLayout(new BorderLayout());
		}
		return jContentPane;
	}

	private JMenu getAnwendungen() {
		if (Anwendungen == null) {
			Anwendungen = new JMenu();
			Anwendungen.setText("Anwendungen");
			Anwendungen.add(getAnlegenKunde());
			Anwendungen.add(getAnlegenKonto());
			Anwendungen.add(getDurchfuehrenZahlungen());
			Anwendungen.add(getDurchf�hrenUeberweisungen());
			Anwendungen.add(getAnzeigenKontostand());
			Anwendungen.add(getEnde());
			Anwendungen.insertSeparator(5);
		}
		return Anwendungen;
	}

	public JMenuItem getAnlegenKunde() {
		if (anlegenKunde == null) {
			anlegenKunde = new JMenuItem();
			anlegenKunde.setText("Kunde anlegen");
		}
		return anlegenKunde;
	}

	public JMenuItem getAnlegenKonto() {
		if (anlegenKonto == null) {
			anlegenKonto = new JMenuItem();
			anlegenKonto.setText("Konto anlegen");
		}
		return anlegenKonto;
	}

	public JMenuItem getDurchfuehrenZahlungen() {
		if (durchfuehrenZahlungen == null) {
			durchfuehrenZahlungen = new JMenuItem();
			durchfuehrenZahlungen.setText("Ein-/Auszahlungen durchf�hren");
		}
		return durchfuehrenZahlungen;
	}

	public JMenuItem getDurchf�hrenUeberweisungen() {
		if (durchf�hrenUeberweisungen == null) {
			durchf�hrenUeberweisungen = new JMenuItem();
			durchf�hrenUeberweisungen.setText("�berweisungen durchf�hren");
		}
		return durchf�hrenUeberweisungen;
	}

	public JMenuItem getAnzeigenKontostand() {
		if (anzeigenKontostand == null) {
			anzeigenKontostand = new JMenuItem();
			anzeigenKontostand.setText("Kontostands�bersicht anzeigen");
		}
		return anzeigenKontostand;
	}

	public JMenuItem getEnde() {
		if (ende == null) {
			ende = new JMenuItem();
			ende.setText("Beenden");
		}
		
		return ende;
	}
}
