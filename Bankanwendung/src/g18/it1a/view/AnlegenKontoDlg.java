package g18.it1a.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JList;

public class AnlegenKontoDlg extends JDialog {

	private static final long serialVersionUID = 1L;

	private final JPanel contentPanel = new JPanel();
	private JButton anlegenButton;
	private JButton beendenButton;

	public AnlegenKontoDlg(BankView bankView, boolean b) {
		setTitle("Konto anlegen");
		setSize(200, 200);
		setVisible(true);
		setModal(true);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);

		JLabel lblKontotyp = new JLabel("Kontotyp:");
		contentPanel.add(lblKontotyp);

		JList list = new JList();
		list.setEnabled(true);
		list.setVisibleRowCount(2);
		list.add(new JLabel("Girokonto"), "Girokonto");
		list.add(new JLabel("Sparkonto"), "Sparkonto");
		contentPanel.add(list);

		JPanel buttonPane = new JPanel();
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(buttonPane, BorderLayout.SOUTH);

		anlegenButton = new JButton("Anlegen");
		buttonPane.add(anlegenButton);
		getRootPane().setDefaultButton(anlegenButton);

		beendenButton = new JButton("Beenden");
		buttonPane.add(beendenButton);

	}

	public JButton getAnlegenButton() {
		return anlegenButton;
	}

	public JButton getBeendenButton() {
		return beendenButton;
	}
}
