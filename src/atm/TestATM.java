package atm;

import java.util.Scanner;

public class TestATM {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Account acc1 = new Account(10, "Emir", 150);
		Account acc2 = new Account(12, "Mirsad", 270);

		System.out.println(acc1.getBalance());
		acc1.deposit(111);
		System.out.println(acc1.getBalance());
		transferMoney(acc1, acc2, 500);
		System.out.println(acc1.getBalance());
		System.out.println(acc2.getBalance());
		
		System.out.println(acc1.toString());
	}

	public static void transferMoney(Account sourceAccount, Account targetAccount, double transferAmount) {
		if (sourceAccount.getBalance() < transferAmount) {
			System.out.println("Sorry, you do not have enough money in your Account.");
			return;
		}
		sourceAccount.setBalance(sourceAccount.getBalance() - transferAmount);
		targetAccount.setBalance(targetAccount.getBalance() + transferAmount);
		System.out.println("Transfer successful!");
	}

}
