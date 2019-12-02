package atm;

import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class TestATM {

	public static void main(String[] args) throws IOException {

		ArrayList<Account> createdAccounts = new ArrayList<Account>();
//		ArrayList<Transaction> completedTransactions = new ArrayList<Transaction>();

		Scanner input = new Scanner(System.in);

		int menuChoice = 0;
		boolean continueInput = true;
		do {
			try {
				System.out.print("\nPlease choose one of the following options:" + "\n 1. Create Account \n 2. Deposit"
						+ "\n 3. Withdraw\n 4. Transfer" + "\n 5. Display Created Accounts \n 0. Log Out\n\n");

				menuChoice = input.nextInt();

				if (menuChoice < 0 || menuChoice > 5) {
					throw new InputMismatchException();
				}

				switch (menuChoice) {
				case 1:
					Transaction.createAccount(createdAccounts);
					break;
				case 2:
					Transaction.deposit(createdAccounts);
					break;
				case 3:
					Transaction.withdrawal(createdAccounts);
					break;
				case 4:
					Transaction.transfer(createdAccounts);
					break;
				case 5:
					Transaction.listOfAccounts(createdAccounts);
					break;
				case 0:
					System.out.println("Thank you!");
					input.close();
					return;
				}
			} catch (InputMismatchException ex) {
				System.out.println("You have tried to select non existing option, try again.");
				input.nextLine();
			}

		} while (continueInput);

	}

}
