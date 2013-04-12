package g18.it1a.controller;


public class Bank {
	private CtlBankView ctlBankView;
	private BankHandler bankHandler;

	public Bank() {
	}

	public static void main(String[] args) {
		new Bank().start();
	}

	public void start() {
		ctlBankView = new CtlBankView();
		bankHandler = new BankHandler();
		ctlBankView.startBankView(bankHandler);
	}
}
