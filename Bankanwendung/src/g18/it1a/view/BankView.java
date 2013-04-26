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
import javax.swing.JLabel;

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
	private JLabel lblTest;

	public BankView() {
		super();
		initialize();
	}

	private void initialize() {
		this.setSize(500, 400);
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
					kunden.anlegenKonto(1, KontoTyp.Sparkonto, 0).einzahlen(1243, "Anfangsguthaben");
					kunden.anlegenKonto(1, KontoTyp.Girokonto, 0).einzahlen(5345, "Anfangsguthaben");
					
					kunden.anlegenKunde("peter", 2);
					kunden.anlegenKonto(2, KontoTyp.Sparkonto, 0).einzahlen(1235, "Anfangsguthaben");
					kunden.anlegenKonto(2, KontoTyp.Sparkonto, 0).einzahlen(5, "Anfangsguthaben");
					
					kunden.anlegenKunde("keks", 3);
					kunden.anlegenKonto(3, KontoTyp.Girokonto, 0).einzahlen(123, "Anfangsguthaben");
					kunden.anlegenKonto(3, KontoTyp.Girokonto, 0).einzahlen(23423, "Anfangsguthaben");
					
					kunden.anlegenKunde("klaus", 4);
					kunden.anlegenKonto(4, KontoTyp.Girokonto, 0).einzahlen(5553, "Anfangsguthaben");
					
					kunden.anlegenKunde("wurst", 5);
					kunden.anlegenKonto(5, KontoTyp.Sparkonto, 0).einzahlen(1233, "Anfangsguthaben");
					
					kunden.anlegenKunde("mustermann", 6);
					
					kunden.anlegenKunde("asdg", 7);
					kunden.anlegenKonto(7, KontoTyp.Sparkonto, 0).einzahlen(1337, "Anfangsguthaben");
					kunden.anlegenKonto(7, KontoTyp.Girokonto, 0).einzahlen(534, "Anfangsguthaben");
					kunden.anlegenKonto(7, KontoTyp.Sparkonto, 0).einzahlen(343451, "Anfangsguthaben");
		
				}
			});
			btnFillData.setBounds(476, 363, 85, 23);
			jContentPane.add(btnFillData);
			jContentPane.add(getLblTest());
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
	private JLabel getLblTest() {
		if (lblTest == null) {
			lblTest = new JLabel("Erstellt von: Mike Kudla, Kai-Oliver Nießen, Alissa Rauhe und Leonard Thoma");
			lblTest.setBounds(77, 159, 456, 33);
		}
		return lblTest;
	}
}
