package atm;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Check {
	public static Scanner input = new Scanner(System.in);

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

	// Method for finding Account with requested account number
	public static Account accountWithRequestedAccountNumberCheck(ArrayList<Account> createdAccounts, int accountNumber) {
		if(createdAccounts.isEmpty()) {
			return null;
		}
		
		for (int i = 0; i < createdAccounts.size(); i++) {
			if (createdAccounts.get(i).getAccountNumber() == accountNumber) {
				return createdAccounts.get(i);
			}
		}
		return null;
	}

	public static void isAnyAccountCreated(ArrayList<Account> createdAccounts) {

	}
}
