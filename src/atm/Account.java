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

	// Methods
	public void deposit(double amountOfMoney) {
		this.balance += amountOfMoney;
	}

	public void withdrawal(double amountOfMoney) {

		if (this.balance >= amountOfMoney) {
			this.balance -= amountOfMoney;
			System.out.println("Withdrawal completed, your current balance is: " + this.balance);
		} else {
			System.out.println("Sorry, you do not have enough money in your Account.");
		}
	}
	
	// Printing Account Details method
	public String toString() {
		return "Account number: " + accountNumber + " | " + "Account owner: " + accountOwner + " | "
				+ "Current balance: " + balance;
	}
	
	// getters and setters
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


}
