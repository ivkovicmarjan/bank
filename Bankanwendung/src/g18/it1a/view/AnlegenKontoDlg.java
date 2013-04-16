package g18.it1a.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class AnlegenKontoDlg extends JDialog {

	private static final long serialVersionUID = 1L;

	private final JPanel contentPanel = new JPanel();
	private JButton anlegenButton;
	private JButton beendenButton;
	private ButtonGroup buttonGroup;
	private JRadioButton giroButton;
	private JRadioButton sparButton;
	private JTextField kundenNummerFeld;

	public AnlegenKontoDlg(BankView bankView, boolean b) {
		setTitle("Konto anlegen");
		setSize(250, 200);
		setVisible(true);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JLabel lblKontotyp = new JLabel("Kontotyp:");
		lblKontotyp.setBounds(10, 16, 79, 14);
		contentPanel.add(lblKontotyp);

		buttonGroup = new ButtonGroup();
		
		giroButton = new JRadioButton();
		giroButton.setText("Girokonto");
		giroButton.setBounds(105, 10, 100, 15);
		giroButton.setActionCommand("Girokonto");
		buttonGroup.add(giroButton);
		
		sparButton = new JRadioButton();
		sparButton.setText("Sparkonto");
		sparButton.setBounds(105, 25, 100, 15);
		sparButton.setActionCommand("Sparkonto");
		buttonGroup.add(sparButton);
		
		contentPanel.add(giroButton);
		contentPanel.add(sparButton);
		
		
		JLabel lblNewLabel = new JLabel("Kundennummer:");
		lblNewLabel.setBounds(10, 62, 97, 14);
		contentPanel.add(lblNewLabel);
		
		kundenNummerFeld = new JTextField();
		kundenNummerFeld.setBounds(109, 59, 115, 20);
		contentPanel.add(kundenNummerFeld);
		kundenNummerFeld.setColumns(1);

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
	
	public JTextField getKundenNummerFeld() {
		return kundenNummerFeld;
	}
	
	public ButtonGroup getButtonGroup() {
		return buttonGroup;
	}

	public JRadioButton getGiroButton() {
		return giroButton;
	}

	public JRadioButton getSparButton() {
		return sparButton;
	}
}
