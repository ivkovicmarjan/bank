package g18.it1a.view;

import javax.swing.SwingUtilities;
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
	private JMenu menu = null;
	private JMenuItem anlegenKunde = null;
	private JMenuItem anlegenKonto = null;
	private JMenuItem durchfuehrenZahlungen = null;
	private JMenuItem durchführenUeberweisungen = null;
	private JMenuItem anzeigenKontostand = null;
	private JMenuItem ende = null;

	private JMenuBar getBankMenuBar() {
		if (bankMenuBar == null) {
			bankMenuBar = new JMenuBar();
			bankMenuBar.add(getAnwendungen());
		}
		return bankMenuBar;
	}

	private JMenu getAnwendungen() {
		if (menu == null) {
			menu = new JMenu();
			menu.setText("Anwendungen");
			menu.add(getAnlegenKunde());
			menu.add(getAnlegenKonto());
			menu.add(getDurchfuehrenZahlungen());
			menu.add(getDurchführenUeberweisungen());
			menu.add(getAnzeigenKontostand());
			menu.add(getEnde());
			menu.insertSeparator(5);
		
		}
		return menu;
	}

	public JMenuItem getAnlegenKunde() {
		if (anlegenKunde == null) {
			anlegenKunde = new JMenuItem();
			anlegenKunde.setText("Kunde anlegen");
		}
		return anlegenKunde;
	}

	private JMenuItem getAnlegenKonto() {
		if (anlegenKonto == null) {
			anlegenKonto = new JMenuItem();
			anlegenKonto.setText("Konto anlegen");
		}
		return anlegenKonto;
	}

	private JMenuItem getDurchfuehrenZahlungen() {
		if (durchfuehrenZahlungen == null) {
			durchfuehrenZahlungen = new JMenuItem();
			durchfuehrenZahlungen.setText("Ein-/Auszahlungen durchführen");
		}
		return durchfuehrenZahlungen;
	}

	private JMenuItem getDurchführenUeberweisungen() {
		if (durchführenUeberweisungen == null) {
			durchführenUeberweisungen = new JMenuItem();
			durchführenUeberweisungen.setText("Überweisungen durchführen");
		}
		return durchführenUeberweisungen;
	}

	private JMenuItem getAnzeigenKontostand() {
		if (anzeigenKontostand == null) {
			anzeigenKontostand = new JMenuItem();
			anzeigenKontostand.setText("Kontostandsübersicht anzeigen");
		}
		return anzeigenKontostand;
	}

	private JMenuItem getEnde() {
		if (ende == null) {
			ende = new JMenuItem();
			ende.setText("Beenden");
		}
		return ende;
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				BankView thisClass = new BankView();
				thisClass.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				thisClass.setVisible(true);
			}
		});
	}

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

	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jContentPane = new JPanel();
			jContentPane.setLayout(new BorderLayout());
		}
		return jContentPane;
	}

}