package atm;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;



public class Actions {
	public static Scanner input = new Scanner(System.in);

	public static void createAccount(ArrayList<Account> createdAccounts) {
		System.out.println("Please input your new account details.  ");

		System.out.print("Account number:  ");
		int accountNumber = accountNumberInputCheck();
		for (int i = 0; i < createdAccounts.size(); i++) {
			if (createdAccounts.get(i).getAccountNumber() == accountNumber) {
				System.out.println("Creating new account failed, you have entered an existing account number.");
				return;
			}
		}
		System.out.print("Account owner name:  ");
		String accountOwner = input.next();
		System.out.print("Account balance:   ");
		double balance = amountOfMoneyInputCheck();

		Account acc = new Account(accountNumber, accountOwner, balance);
		createdAccounts.add(acc);
	}
	
//	public static void saveTransaction() {
//		
//	}

	public static void deposit(ArrayList<Account> createdAccounts) {
		System.out.print("Enter number of account you wish to deposit money to: ");
		int accountNumber = accountNumberInputCheck();
		for (int i = 0; i < createdAccounts.size(); i++) {
			if (createdAccounts.get(i).getAccountNumber() == accountNumber) {
				System.out.print("Enter amount of money you wish to deposit: ");
				double amountOfMoney = input.nextDouble();
				if (amountOfMoney > 0) {
					createdAccounts.get(i).setBalance(createdAccounts.get(i).getBalance() + amountOfMoney);
					System.out.println("Deposit successful");
				} else {
					System.out.println("Deposit failed, you have entered invalid amount of money.");
					return;
				}
			} else {
				System.out.println("Deposit failed, you have entered non-existent account number.");
				return;
			}
		}
	}

	public static void withdrawal(ArrayList<Account> createdAccounts) {
		System.out.print("Enter number of account you wish to withdrawl money from: ");
		int accountNumber = accountNumberInputCheck();
		for (int i = 0; i < createdAccounts.size(); i++) {
			if (createdAccounts.get(i).getAccountNumber() == accountNumber) {
				System.out.print("Enter amount of money you wish to withdraw: ");
				double amountOfMoney = amountOfMoneyInputCheck();
				if (amountOfMoney > 0 && createdAccounts.get(i).getBalance() > amountOfMoney) {
					createdAccounts.get(i).setBalance(createdAccounts.get(i).getBalance() - amountOfMoney);
					System.out.println("Withdrawal successful");
				} else if (amountOfMoney <= 0) {
					System.out.println("Withdrawal failed, you have entered invalid amount of money.");
					return;
				} else if (createdAccounts.get(i).getBalance() > amountOfMoney) {
					System.out.println("Withdrawal failed, you do not have enough money in your account.");
					return;
				}
			} else {
				System.out.println("Withdrawal failed, you have entered non-existent account number.");
				return;
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
		for (int i = 0; i < createdAccounts.size(); i++) {
			if (createdAccounts.get(i).getAccountNumber() == sourceAccount) {
				createdAccounts.get(i).setBalance(createdAccounts.get(i).getBalance() - amountOfMoney);
			}
		}
		for (int i = 0; i < createdAccounts.size(); i++) {
			if (createdAccounts.get(i).getAccountNumber() == targetAccount) {
				createdAccounts.get(i).setBalance(createdAccounts.get(i).getBalance() + amountOfMoney);
			}
		}
	}
	
	// Display details for all created accounts
	public static void listOfAccounts(ArrayList<Account> createdAccounts) {
		for (Account acc : createdAccounts) {
			System.out.println(acc);
		}
	}
	
	// Methods handling input with exceptions
	public static int accountNumberInputCheck() {
		boolean continueInput = true;
		int inputNumber=0;
		String answer= "";
		
		do {
			try {
				inputNumber = input.nextInt();
				if (inputNumber <= 0) {
					throw new InputMismatchException();
				}
				return inputNumber;
			} catch (InputMismatchException ex) {
				input.nextLine();
				System.out.println("You have not entered a valid number. Do you want to try again?" 
						+ "\nPress any key to continue or press 'N' to exit.");
				answer = input.next();
				if (answer.charAt(0) == 'n' || answer.charAt(0) == 'N') {
					continueInput = false;
					break;
				}
				System.out.print("Enter account number:");
			}
		} while (continueInput);
		return inputNumber;
	}
	
	public static double amountOfMoneyInputCheck() {
		boolean continueInput = true;
		double inputNumber=0;
		String answer= "";
		
		do {
			try {
				inputNumber = input.nextDouble();
				if (inputNumber <= 0) {
					throw new InputMismatchException();
				}
				return inputNumber;
			} catch (InputMismatchException ex) {
				input.nextLine();
				System.out.println("You have not entered a valid number. Do you want to try again?" 
						+ "\nPress any key to continue or press 'N' to exit.");
				answer = input.next();
				if (answer.charAt(0) == 'n' || answer.charAt(0) == 'N') {
					continueInput = false;
					break;
				}
				System.out.print("Enter amount of money:");
			}
		} while (continueInput);
		return inputNumber;
	}



}
