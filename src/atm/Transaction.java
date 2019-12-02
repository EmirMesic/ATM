package atm;

import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Transaction {
	public static Scanner input = new Scanner(System.in);

	public static void createAccount(ArrayList<Account> createdAccounts) throws IOException {
		System.out.println("Please input your new account details.  ");

		System.out.print("Account number:  ");
		int accountNumber = Check.accountNumberInputCheck();
		if (accountNumber == 0) {
			System.out.println("Creating new account failed, you have not entered valid account number.");
			return;
		}
		Account acc = Check.accountWithRequestedAccountNumberCheck(createdAccounts, accountNumber);
		if (acc == null) {
			System.out.print("Account owner name:  ");
			String accountOwner = input.next();
			System.out.print("Account balance:   ");
			double balance;
			boolean continueInput = true;
			String answer="";
			balance = 0;
			do {
				try {
					balance = input.nextDouble();
					if (balance < 0) {
						throw new InputMismatchException();
					}
					break;
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
			Account newAcc = new Account(accountNumber, accountOwner, balance);
			createdAccounts.add(newAcc);
			System.out.println("New account created succesfully.");
			DataExport.exportAccounts(createdAccounts);
		} else {
			System.out.println("Creating new account failed, you have entered account number that already exists.");
			return;
		}
	}

	public static void deposit(ArrayList<Account> createdAccounts) {
		System.out.print("Enter number of account you wish to deposit money to: ");
		int accountNumber = Check.accountNumberInputCheck();
		if (accountNumber == 0) {
			System.out.println("Deposit failed, you have entered invalid account number.");
			return;
		}
		Account acc = Check.accountWithRequestedAccountNumberCheck(createdAccounts, accountNumber);
		if (acc == null) {
			System.out.println("Deposit failed, you have entered invalid account number.");
			return;
		} else {
			System.out.print("Enter amount of money you wish to deposit: ");
			double amountOfMoney = Check.amountOfMoneyInputCheck();
			if (amountOfMoney == 0) {
				System.out.println("Deposit failed, you have entered invalid amount of money.");
				return;
			} else {
				acc.setBalance(acc.getBalance() + amountOfMoney);
				System.out.println("Deposit successful");
			}
		}
	}

	public static void withdrawal(ArrayList<Account> createdAccounts) {
		System.out.print("Enter number of account you wish to withdrawl money from: ");
		int accountNumber = Check.accountNumberInputCheck();
		if (accountNumber == 0) {
			System.out.println("Withdrawal failed, you have entered invalid account number.");
			return;
		}
		Account acc = Check.accountWithRequestedAccountNumberCheck(createdAccounts, accountNumber);
		if (acc == null) {
			System.out.println("Withdrawal failed, you have entered non-existing account number.");
			return;
		} else {
			System.out.print("Enter amount of money you wish to withdraw: ");
			double amountOfMoney = Check.amountOfMoneyInputCheck();
			if (amountOfMoney == 0) {
				System.out.println("Withdrawal failed, you have entered invalid amount of money.");
				return;
			} else if (acc.getBalance() < amountOfMoney) {
				System.out.println("Withdrawal failed, you do not have enough money in your account.");
				return;
			} else {
				acc.setBalance(acc.getBalance() - amountOfMoney);
				System.out.println("Withdrawal successful");
			}
		}
	}

	public static void transfer(ArrayList<Account> createdAccounts) {
		System.out.print("Enter number of account you wish to transfer money from: ");
		int sourceAccountNumber = Check.accountNumberInputCheck();
		if (sourceAccountNumber == 0) {
			System.out.println("Transfer failed, you have entered invalid source account number.");
			return;
		}
		System.out.print("Enter number of account you wish to transfer money to: ");
		int targetAccountNumber = Check.accountNumberInputCheck();
		if (targetAccountNumber == 0) {
			System.out.println("Transfer failed, you have entered invalid target account number.");
			return;
		} else if (sourceAccountNumber == targetAccountNumber) {
			System.out.println("Transfer failed, you have entered the same source and target account numbers.");
			return;
		}
		System.out.print("Enter amount of money you wish to transfer: ");
		double amountOfMoney = Check.amountOfMoneyInputCheck();
		if (amountOfMoney == 0) {
			System.out.println("Transfer failed, you have entered invalid amount of money.");
			return;
		}
		Account sourceAcc = Check.accountWithRequestedAccountNumberCheck(createdAccounts, sourceAccountNumber);
		if (sourceAcc == null) {
			System.out.println("Transfer failed, you have entered non-existing source account number.");
			return;
		}
		Account targetAcc = Check.accountWithRequestedAccountNumberCheck(createdAccounts, targetAccountNumber);
		if (targetAcc == null) {
			System.out.println("Transfer failed, you have entered non-existing target account number.");
			return;
		}
		if (sourceAcc.getBalance() < amountOfMoney) {
			System.out.println("Transfer failed, you do not have enough fund in your source account");
			return;
		} else {
			sourceAcc.setBalance(sourceAcc.getBalance() - amountOfMoney);
			targetAcc.setBalance(targetAcc.getBalance() + amountOfMoney);
			System.out.println("Transfer succesful.");
		}
	}

	// Display details for all created accounts
	public static void listOfAccounts(ArrayList<Account> createdAccounts) {
		for (Account acc : createdAccounts) {
			System.out.println(acc);
		}
	}

}
