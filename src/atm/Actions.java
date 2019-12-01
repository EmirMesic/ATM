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
		if (accountNumber == 0) {
			System.out.println("Creating new account failed, you have not entered valid account number.");
			return;
		}
		Account acc = findAccountWithRequestedAccountNumber(createdAccounts, accountNumber);
		if (acc == null) {
			System.out.print("Account owner name:  ");
			String accountOwner = input.next();
			System.out.print("Account balance:   ");
			double balance = amountOfMoneyInputCheck();

			Account newAcc = new Account(accountNumber, accountOwner, balance);
			createdAccounts.add(newAcc);
			System.out.println("New account created succesfully.");
		} else {
			System.out.println("Creating new account failed, you have entered account number that already exists.");
			return;
		}

	}

//	public static void saveTransaction() {
//		for (Account acc : createdAccounts) {
//			System.out.println(acc);
//		}
//	}

	public static void deposit(ArrayList<Account> createdAccounts) {
		System.out.print("Enter number of account you wish to deposit money to: ");
		int accountNumber = accountNumberInputCheck();
		if (accountNumber == 0) {
			System.out.println("Deposit failed, you have entered invalid account number.");
			return;
		}
		Account acc = findAccountWithRequestedAccountNumber(createdAccounts, accountNumber);
		if (acc == null) {
			System.out.println("Deposit failed, you have entered invalid account number.");
			return;
		} else {
			System.out.print("Enter amount of money you wish to deposit: ");
			double amountOfMoney = amountOfMoneyInputCheck();
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
		int accountNumber = accountNumberInputCheck();
		if (accountNumber == 0) {
			System.out.println("Withdrawal failed, you have entered invalid account number.");
			return;
		}
		Account acc = findAccountWithRequestedAccountNumber(createdAccounts, accountNumber);
		if (acc == null) {
			System.out.println("Withdrawal failed, you have entered non-existing account number.");
			return;
		} else {
			System.out.print("Enter amount of money you wish to withdraw: ");
			double amountOfMoney = amountOfMoneyInputCheck();
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
		int sourceAccountNumber = accountNumberInputCheck();
		if (sourceAccountNumber == 0) {
			System.out.println("Transfer failed, you have entered invalid source account number.");
			return;
		}
		System.out.print("Enter number of account you wish to transfer money to: ");
		int targetAccountNumber = accountNumberInputCheck();
		if (targetAccountNumber == 0) {
			System.out.println("Transfer failed, you have entered invalid target account number.");
			return;
		} else if (sourceAccountNumber == targetAccountNumber) {
			System.out.println("Transfer failed, you have entered the same source and target account numbers.");
			return;
		}
		System.out.print("Enter amount of money you wish to transfer: ");
		double amountOfMoney = amountOfMoneyInputCheck();
		if (amountOfMoney == 0) {
			System.out.println("Transfer failed, you have entered invalid amount of money.");
			return;
		}
		Account sourceAcc = findAccountWithRequestedAccountNumber(createdAccounts, sourceAccountNumber);
		if (sourceAcc == null) {
			System.out.println("Transfer failed, you have entered non-existing source account number.");
			return;
		}
		Account targetAcc = findAccountWithRequestedAccountNumber(createdAccounts, targetAccountNumber);
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

	// Method for finding Account with requested account number
	public static Account findAccountWithRequestedAccountNumber(ArrayList<Account> createdAccounts, int accountNumber) {
		for (int i = 0; i < createdAccounts.size(); i++) {
			if (createdAccounts.get(i).getAccountNumber() == accountNumber) {
				return createdAccounts.get(i);
			}
		}
		return null;
	}

	// Methods handling input with exceptions they return 0 if input is invalid
	public static int accountNumberInputCheck() {
		boolean continueInput = true;
		int inputNumber = 0;
		String answer = "";

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
		double inputNumber = 0;
		String answer = "";

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
