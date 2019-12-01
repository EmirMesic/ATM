package atm;

public class Account {

	// Data fields
	private int accountNumber;
	private String accountOwner;
	private double balance;

	// Constructors
	Account() {

	}

	Account(int accountNumber, String accountOwner, double balance) {
		this.accountNumber = accountNumber;
		this.accountOwner = accountOwner;
		this.balance = balance;
	}

	// Getters and setters
	public int getAccountNumber() {
		return this.accountNumber;
	}

	public String getAccountOwner() {
		return this.accountOwner;
	}

	public double getBalance() {
		return this.balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	// Printing Account Details method
	public String toString() {
		return "Account number: " + accountNumber + " | " + "Account owner: " + accountOwner + " | "
				+ "Current balance: " + balance;
	}

}
