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
import javax.swing.AbstractListModel;
import javax.swing.JTextField;

public class AnlegenKontoDlg extends JDialog {

	private static final long serialVersionUID = 1L;

	private final JPanel contentPanel = new JPanel();
	private JButton anlegenButton;
	private JButton beendenButton;
	private JList list;
	private JTextField textField;

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

		list = new JList();
		list.setBounds(109, 11, 115, 37);
		list.setModel(new AbstractListModel() {
			private static final long serialVersionUID = 1L;
			String[] values = new String[] {"Girokonto", "Sparkonto"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		list.setEnabled(true);
		
		contentPanel.add(list);
		
		JLabel lblNewLabel = new JLabel("Kundennummer:");
		lblNewLabel.setBounds(10, 62, 97, 14);
		contentPanel.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(109, 59, 115, 20);
		contentPanel.add(textField);
		textField.setColumns(1);

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
	
	public JList getList() {
		return list;
	}
	
	public JTextField getTextfield() {
		return textField;
	}
}
