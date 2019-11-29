package atm;

import java.util.ArrayList;
import java.util.Scanner;

public class Actions {
	public static Scanner input = new Scanner(System.in);

	public static void createAccount(ArrayList<Account> createdAccounts) {
		System.out.println("Please input your new account details.  ");

		System.out.print("Account number:  ");
		int accountNumber = input.nextInt();
		System.out.print("Account owner name:  ");
		String accountOwner = input.next();
		System.out.print("Account balance:   ");
		double balance = input.nextDouble();

		Account acc = new Account(accountNumber, accountOwner, balance);
		createdAccounts.add(acc);
	}
	
	public static void deposit(ArrayList<Account> createdAccounts) {
		System.out.print("Enter number of account you wish to deposit money to: ");
		int accountNumber = input.nextInt();
		System.out.print("Enter amount of money you wish to deposit: ");
		double amountOfMoney = input.nextDouble();
		for(int i=0; i<createdAccounts.size(); i++) {
			if(createdAccounts.get(i).getAccountNumber()==accountNumber) {
				createdAccounts.get(i).setBalance(createdAccounts.get(i).getBalance() + amountOfMoney);
			}
		}
	}
	
	public static void withdrawal(ArrayList<Account> createdAccounts) {
		System.out.print("Enter number of account you wish to withdrawl money from: ");
		int accountNumber = input.nextInt();
		System.out.print("Enter amount of money you wish to withdrawl: ");
		double amountOfMoney = input.nextDouble();
		for(int i=0; i<createdAccounts.size(); i++) {
			if(createdAccounts.get(i).getAccountNumber()==accountNumber) {
				createdAccounts.get(i).setBalance(createdAccounts.get(i).getBalance() - amountOfMoney);
			}
		}
	}
	
	public static void transfer(ArrayList<Account> createdAccounts) {
		System.out.print("Enter number of account you wish to transfer money from: ");
		int sourceAccount = input.nextInt();
		System.out.print("Enter number of account you wish to transfer money to: ");
		int targetAccount = input.nextInt();
		System.out.print("Enter amount of money you wish to transfer: ");
		double amountOfMoney = input.nextDouble();
		for(int i=0; i<createdAccounts.size(); i++) {
			if(createdAccounts.get(i).getAccountNumber()==sourceAccount) {
				createdAccounts.get(i).setBalance(createdAccounts.get(i).getBalance() - amountOfMoney);
			}
			if(createdAccounts.get(i).getAccountNumber()==targetAccount) {
				createdAccounts.get(i).setBalance(createdAccounts.get(i).getBalance() + amountOfMoney);
			}
		}
	}

	public static void listOfAccounts(ArrayList<Account> createdAccounts) {
		for (Account acc : createdAccounts) {
			System.out.println(acc);
		}
	}
	

	

	
	
}
