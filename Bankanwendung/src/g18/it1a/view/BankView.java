package g18.it1a.view;

import g18.it1a.model.KontoTyp;
import g18.it1a.model.Kunden;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class BankView extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JMenuBar bankMenuBar = null;
	private JMenu Anwendungen = null;
	private JMenuItem anlegenKunde = null;
	private JMenuItem anlegenKonto = null;
	private JMenuItem durchfuehrenZahlungen = null;
	private JMenuItem durchführenUeberweisungen = null;
	private JMenuItem anzeigenKontostand = null;
	private JMenuItem anzeigenKontobewegung = null;
	private JMenuItem ende = null;

	public BankView() {
		super();
		initialize();
	}

	private void initialize() {
		this.setSize(587, 456);
		this.setJMenuBar(getBankMenuBar());
		this.setContentPane(getJContentPane());
		this.setTitle("Bank Anwendung");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
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
			jContentPane.setLayout(null);
			
			JButton btnFillData = new JButton("Fill Data");
			btnFillData.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					Kunden kunden = new Kunden();
					
					kunden.anlegenKunde("hans", 1);
					kunden.anlegenKonto(1, KontoTyp.Sparkonto, 0).einzahlen(200, "test");
					kunden.anlegenKonto(1, KontoTyp.Girokonto, 0);
					
					kunden.anlegenKunde("peter", 2);
					kunden.anlegenKonto(2, KontoTyp.Sparkonto, 0);
					kunden.anlegenKonto(2, KontoTyp.Sparkonto, 0);
					
					kunden.anlegenKunde("keks", 3);
					kunden.anlegenKonto(3, KontoTyp.Girokonto, 0);
					kunden.anlegenKonto(3, KontoTyp.Girokonto, 0);
					
					kunden.anlegenKunde("klaus", 4);
					kunden.anlegenKonto(4, KontoTyp.Girokonto, 0);
					
					kunden.anlegenKunde("wurst", 5);
					kunden.anlegenKonto(5, KontoTyp.Sparkonto, 0);
					
					kunden.anlegenKunde("mustermann", 6);
					
					kunden.anlegenKunde("asdg", 7);
					kunden.anlegenKonto(7, KontoTyp.Sparkonto, 0);
					kunden.anlegenKonto(7, KontoTyp.Girokonto, 0);
					kunden.anlegenKonto(7, KontoTyp.Sparkonto, 0);
		
				}
			});
			btnFillData.setBounds(476, 363, 85, 23);
			jContentPane.add(btnFillData);
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
			Anwendungen.add(getDurchführenUeberweisungen());
			Anwendungen.add(getAnzeigenKontostand());
			Anwendungen.add(getAnzeigenKontobewegung());
			Anwendungen.add(getEnde());
			Anwendungen.insertSeparator(6);
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
			durchfuehrenZahlungen.setText("Ein-/Auszahlungen durchführen");
		}
		return durchfuehrenZahlungen;
	}

	public JMenuItem getDurchführenUeberweisungen() {
		if (durchführenUeberweisungen == null) {
			durchführenUeberweisungen = new JMenuItem();
			durchführenUeberweisungen.setText("Überweisungen durchführen");
		}
		return durchführenUeberweisungen;
	}

	public JMenuItem getAnzeigenKontostand() {
		if (anzeigenKontostand == null) {
			anzeigenKontostand = new JMenuItem();
			anzeigenKontostand.setText("Kontostandsübersicht anzeigen");
		}
		return anzeigenKontostand;
	}

	public JMenuItem getAnzeigenKontobewegung() {
		if (anzeigenKontobewegung == null) {
			anzeigenKontobewegung = new JMenuItem();
			anzeigenKontobewegung.setText("Kontobewegung anzeigen");
		}
		return anzeigenKontobewegung;
	}

	public JMenuItem getEnde() {
		if (ende == null) {
			ende = new JMenuItem();
			ende.setText("Beenden");
		}

		return ende;
	}
}
