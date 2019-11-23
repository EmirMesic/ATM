package atm;

public class Account {

	private int accountNumber;
	private String accountOwner;
	private double balance;

	Account() {

	}

	Account(int accountNumber, String accountOwner, double balance) {
		this.accountNumber = accountNumber;
		this.accountOwner = accountOwner;
		this.balance = balance;
	}

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

	public String toString() {
		return "Account number: " + accountNumber + " | " + "Account owner: " + accountOwner + " | "
				+ "Current balance: " + balance;
	}

}
